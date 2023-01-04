package com.codegym.repository.contract;

import com.codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select a.id,a.name,(cd.quantity * a.cost) as cost,a.unit,a.status from `contract` c join `contract_detail` cd on c.id = cd.contract_id join `attach_facility` a on cd.attach_facility_id = a.id where c.id = :id group by a.id",nativeQuery = true)
    List<AttachFacility> findById2(@Param("id") int id);


}
