package dev.sandenberg.questoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sandenberg.questoes.entity.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
}
