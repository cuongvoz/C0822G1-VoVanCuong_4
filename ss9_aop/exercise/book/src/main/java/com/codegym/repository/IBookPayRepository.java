package com.codegym.repository;

import com.codegym.model.PayBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookPayRepository extends JpaRepository<PayBook,Integer> {
}
