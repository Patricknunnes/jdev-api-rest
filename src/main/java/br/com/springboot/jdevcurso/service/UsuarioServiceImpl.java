package br.com.springboot.jdevcurso.service;

import br.com.springboot.jdevcurso.dto.UsuarioDto;
import br.com.springboot.jdevcurso.model.Usuario;
import br.com.springboot.jdevcurso.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll(String nome) {
        List<Usuario> usuarios;
        if (nome == null) {
            usuarios = usuarioRepository.findAll();
        } else {
            usuarios = usuarioRepository.findByNomeContaining(nome);
        }
        return usuarios;
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        usuarioRepository.save(Usuario.builder().idade(usuarioDto.getIdade()).nome(usuarioDto.getNome()).build());
        return usuarioDto;
    }

    @Override
    public void delete(Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            usuarioRepository.deleteById(id);
        } else {
            new RuntimeException();
        }
    }

    @Override
    public Usuario update(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuario.setNome(usuarioDto.getNome());
        usuario.setIdade(usuarioDto.getIdade());
        usuarioRepository.save(usuario);

        return usuario;
    }
}
