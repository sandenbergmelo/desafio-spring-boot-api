package dev.sandenberg.questoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questoes")
@Getter
@Setter
@NoArgsConstructor
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String resposta;
    private Integer ano;
    private String categoria;

    public Questao(String descricao, String resposta, Integer ano, String categoria) {
        this.descricao = descricao;
        this.resposta = resposta;
        this.ano = ano;
        this.categoria = categoria;
    }
}
