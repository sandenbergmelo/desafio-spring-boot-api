package dev.sandenberg.questoes.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import dev.sandenberg.questoes.dto.QuestaoRequestDTO;
import dev.sandenberg.questoes.dto.QuestaoResponseDTO;
import dev.sandenberg.questoes.entity.Questao;

@Mapper(componentModel = "spring")
public interface QuestaoMapper {
    QuestaoResponseDTO toResponseDto(Questao questao);

    @Mapping(target = "id", ignore = true)
    Questao requestDtoToEntity(QuestaoRequestDTO questaoRequestDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(QuestaoRequestDTO questaoRequestDTO, @MappingTarget Questao questao);

    List<QuestaoResponseDTO> toResponseDtoList(List<Questao> questoes);
}
