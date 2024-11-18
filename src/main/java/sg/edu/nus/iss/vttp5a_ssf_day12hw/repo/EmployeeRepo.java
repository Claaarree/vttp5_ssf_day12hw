package sg.edu.nus.iss.vttp5a_ssf_day12hw.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day12hw.model.Employee;
import sg.edu.nus.iss.vttp5a_ssf_day12hw.utils.TxtFileReader;

@Repository
public class EmployeeRepo {
    private TxtFileReader tfr = new TxtFileReader();
    private List<Employee> employeesList;

    public List<Employee> getEmployees(){
        employeesList = new ArrayList<>();

        List<String> linesRead = tfr.readFile();
        for (String line : linesRead){
            String firstName = line.split(",")[0];
            String lastName = line.split(",")[1];
            int age = Integer.parseInt(line.split(",")[2]);
            int salary = Integer.parseInt(line.split(",")[3]);

            Employee emp = new Employee(firstName, lastName, age, salary);
            employeesList.add(emp);
        }

        return employeesList;
    }

}
