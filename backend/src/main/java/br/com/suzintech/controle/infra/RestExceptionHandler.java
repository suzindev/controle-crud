package br.com.suzintech.controle.infra;

import br.com.suzintech.controle.domain.ApiError;
import br.com.suzintech.controle.exception.CrudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CrudException.class)
    private ResponseEntity<ApiError> crudExceptionHandler(CrudException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(
                        HttpStatus.UNPROCESSABLE_ENTITY,
                        exception.getMessage()
                ));
    }
}
