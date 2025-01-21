package api.hub.domain.usuario;

import api.hub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public RegistroUsuarioDTO registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        if (usuarioRepository.existsByEmail(registroUsuarioDTO.email())) {
            throw new ValidacionDeIntegridad("Disculpe este correo electrónico ya está registrado.");
        }

        if (usuarioRepository.existsByUsername(registroUsuarioDTO.username())) {
            throw new ValidacionDeIntegridad("Disculpe este nombre de usuario ya está en uso.");
        }

        var usuario = new Usuario(registroUsuarioDTO, passwordEncoder);
        usuarioRepository.save(usuario);
        return new RegistroUsuarioDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }

    public RegistroUsuarioDTO actualizacionUsuario(Long id, ActualizacionUsuarioDTO actualizacionUsuarioDTO) {
        var usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new ValidacionDeIntegridad("Disculpe el usuario con el ID proporcionado no existe.");
        }

        var usuario = usuarioOptional.get();

        usuario.actualizacionUsuario(actualizacionUsuarioDTO);

        usuarioRepository.save(usuario);
        return new RegistroUsuarioDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }
    public RegistroUsuarioDTO desactivarUser(Long id) {
        var usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new ValidacionDeIntegridad("Disculpe el usuario con el ID proporcionado no existe.");
        }

        var usuario = usuarioOptional.get();

        usuario.deactivateUser();

        usuarioRepository.save(usuario);
        return new RegistroUsuarioDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }
}