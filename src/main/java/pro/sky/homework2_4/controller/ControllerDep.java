package pro.sky.homework2_4.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2_4.Employee;
import pro.sky.homework2_4.service.DepService;
import pro.sky.homework2_4.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")

public class ControllerDep {

        private final DepService depService;

        public ControllerDep (DepService depService) {
            this.depService = depService;
        }

        @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryDep(@RequestParam int departmentId) {
            return depService.findMaxSalaryDep(departmentId);
        }

        @GetMapping(path = "/min-salary")
    public Employee findMinSalaryDep(@RequestParam int departmentId) {
        return depService.findMinSalaryDep(departmentId);
    }

        @GetMapping(path = "/all")
    public List <Employee> showAllDep(){
            return depService.showAllDep();
             }
        @GetMapping("all-by-dep")
    public List <Employee> showAllEmpInThisDep(@RequestParam int departmentId) {
            return depService.showAllEmpInThisDep(departmentId);
    }
}
