package dev.sandenberg.questoes.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record QuestaoFilterDTO(
    @Min(value = 1900, message = "O ano deve ser maior ou igual a 1900")
    @Max(value = 2100, message = "O ano deve ser menor ou igual a 2100")
    Integer ano,

    String descricao,
    String categoria
) {

}
