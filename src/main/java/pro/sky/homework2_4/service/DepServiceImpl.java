package pro.sky.homework2_4.service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_4.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepServiceImpl implements DepService {


    private final EmployeeServiceImpl employeeService;

    public DepServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryDep(int department) {
        Optional <Employee> employeeWithMaxSalary = employeeService.getEmployees().values().stream()
                .max(Comparator.comparing(Employee::getSalary));
        return employeeWithMaxSalary.orElseThrow();
    }

    @Override
    public Employee findMinSalaryDep(int department) {
        Optional <Employee> employeeWithMaxSalary = employeeService.getEmployees().values().stream()
                .min(Comparator.comparing(Employee::getSalary));
        return employeeWithMaxSalary.orElseThrow();
    }


    @Override
    public List <Employee> showAllDep(){

        return new ArrayList<>(employeeService.getEmployees().values());
}
    @Override
    public List <Employee> showAllEmpInThisDep(int department) {
        List<Employee> employees = employeeService.getEmployees().values().stream().
                filter(employee -> employee.getDepartment() == department).collect(Collectors.toList());
        return employees;
    }

}
