package dev.sandenberg.questoes.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record QuestaoFilterDTO(
    @Min(value = 1900, message = "O ano deve ser maior ou igual a 1900")
    @Max(value = 2100, message = "O ano deve ser menor ou igual a 2100")
    Integer ano,

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    String descricao,

    @Size(max = 50, message = "A categoria deve ter no máximo 50 caracteres")
    String categoria
) {

}
