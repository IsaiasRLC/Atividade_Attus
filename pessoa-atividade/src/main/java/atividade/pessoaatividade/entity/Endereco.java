package atividade.pessoaatividade.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;

    @OneToMany(mappedBy = "endereco")
    private List<Usuario> usuarios;



}
