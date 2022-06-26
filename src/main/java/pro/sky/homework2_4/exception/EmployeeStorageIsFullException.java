package pro.sky.homework2_4.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, reason = "ArrayIsFull")
public class EmployeeStorageIsFullException extends RuntimeException {
}
