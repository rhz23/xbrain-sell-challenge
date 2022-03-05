package com.rzaninelli.xbrain_sell_challenge.resources.exceptions;

import com.rzaninelli.xbrain_sell_challenge.services.exceptions.DatabaseException;
import com.rzaninelli.xbrain_sell_challenge.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Erro de Banco de dados";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
