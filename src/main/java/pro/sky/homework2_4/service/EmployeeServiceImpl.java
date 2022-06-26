package pro.sky.homework2_4.service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_4.Employee;
import pro.sky.homework2_4.exception.EmployeeAlreadyAddedException;
import pro.sky.homework2_4.exception.EmployeeNotFoundException;
import pro.sky.homework2_4.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List <Employee> employees = new ArrayList<>();


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee1 = new Employee (firstName, lastName);
        int maxCapacity = 2;
        if (employees.contains(employee1)) {
            throw new EmployeeAlreadyAddedException();
        }
        else if (employees.size() >= maxCapacity){
            throw new EmployeeStorageIsFullException();
        }
        else{
        employees.add(employee1);}
        return employee1;
    }


    public Employee deleteEmployee(String firstName, String lastName) {

      Employee employee1 = new Employee(firstName, lastName);

            if (!employees.contains(employee1)) {
            throw new EmployeeNotFoundException();
        }
           else {
               employees.remove(employee1);
            }

        return employee1;
    }

    public Employee findEmployee (String firstName, String lastName) {
        Employee employee1 = new Employee (firstName, lastName);
        if (!employees.contains(employee1)) {
            throw new EmployeeNotFoundException();
        }
        return employee1;
    }
    public List<Employee> showAll() {
        return employees;
    }
}
