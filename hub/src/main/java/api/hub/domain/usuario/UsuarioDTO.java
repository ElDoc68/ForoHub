package api.hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioDTO(
        @NotBlank(message = "Por favor utilice su correo electrónico como nombre de usuario.")
        @Email(message = "Disculpe correo electrónico inválido.")
        String email,

        @NotBlank(message = "Recuerd que debe tener entre 10 y 15 caracteres.")
        String password
) {
}
