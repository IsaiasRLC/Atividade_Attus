package atividade.pessoaatividade.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoUsuarioReponseDto {

    @NotNull
    @NotBlank
    private String logradouro;
    @NotNull
    @NotBlank
    private String cep;
    @NotNull
    @NotBlank
    private String numero;
    @NotNull
    @NotBlank
    private String cidade;
    @NotNull
    @NotBlank
    private String estado;




}
