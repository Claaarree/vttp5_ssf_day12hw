package sg.edu.nus.iss.vttp5a_ssf_day12hw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day12hw.model.Employee;
import sg.edu.nus.iss.vttp5a_ssf_day12hw.repo.EmployeeRepo;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepo empRepo;

    public List<Employee> getEmployees(){
        return empRepo.getEmployees();
    }
}
