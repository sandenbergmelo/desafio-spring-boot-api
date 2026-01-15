package dev.sandenberg.questoes.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import dev.sandenberg.questoes.entity.Questao;

public class QuestaoSpecification {
    public static Specification<Questao> anoEquals(Integer ano) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(ano)) {
                return null;
            }

            return builder.equal(root.get("ano"), ano);
        };
    }

    public static Specification<Questao> categoriaEquals(String categoria) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(categoria)) {
                return null;
            }

            return builder.equal(root.get("categoria"), categoria);
        };
    }

    public static Specification<Questao> descricaoContains(String descricao) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(descricao)) {
                return null;
            }

            return builder.like(builder.lower(root.get("descricao")), "%" + descricao.toLowerCase() + "%");
        };
    }
}
