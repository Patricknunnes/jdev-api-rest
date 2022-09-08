package br.com.springboot.jdevcurso.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UsuarioDto {

    private String nome;
    private int idade;
}
