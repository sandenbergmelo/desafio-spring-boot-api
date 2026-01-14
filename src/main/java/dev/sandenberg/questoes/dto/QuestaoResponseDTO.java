package dev.sandenberg.questoes.dto;

public record QuestaoResponseDTO(
    Long id,
    String descricao,
    String resposta,
    Integer ano,
    String categoria
) {

}
