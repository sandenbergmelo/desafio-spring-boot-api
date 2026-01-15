package dev.sandenberg.questoes.documentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dev.sandenberg.questoes.dto.ApiErrorDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "404",
    description = "Recurso não encontrado",
    content = @Content(schema = @Schema(implementation = ApiErrorDTO.class))
)
public @interface ApiNotFoundErrorResponse {
}
