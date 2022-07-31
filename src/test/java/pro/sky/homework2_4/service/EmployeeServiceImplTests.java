package pro.sky.homework2_4.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.homework2_4.Employee;
import pro.sky.homework2_4.exception.EmployeeAlreadyAddedException;
import pro.sky.homework2_4.exception.EmployeeNotFoundException;
import pro.sky.homework2_4.exception.EmployeeStorageIsFullException;

import static pro.sky.homework2_4.constants.EmployeeServiceImplTestConstants.*;

public class EmployeeServiceImplTests {

    @Test
    public void checkMtdAddNorm() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Employee expected = new Employee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        Employee actual = service.addEmployee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkMtdAddNegative() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        for (int i = 0; i < 10; i++) {
            char letter = (char) ('a' + i);
            service.addEmployee(FIRSTNAME + letter, LASTNAME + letter, SALARY, DEPARTMENT);
        }
        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> service.addEmployee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT));
    }

    @Test
    public void checkMtdAddEmployeeIfAlreadyAddNegative() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Employee expected = new Employee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        Employee actual = service.addEmployee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> service.addEmployee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT));
    }

    @Test
    public void checkMtdDeleteNegative() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> service.deleteEmployee(FIRSTNAME, LASTNAME));
    }

    @Test
    public void checkMtdDelete() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Employee expected = new Employee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        service.addEmployee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        Employee actual = service.deleteEmployee(FIRSTNAME, LASTNAME);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkMtdFindEmployee() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Employee expected = new Employee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT); //можно через BeforeEach, я уже понял
        service.addEmployee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        Employee actual = service.findEmployee(FIRSTNAME, LASTNAME);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkMtdFindNegative() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> service.findEmployee(FIRSTNAME, LASTNAME));
    }


}
