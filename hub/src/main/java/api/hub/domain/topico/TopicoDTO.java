package api.hub.domain.topico;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record TopicoDTO(
        @NotNull(message = "Recuerde que el título no se puede repetir.")
        String title,
        @NotNull(message = "Por favor utilice un lenguaje apropiado en el mensaje que no supere los 700 caracteres de longitud.")
        String message,
        @NotNull(message = "Seleccione uno de los siguientes estados ´ACTIVO´ o ´INACTIVO´.")
        Status status,
        @NotNull(message = "Por favor utilice su ID de autor de usuario_Id.")
        Long usuario_Id,
        @NotNull(message = "Recuerde utilizar el curso apropiado para su publicación.")
        String curso,
        LocalDateTime date
) {
}