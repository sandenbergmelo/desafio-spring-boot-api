package dev.sandenberg.questoes.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.sandenberg.questoes.dto.ApiErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiErrorDTO> handleResourceNotFound(ResourceNotFound e) {
        ApiErrorDTO body = new ApiErrorDTO(
            LocalDateTime.now().toString(),
            HttpStatus.NOT_FOUND.value(),
            "Recurso não encontrado",
            e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
