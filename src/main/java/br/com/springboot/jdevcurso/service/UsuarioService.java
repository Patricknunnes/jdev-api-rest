package br.com.springboot.jdevcurso.service;

import br.com.springboot.jdevcurso.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> getAll();

    UsuarioDto getById(Long id);

    UsuarioDto save(UsuarioDto usuarioDto);

    void delete(Long id);

    UsuarioDto update(Long id, UsuarioDto usuarioDto);
}
