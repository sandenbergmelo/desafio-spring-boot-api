package dev.sandenberg.questoes.dto;

public record ApiErrorDTO(
    String timestamp,
    int status,
    String error,
    String message
) {

}
