package br.com.springboot.jdevcurso.repository;

import br.com.springboot.jdevcurso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeContaining(String nome);
}