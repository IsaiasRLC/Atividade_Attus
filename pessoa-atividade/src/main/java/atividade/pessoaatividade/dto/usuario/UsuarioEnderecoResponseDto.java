package atividade.pessoaatividade.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDate;

@Data
public class UsuarioEnderecoResponseDto {


    @NotNull
    @NotBlank
    private String nomeCompleto;
    @NotNull
    private LocalDate dataNascimento;


    private EnderecoUsuarioReponseDto endereco;
}
