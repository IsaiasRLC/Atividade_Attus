package atividade.pessoaatividade.repository;


import atividade.pessoaatividade.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    List<Usuario> findByNomeCompletoEqualsIgnoreCase (String nomeCompleto);


    List<Usuario> findByDataNascimentoBetween (LocalDate data1, LocalDate idade2);

    List<Usuario> findByEnderecoEstadoLikeIgnoreCase(String estado);


}
