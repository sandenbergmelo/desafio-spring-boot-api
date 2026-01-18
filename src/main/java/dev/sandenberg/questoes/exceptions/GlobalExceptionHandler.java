package dev.sandenberg.questoes.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import dev.sandenberg.questoes.dto.ApiErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiErrorDTO> handleResourceNotFound(ResourceNotFound e) {
        ApiErrorDTO body = new ApiErrorDTO(
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        String errorMessage = e.getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .reduce((a, b) -> a + "; " + b)
                .orElse("Erro de validação");

        ApiErrorDTO body = buildBadRequestResponseBody(errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ApiErrorDTO> handleHandlerMethodValidation(HandlerMethodValidationException e) {
        String errorMessage = e.getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .reduce((a, b) -> a + "; " + b)
                .orElse("Erro de validação");

        ApiErrorDTO body = buildBadRequestResponseBody(errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGenericException(Exception e) {
        ApiErrorDTO body = new ApiErrorDTO(
            LocalDateTime.now().toString(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Erro interno do servidor",
            e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    private ApiErrorDTO buildBadRequestResponseBody(String errorMessage) {
        return new ApiErrorDTO(
            LocalDateTime.now().toString(),
            HttpStatus.BAD_REQUEST.value(),
            "Requisição inválida",
            errorMessage
        );
    }
}
