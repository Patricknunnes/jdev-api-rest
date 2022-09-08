package br.com.springboot.jdevcurso.service;

import br.com.springboot.jdevcurso.dto.UsuarioDto;
import br.com.springboot.jdevcurso.model.Usuario;
import br.com.springboot.jdevcurso.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDto> getAll(String nome) {
        List<UsuarioDto> usuariosDto = new ArrayList<>();
        if (nome == null) {
            List<Usuario> usuarios = usuarioRepository.findAll();
            usuarios.forEach(usuario -> {
                usuariosDto.add(new UsuarioDto(usuario.getNome(), usuario.getIdade()));
            });
        } else {
            List<Usuario> usuarios = usuarioRepository.findByNomeContaining(nome);
            usuarios.forEach(usuario -> {
                usuariosDto.add(new UsuarioDto(usuario.getNome(), usuario.getIdade()));
            });
        }
        return usuariosDto;
    }

    @Override
    public UsuarioDto getById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        return UsuarioDto.builder()
                .nome(usuario.getNome())
                .idade(usuario.getIdade())
                .build();
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
    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuario.setNome(usuarioDto.getNome());
        usuario.setIdade(usuarioDto.getIdade());
        usuarioRepository.save(usuario);

        return usuarioDto;
    }
}
