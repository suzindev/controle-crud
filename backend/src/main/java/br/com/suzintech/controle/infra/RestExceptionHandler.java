package br.com.suzintech.controle.infra;

import br.com.suzintech.controle.domain.ApiError;
import br.com.suzintech.controle.domain.ApiValidation;
import br.com.suzintech.controle.exception.CrudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CrudException.class)
    private ResponseEntity<ApiError> crudExceptionHandler(CrudException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(
                        HttpStatus.UNPROCESSABLE_ENTITY,
                        exception.getMessage()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ApiValidation> list = new ArrayList<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> list.add(new ApiValidation(
                        error.getField(),
                        error.getDefaultMessage()
                )));

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ApiError(
                        HttpStatus.BAD_REQUEST,
                        list
                ));
    }
}
