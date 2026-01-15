package dev.sandenberg.questoes.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record QuestaoRequestDTO(
    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 5, max = 255, message = "A descrição deve ter entre 5 e 255 caracteres")
    String descricao,

    @NotBlank(message = "A resposta é obrigatória")
    @Size(min = 1, max = 200, message = "A resposta deve ter entre 1 e 200 caracteres")
    String resposta,

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1900, message = "O ano deve ser maior ou igual a 1900")
    @Max(value = 2100, message = "O ano deve ser menor ou igual a 2100")
    Integer ano,

    @NotBlank(message = "A categoria é obrigatória")
    @Size(min = 3, max = 50, message = "A categoria deve ter entre 3 e 50 caracteres")
    String categoria
) {

}
