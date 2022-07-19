package pro.sky.homework2_4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Somebody USED INVALID symbols")
public class EmployeeSmbUsedInvalidSymbols extends RuntimeException {
}
