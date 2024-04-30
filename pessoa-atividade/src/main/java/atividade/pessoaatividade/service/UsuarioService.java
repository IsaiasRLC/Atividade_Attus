package atividade.pessoaatividade.service;


import atividade.pessoaatividade.entity.Usuario;
import atividade.pessoaatividade.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;


    public List<Usuario> buscarTodos(){

        List<Usuario> all = repository.findAll();

        return all;
    }

    public Usuario buscarPorUsuario(Integer id){

        Optional<Usuario> byId = repository.findById(id);

        return byId.get();
    }

    public List<Usuario> buscarPorNome (String nome){
        List<Usuario> listaPorNome = repository.findByNomeCompletoEqualsIgnoreCase(nome);

        return listaPorNome;

    }

    public List<Usuario> buscarPorFiltroDeData (LocalDate data1, LocalDate data2){

        List<Usuario> listaPorData = repository.findByDataNascimentoBetween(data1, data2);

        return listaPorData;
    }


    public Usuario criarUsuario (Usuario usuario){
        return repository.save(usuario);
    }

    public List<Usuario> buscarUsuariosPorEstado (String nomeEstado){
        return repository.findByEnderecoEstadoLikeIgnoreCase(nomeEstado);
    }




}
