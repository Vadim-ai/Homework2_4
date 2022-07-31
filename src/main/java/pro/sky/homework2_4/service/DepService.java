package pro.sky.homework2_4.service;

import pro.sky.homework2_4.Employee;

import java.util.List;

public interface DepService {

    Employee findMaxSalaryDep(int department);

    Employee findMinSalaryDep(int department);
    List<Employee> showAllDep();

    List <Employee> showAllEmpInThisDep (int department);
}
