package atividade.pessoaatividade.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioDto {

    @NotNull
    @NotBlank
    private String nomeCompleto;
    @NotNull
    @NotBlank
    private LocalDate dataNascimento;



}
