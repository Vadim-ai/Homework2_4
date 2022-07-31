package pro.sky.homework2_4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "EmployeeAlreadyAdded")
public class EmployeeAlreadyAddedException extends RuntimeException {

}
