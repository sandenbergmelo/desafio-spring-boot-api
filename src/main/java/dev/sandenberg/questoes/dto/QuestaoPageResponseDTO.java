package dev.sandenberg.questoes.dto;

import java.util.List;

import org.springframework.data.domain.Page;

public record QuestaoPageResponseDTO(
    List<QuestaoResponseDTO> content,
    int page,
    int size,
    long totalElements,
    int totalPages
) {
    public static QuestaoPageResponseDTO of(Page<QuestaoResponseDTO> page) {
        return new QuestaoPageResponseDTO(
            page.getContent(),
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages()
        );
    }
}
