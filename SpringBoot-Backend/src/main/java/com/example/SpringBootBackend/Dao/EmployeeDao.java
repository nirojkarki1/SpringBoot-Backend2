package com.example.SpringBootBackend.Dao;

import com.example.SpringBootBackend.Enitity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {

//Optional<Employee> findByName(String username);


}
