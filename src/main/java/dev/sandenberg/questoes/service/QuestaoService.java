package dev.sandenberg.questoes.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.sandenberg.questoes.dto.QuestaoRequestDTO;
import dev.sandenberg.questoes.entity.Questao;
import dev.sandenberg.questoes.exceptions.ResourceNotFound;
import dev.sandenberg.questoes.repository.QuestaoRepository;

@Service
public class QuestaoService {
    private final QuestaoRepository questaoRepository;

    public QuestaoService(QuestaoRepository questaoRepository) {
        this.questaoRepository = questaoRepository;
    }

    public Questao create(QuestaoRequestDTO questaoRequestDTO) {
        Questao questao = new Questao(
                questaoRequestDTO.descricao(),
                questaoRequestDTO.resposta(),
                questaoRequestDTO.ano(),
                questaoRequestDTO.categoria());

        return questaoRepository.save(questao);
    }

    public List<Questao> getAll() {
        return questaoRepository.findAll(Sort.by("id"));
    }

    public Questao getById(Long id) throws ResourceNotFound {
        return questaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Questão não encontrada"));
    }

    public Questao updateById(Long id, QuestaoRequestDTO questaoRequestDTO) throws ResourceNotFound {
        Questao questao = questaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Questão não encontrada"));

        questao.setDescricao(questaoRequestDTO.descricao());
        questao.setResposta(questaoRequestDTO.resposta());
        questao.setAno(questaoRequestDTO.ano());
        questao.setCategoria(questaoRequestDTO.categoria());

        return questaoRepository.save(questao);
    }

    public void deleteById(Long id) throws ResourceNotFound {
        if (!questaoRepository.existsById(id)) {
            throw new ResourceNotFound("Questão não encontrada");
        }

        questaoRepository.deleteById(id);
    }
}
