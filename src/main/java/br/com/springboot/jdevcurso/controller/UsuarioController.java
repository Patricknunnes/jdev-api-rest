package br.com.springboot.jdevcurso.controller;

import br.com.springboot.jdevcurso.dto.UsuarioDto;
import br.com.springboot.jdevcurso.model.Usuario;
import br.com.springboot.jdevcurso.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jdev")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping
    public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioServiceImpl.save(usuarioDto));
    }

    @GetMapping
    public List<Usuario> getAll(@RequestParam(required = false) String nome) {
        return usuarioServiceImpl.getAll(nome);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return usuarioServiceImpl.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return usuarioServiceImpl.update(id, usuarioDto);
    }

}