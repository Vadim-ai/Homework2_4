package pro.sky.homework2_4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.homework2_4.Employee;
import pro.sky.homework2_4.exception.EmployeeAlreadyAddedException;
import pro.sky.homework2_4.exception.EmployeeNotFoundException;
import pro.sky.homework2_4.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private Map <String, Employee> employees = new HashMap<>();

    public Map <String, Employee> getEmployees(){
        return employees;
    }


    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee (firstName, lastName, salary, department);
        int maxCapacity = 10;
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
