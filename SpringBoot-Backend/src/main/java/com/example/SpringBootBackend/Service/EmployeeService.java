package com.example.SpringBootBackend.Service;

import com.example.SpringBootBackend.Dao.EmployeeDao;
import com.example.SpringBootBackend.Enitity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private static EmployeeDao employeeDao;
    @Autowired
    private static PasswordEncoder passwordEncoder;


    public static String addEmployee(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
       employeeDao.save(employee);
       return "user added to system ";
    }
}
