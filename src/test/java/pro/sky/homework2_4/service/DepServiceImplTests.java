package pro.sky.homework2_4.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework2_4.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

    public class DepServiceImplTests {
        private final Employee employee = new Employee("Гурген", "Ахметов", 1200, 2);
        private final Employee employee1 = new Employee("Маншур", "Задович", 1300, 1);
        private final Employee employee2 = new Employee("Абдулрахман", "Кадыров", 1400, 1);
        private final   Map<String, Employee> employees = new HashMap<>();
        @Mock
        private EmployeeServiceImpl employeeServiceMock;

        @BeforeEach
                public void setUp() {

            employees.put(employee.getFullName(), employee);
            employees.put(employee1.getFullName(), employee1);
            employees.put(employee2.getFullName(), employee2);
        }
        @InjectMocks
        DepServiceImpl depServiceImpl;

    @Test
    public void checkMtdShowAllDep () {
        List<Employee> expected = new ArrayList<>();
        expected.add(employee);
        expected.add(employee1);
        expected.add(employee2);
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
       List<Employee> actual = depServiceImpl.showAllDep();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkFindMaxSalaryDep() {
        Employee expected = employee2;
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        Employee actual = depServiceImpl.findMaxSalaryDep(1);
        Assertions.assertEquals(expected,actual);

        }

    @Test
    public void checkFindMinSalaryDep() {
        Employee expected = employee1;
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        Employee actual = depServiceImpl.findMinSalaryDep(1);
        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void checkMtdShowAllEmpInThisDep () {
        List<Employee> expected = new ArrayList<>();
        expected.add(employee1);
        expected.add(employee2);
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        List<Employee> actual = depServiceImpl.showAllEmpInThisDep(1);
        Assertions.assertEquals(expected, actual);
    }



    }

