package dev.sandenberg.questoes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.sandenberg.questoes.dto.QuestaoRequestDTO;
import dev.sandenberg.questoes.dto.QuestaoResponseDTO;
import dev.sandenberg.questoes.service.QuestaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/questoes")
@Tag(name = "Questões", description = "Endpoints para gerenciar questões")
public class QuestaoController {
    private final QuestaoService questaoService;

    public QuestaoController(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Criar uma nova questão", description = "Cria uma nova questão com os dados fornecidos")
    public ResponseEntity<QuestaoResponseDTO> createQuestao(@Valid @RequestBody QuestaoRequestDTO questaoDTO) {
        QuestaoResponseDTO createdQuestao = questaoService.create(questaoDTO);
        return ResponseEntity.created(null).body(createdQuestao);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Obter todas as questões", description = "Retorna uma lista com todas as questões cadastradas")
    public List<QuestaoResponseDTO> getAllQuestoes() {
        return questaoService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Obter questão por ID", description = "Retorna os detalhes de uma questão específica pelo seu ID")
    public ResponseEntity<QuestaoResponseDTO> getQuestaoById(@PathVariable @Positive Long id) {
        QuestaoResponseDTO questao = questaoService.getById(id);
        return ResponseEntity.ok(questao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar questão por ID", description = "Deleta uma questão específica pelo seu ID")
    public ResponseEntity<Void> deleteQuestaoById(@PathVariable @Positive Long id) {
        questaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Atualizar questão por ID", description = "Atualiza os dados de uma questão específica pelo seu ID")
    public ResponseEntity<QuestaoResponseDTO> updateQuestaoById(
            @PathVariable @Positive Long id,
            @Valid @RequestBody QuestaoRequestDTO questaoDTO
        ) {
        QuestaoResponseDTO updatedQuestao = questaoService.updateById(id, questaoDTO);
        return ResponseEntity.ok(updatedQuestao);
    }
}
