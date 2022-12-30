package com.codegym.repository.contract;

import com.codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select a.* from `contract` c join `contract_detail` cd on c.id = cd.contract_id join `attach_facility` a on cd.attach_facility_id = a.id where c.id = :id",nativeQuery = true)
    List<AttachFacility> findById(@Param("id") int id);
}
