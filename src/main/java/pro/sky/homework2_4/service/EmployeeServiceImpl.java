package pro.sky.homework2_4.service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_4.Employee;
import pro.sky.homework2_4.exception.EmployeeAlreadyAddedException;
import pro.sky.homework2_4.exception.EmployeeNotFoundException;
import pro.sky.homework2_4.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map <String, Employee> employees = new HashMap<>();


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee (firstName, lastName);
        int maxCapacity = 2;
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        else if (employees.size() >= maxCapacity){
            throw new EmployeeStorageIsFullException();
        }
        else{
        employees.put(employee.getFullName(),employee);}
        return employee;
    }


    public Employee deleteEmployee(String firstName, String lastName) {

      Employee employee = new Employee(firstName, lastName);

            if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
           else {
                return employees.remove(employee.getFullName());
            }
    }

    public Employee findEmployee (String firstName, String lastName) {
        Employee employee = new Employee (firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    public List <Employee> showAll() {
        return new ArrayList<>(employees.values());
    }
}
