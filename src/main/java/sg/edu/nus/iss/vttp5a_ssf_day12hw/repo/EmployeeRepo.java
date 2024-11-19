package sg.edu.nus.iss.vttp5a_ssf_day12hw.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import sg.edu.nus.iss.vttp5a_ssf_day12hw.model.Employee;
import sg.edu.nus.iss.vttp5a_ssf_day12hw.utils.TxtFileReaderWriter;

@Repository
public class EmployeeRepo {
    private TxtFileReaderWriter tfrw = new TxtFileReaderWriter();
    private List<Employee> employeesList;

    public List<Employee> getEmployees(){
        employeesList = new ArrayList<>();

        List<String> linesRead = tfrw.readFile();
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

    public void addNewEmployee(MultiValueMap<String, String> form) {
        String firstName = form.getFirst("firstName");
        String lastName = form.getFirst("lastName");
        String age = form.getFirst("age");
        String salary = form.getFirst("salary");

        String line = firstName + "," + lastName + "," + age + "," + salary;
        tfrw.writeFile(line);
    }

}
