package com.pretest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pretest.demo.model.Customer;

public interface custrepository extends JpaRepository<Customer, Long> {

}
