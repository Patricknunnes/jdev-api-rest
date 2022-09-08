package br.com.springboot.jdevcurso.service;

import br.com.springboot.jdevcurso.dto.UsuarioDto;
import br.com.springboot.jdevcurso.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll(String nome);

    Usuario getById(Long id);

    UsuarioDto save(UsuarioDto usuarioDto);

    void delete(Long id);

    Usuario update(Long id, UsuarioDto usuarioDto);
}
