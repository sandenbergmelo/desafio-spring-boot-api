package dev.sandenberg.questoes.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;

import dev.sandenberg.questoes.dto.QuestaoRequestDTO;
import dev.sandenberg.questoes.entity.Questao;
import dev.sandenberg.questoes.mapper.QuestaoMapper;
import dev.sandenberg.questoes.specification.QuestaoSpecification;
import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class QuestaoRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private QuestaoRepository questaoRepository;

    private final QuestaoMapper questaoMapper = Mappers
            .getMapper(QuestaoMapper.class);

    private Questao questao1;
    private Questao questao2;
    private Questao questao3;

    @BeforeEach
    void insertQuestoes() {
        questao1 = createQuestao(new QuestaoRequestDTO("Descricao 1", "Resposta A", 2020, "Categoria A"));
        questao2 = createQuestao(new QuestaoRequestDTO("Descricao 2", "Resposta B", 2021, "Categoria A"));
        questao3 = createQuestao(new QuestaoRequestDTO("Descricao 3", "Resposta C", 2020, "Categoria B"));
    }

    @Test
    @DisplayName("Should get questoes with filters from database correctly - Case 1")
    void findQuestoesWithFiltersCase1() {
        int filterAno = 2020;
        String filterCategoria = "Categoria A";

        Specification<Questao> specification = Specification
                .where(QuestaoSpecification.anoEquals(filterAno))
                .and(QuestaoSpecification.categoriaEquals(filterCategoria));

        var result = questaoRepository.findAll(specification);

        assertTrue(result.contains(questao1));
        assertTrue(!result.contains(questao2));
        assertTrue(!result.contains(questao3));
    }

    @Test
    @DisplayName("Should get questoes with filters from database correctly - Case 2")
    void findQuestoesWithFiltersCase2() {
        int filterAno = 2020;
        String filterCategoria = "Categoria B";

        Specification<Questao> specification = Specification
                .where(QuestaoSpecification.anoEquals(filterAno))
                .and(QuestaoSpecification.categoriaEquals(filterCategoria));

        var result = questaoRepository.findAll(specification);

        assertTrue(!result.contains(questao1));
        assertTrue(!result.contains(questao2));
        assertTrue(result.contains(questao3));
    }

    private Questao createQuestao(QuestaoRequestDTO dto) {
        Questao questao = questaoMapper.requestDtoToEntity(dto);
        entityManager.persist(questao);

        return questao;
    }

}
