//package com.example.SpringBootBackend.Service;
//
//import com.example.SpringBootBackend.Dao.EmployeeDao;
//import com.example.SpringBootBackend.Enitity.Employee;
//import com.example.SpringBootBackend.Exception.ResourceNotFoundException;
//import com.example.SpringBootBackend.config.EmployeeUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//
//public class EmployeeDetailService implements UserDetailsService {
//
//    @Autowired
//    private EmployeeDao employeeDao;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//     Optional<Employee> employee = employeeDao.findByName(username);
//
//        return employee.map(EmployeeUserDetails::new)
//                .orElseThrow(()->  new UsernameNotFoundException("Employee Not Found" + username));
//    }
//}
