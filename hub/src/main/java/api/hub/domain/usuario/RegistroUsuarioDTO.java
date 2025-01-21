package api.hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegistroUsuarioDTO(
        Long id, @NotBlank
        String name,
        @NotBlank (message = "Utilice por favor su correo electrónico como nombre de usuario.")
        @Email
        String username,
        @NotBlank
        String email,
        @NotBlank(message = "Recuerde que debe tener entre 6 y 10 caracteres.") @Pattern(regexp = "\\d{6,10}")
        String password
) {
        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getEmail() {
                return email;
        }

}