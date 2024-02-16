package co.nea.istandvdo.api.exception;

import co.nea.istandvdo.api.base.RestError;
import co.nea.istandvdo.api.base.VaildationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)  // when wrong status
@RestControllerAdvice
@Slf4j
public class AppException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)  // handle
    RestError<?> handleMethodArgumentNotVaildException(MethodArgumentNotValidException ex){

        // list field error all
        List<VaildationError> vaildationErrors = new ArrayList<>();
        for(FieldError fieldError : ex.getFieldErrors()){
            var validationError = VaildationError.builder()
                    .field(fieldError.getField())
                    .detail(fieldError.getDefaultMessage())
                    .build();
            vaildationErrors.add(validationError); // Corrected method name
        }

       return  RestError.builder()
               .message("Bad Request")
               .code(HttpStatus.BAD_REQUEST.value())
               .status(false)
               .timestamp(new Timestamp(System.currentTimeMillis()))
               .errors(vaildationErrors)
        .build();

}
}
