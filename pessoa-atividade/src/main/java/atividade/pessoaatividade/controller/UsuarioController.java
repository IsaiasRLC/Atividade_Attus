package atividade.pessoaatividade.controller;


import atividade.pessoaatividade.dto.endereco.mapper.EnderecoMapper;
import atividade.pessoaatividade.dto.usuario.UsuarioEnderecoResponseDto;
import atividade.pessoaatividade.entity.Usuario;
import atividade.pessoaatividade.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;


    @GetMapping
    public ResponseEntity<List<UsuarioEnderecoResponseDto>> findAll() {

        List<Usuario> usuarios = service.buscarTodos();

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UsuarioEnderecoResponseDto> lista = new ArrayList<>();

        for (Usuario usuarioDaVez : usuarios) {

            UsuarioEnderecoResponseDto atletaModificado = EnderecoMapper.toUsuarioEnderecoResponseDto(usuarioDaVez);
            lista.add(atletaModificado);
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id")
    public ResponseEntity<UsuarioEnderecoResponseDto> findByID(@RequestParam Integer id) {
        Usuario usuario = service.buscarPorUsuario(id);

        if (usuario == null) {
            return ResponseEntity.noContent().build();
        }

        UsuarioEnderecoResponseDto atletaEquipeResponseDto = EnderecoMapper.toUsuarioEnderecoResponseDto(usuario);

        return ResponseEntity.ok(atletaEquipeResponseDto);
    }

    @GetMapping("/nome/usuario")
    public ResponseEntity<List<UsuarioEnderecoResponseDto>> findByNomeUsuario(@RequestParam String nomeUsuario) {

        List<Usuario> usuarios = service.buscarPorNome(nomeUsuario);

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<UsuarioEnderecoResponseDto> listaModificada = new ArrayList<>();
        for (Usuario usuarioDaVez : usuarios) {
            UsuarioEnderecoResponseDto usuarioEnderecoResponseDto = EnderecoMapper.toUsuarioEnderecoResponseDto(usuarioDaVez);

            listaModificada.add(usuarioEnderecoResponseDto);
        }

        return ResponseEntity.ok(listaModificada);
    }

    @GetMapping("/data/nascimento")
    public ResponseEntity<List<UsuarioEnderecoResponseDto>> findByDataNascimento(@RequestParam LocalDate data1, @RequestParam LocalDate data2 ) {

        List<Usuario> usuarios = service.buscarPorFiltroDeData(data1,data2);

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }


        List<UsuarioEnderecoResponseDto> listaModificada = new ArrayList<>();
        for (Usuario usuarioDaVez : usuarios) {
            UsuarioEnderecoResponseDto usuarioEnderecoResponseDto = EnderecoMapper.toUsuarioEnderecoResponseDto(usuarioDaVez);

            listaModificada.add(usuarioEnderecoResponseDto);
        }

        return ResponseEntity.ok(listaModificada);
    }


    @GetMapping("/estado")
    public ResponseEntity<List<UsuarioEnderecoResponseDto>> buscarUsuarioPorEstado (@RequestParam String nomeEstado){
        List<Usuario> usuarios = service.buscarUsuariosPorEstado(nomeEstado);

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<UsuarioEnderecoResponseDto> listaModificada = new ArrayList<>();
        for (Usuario usuarioDaVez : usuarios) {
            UsuarioEnderecoResponseDto usuarioEnderecoResponseDto = EnderecoMapper.toUsuarioEnderecoResponseDto(usuarioDaVez);

            listaModificada.add(usuarioEnderecoResponseDto);
        }

        return ResponseEntity.ok(listaModificada);


    }


    @PostMapping
    public  ResponseEntity<UsuarioEnderecoResponseDto> newUsuario (@RequestBody Usuario novo){
        Usuario usuario = service.criarUsuario(novo);

                if (usuario == null){
                    return ResponseEntity.badRequest().build();
                }

        UsuarioEnderecoResponseDto usuarioEnderecoResponseDto = EnderecoMapper.toUsuarioEnderecoResponseDto(usuario);

        return ResponseEntity.ok(usuarioEnderecoResponseDto);

    }


}



