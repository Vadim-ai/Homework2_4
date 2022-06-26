package pro.sky.homework2_4.service;

import pro.sky.homework2_4.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee (String firstName, String lastName);
    Employee deleteEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);

    List <Employee> showAll ();
}
