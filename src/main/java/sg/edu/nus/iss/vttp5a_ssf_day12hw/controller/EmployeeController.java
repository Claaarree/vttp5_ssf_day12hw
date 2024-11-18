package sg.edu.nus.iss.vttp5a_ssf_day12hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_ssf_day12hw.model.Employee;
import sg.edu.nus.iss.vttp5a_ssf_day12hw.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping()
    public String getEmployees(Model model){
        List<Employee> employeesList = empService.getEmployees();
        model.addAttribute("employees", employeesList);

        return "employeeList";
    }
    
}
