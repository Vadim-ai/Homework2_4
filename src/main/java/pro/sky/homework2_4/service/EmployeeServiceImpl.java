package pro.sky.homework2_4.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.homework2_4.Employee;
import pro.sky.homework2_4.exception.*;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private Map <String, Employee> employees = new HashMap<>();

    public Map <String, Employee> getEmployees(){
        return employees;
    }


    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        int maxCapacity = 10;
       if (employees.size() >= maxCapacity) {
            throw new EmployeeStorageIsFullException();

        } else if (StringUtils.isEmpty(employee.getFirstName())) {
            throw new EmployeeFirstnameIsEmpty();

        } else if (StringUtils.isEmpty(employee.getLastName())) {
            throw new EmployeeLastNameIsEmpty();

        } else if (!StringUtils.isAlpha(employee.getFirstName()))
        {
            throw new EmployeeSmbUsedInvalidSymbols();
        }
        else if (!StringUtils.isAlpha(employee.getLastName()))
        {
            throw new EmployeeSmbUsedInvalidSymbols();
        }

        if(StringUtils.isMixedCase(employee.getFirstName()))
        {
            employee.setFirstName(StringUtils.lowerCase(employee.getFirstName()));
        }
        if(StringUtils.isMixedCase(employee.getLastName()))
        {
            employee.setLastName(StringUtils.lowerCase(employee.getLastName()));
        }

        if (StringUtils.isAllLowerCase(employee.getFirstName())){
            employee.setFirstName(StringUtils.capitalize(employee.getFirstName()));
        }
        if (StringUtils.isAllLowerCase(employee.getLastName())){
            employee.setLastName(StringUtils.capitalize(employee.getLastName()));
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();}

        employees.put(employee.getFullName(),employee);
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
