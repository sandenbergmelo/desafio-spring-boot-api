package dev.sandenberg.questoes.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.sandenberg.questoes.dto.QuestaoRequestDTO;
import dev.sandenberg.questoes.dto.QuestaoResponseDTO;
import dev.sandenberg.questoes.entity.Questao;
import dev.sandenberg.questoes.exceptions.ResourceNotFound;
import dev.sandenberg.questoes.mapper.QuestaoMapper;
import dev.sandenberg.questoes.repository.QuestaoRepository;

@Service
public class QuestaoService {
    private final QuestaoRepository questaoRepository;
    private final QuestaoMapper questaoMapper;

    public QuestaoService(QuestaoRepository questaoRepository, QuestaoMapper questaoMapper) {
        this.questaoRepository = questaoRepository;
        this.questaoMapper = questaoMapper;
    }

    public QuestaoResponseDTO create(QuestaoRequestDTO questaoRequestDTO) {
        Questao questaoToSave = questaoMapper.requestDtoToEntity(questaoRequestDTO);
        Questao savedQuestao = questaoRepository.save(questaoToSave);
        return questaoMapper.toResponseDto(savedQuestao);
    }

    public List<QuestaoResponseDTO> getAll() {
        List<Questao> questoes = questaoRepository.findAll(Sort.by("id"));
        return questaoMapper.toResponseDtoList(questoes);
    }

    public QuestaoResponseDTO getById(Long id) throws ResourceNotFound {
        Questao fetched = questaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Questão não encontrada"));

        return questaoMapper.toResponseDto(fetched);
    }

    public QuestaoResponseDTO updateById(Long id, QuestaoRequestDTO questaoRequestDTO) throws ResourceNotFound {
        Questao questao = questaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Questão não encontrada"));

        questaoMapper.updateEntityFromDto(questaoRequestDTO, questao);
        Questao updatedQuestao = questaoRepository.save(questao);

        return questaoMapper.toResponseDto(updatedQuestao);
    }

    public void deleteById(Long id) throws ResourceNotFound {
        if (!questaoRepository.existsById(id)) {
            throw new ResourceNotFound("Questão não encontrada");
        }

        questaoRepository.deleteById(id);
    }
}
