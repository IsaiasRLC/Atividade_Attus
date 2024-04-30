package atividade.pessoaatividade.dto.endereco;

import atividade.pessoaatividade.dto.usuario.UsuarioEnderecoResponseDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class EnderecoDto {

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

    private List<UsuarioEnderecoResponseDto> listaEnderecos ;
}
