package manajemen.buku.controller;

import jakarta.validation.ConstraintViolationException;
import manajemen.buku.Responses.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<WebResponse<String>> constraintViolationException(ConstraintViolationException th){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(WebResponse.<String>builder()
                        .errors(th.getMessage())
                        .build()
                );
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<WebResponse<String>> apiException(ResponseStatusException th){
        return ResponseEntity.status(th.getStatusCode())
                .body(WebResponse.<String>builder()
                        .errors(th.getReason())
                        .build()
                );
    }
}
