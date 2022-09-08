package br.com.springboot.jdevcurso.controller;

import br.com.springboot.jdevcurso.dto.UsuarioDto;
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
    public List<UsuarioDto> getAll() {
        List<UsuarioDto> response = usuarioServiceImpl.getAll();
        return response;
    }

    @GetMapping("/{id}")
    public UsuarioDto getById(@PathVariable Long id) {
        return usuarioServiceImpl.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public UsuarioDto update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return usuarioServiceImpl.update(id, usuarioDto);
    }

}