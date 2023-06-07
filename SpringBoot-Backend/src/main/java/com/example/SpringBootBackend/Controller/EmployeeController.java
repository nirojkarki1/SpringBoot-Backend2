package com.example.SpringBootBackend.Controller;

import com.example.SpringBootBackend.Dao.EmployeeDao;
import com.example.SpringBootBackend.Enitity.Employee;
import com.example.SpringBootBackend.Exception.ResourceNotFoundException;
import com.example.SpringBootBackend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to all User";
    }

    @PostMapping("/new")
    public String addnewEmployee( @RequestBody Employee employee){
      return EmployeeService.addEmployee(employee);
    }

    //Get all employees
    @GetMapping("/employees")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Employee> getAllEmployee(){
        return employeeDao.findAll();

    }
    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeDao.save(employee);
    }

    // get employee by id rest api
    @GetMapping("employees/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public  ResponseEntity<Employee> getEmployeeById( @PathVariable Long id){
        Employee employee = employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

//        employee.setFirstName(employeeDetails.getFirstName());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeDao.save(employee);
        return ResponseEntity.ok(employee);

    }

    // update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee( @PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

         employee.setFirstName(employeeDetails.getFirstName());
         employee.setLastName(employeeDetails.getLastName());
         employee.setEmailId(employeeDetails.getEmailId());
         employee.setPassword(employeeDetails.getPassword());
         employee.setRole(employeeDetails.getRole());

         Employee updateEmployee = employeeDao.save(employee);
         return ResponseEntity.ok(updateEmployee);


    }
}
