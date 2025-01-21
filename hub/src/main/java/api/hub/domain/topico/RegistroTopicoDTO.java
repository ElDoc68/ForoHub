package api.hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroTopicoDTO (
        @NotBlank(message = "Recuerde que el título es obligatorio.")
        String title,
        @NotBlank(message = "Recuerde que el mensaje es obligatorio.")
        String message,
        @NotBlank(message = "Recuerde que el curso es obligatorio.")
        String course,
        @NotNull(message = "Recuerde que el author_id es obligatorio.")
        Long author_id
) {

    public RegistroTopicoDTO(String title, String message, String course, Long author_id){
        this.title = title;
        this.message = message;
        this.course = course;
        this.author_id = author_id;
    }
}