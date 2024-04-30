package atividade.pessoaatividade.dto.endereco.mapper;



import atividade.pessoaatividade.dto.endereco.EnderecoDto;
import atividade.pessoaatividade.dto.usuario.EnderecoUsuarioReponseDto;
import atividade.pessoaatividade.dto.usuario.UsuarioEnderecoResponseDto;
import atividade.pessoaatividade.entity.Endereco;
import atividade.pessoaatividade.entity.Usuario;

import java.util.List;


public class EnderecoMapper {

        public static EnderecoDto toEnderecoDto (Endereco enderecoEntidade){

            if(enderecoEntidade == null){
                return null;
            }

            EnderecoDto enderecoDto = new EnderecoDto();

            enderecoDto.setLogradouro(enderecoDto.getLogradouro());
            enderecoDto.setCep(enderecoDto.getCep());
            enderecoDto.setNumero(enderecoDto.getNumero());
            enderecoDto.setCidade(enderecoDto.getCidade());
            enderecoDto.setEstado(enderecoDto.getEstado());

            if(!enderecoEntidade.getUsuarios().isEmpty()){
                List<Usuario> atletas = enderecoEntidade.getUsuarios();

                List<UsuarioEnderecoResponseDto> usuariosDtos = atletas.stream().map(EnderecoMapper::toUsuarioEnderecoResponseDto).toList();

                enderecoDto.setListaEnderecos(usuariosDtos);
            }

            return enderecoDto;
        }

        public static UsuarioEnderecoResponseDto toUsuarioEnderecoResponseDto (Usuario usuarioEntidade){


            if(usuarioEntidade == null){
                return null;
            }

            UsuarioEnderecoResponseDto usuarioResponse = new UsuarioEnderecoResponseDto();

            usuarioResponse.setNomeCompleto(usuarioEntidade.getNomeCompleto());
            usuarioResponse.setDataNascimento(usuarioEntidade.getDataNascimento());


            EnderecoUsuarioReponseDto usuarioReponseDto = enderecoUsuarioReponseDto(usuarioEntidade.getEndereco());
            usuarioResponse.setEndereco(usuarioReponseDto);
            return usuarioResponse;
        }


        public static EnderecoUsuarioReponseDto enderecoUsuarioReponseDto (Endereco endereco){


            if(endereco == null){
                return null;
            }

            EnderecoUsuarioReponseDto usuarioReponseDto = new EnderecoUsuarioReponseDto();

            usuarioReponseDto.setLogradouro(endereco.getLogradouro());
            usuarioReponseDto.setCep(endereco.getCep());
            usuarioReponseDto.setNumero(endereco.getNumero());
            usuarioReponseDto.setCidade(endereco.getCidade());
            usuarioReponseDto.setEstado(endereco.getEstado());

            return usuarioReponseDto;



        }









}