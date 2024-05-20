package org.desafio.desafioback.controller;

import org.desafio.desafioback.models.dto.ContatoDto;
import org.desafio.desafioback.models.entity.Contato;
import org.desafio.desafioback.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController()
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }


    @GetMapping("/contato/todos")
    public ResponseEntity<List<Contato>> getContato() {
       List<Contato> contatos =  this.contatoService.getContatos();
       return ResponseEntity.ok(contatos);
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletarContato(@RequestHeader Long id ) {
        this.contatoService.deleteContato(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/contato/atualizar")
    public ResponseEntity<Contato> updateContato(@RequestBody ContatoDto contato) {
         this.contatoService.atualizarContato(contato.converterContato());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/contato/cadastrar")
    public ResponseEntity<Contato> cadastrarContato(@RequestBody ContatoDto contato) {
        Contato contatoSalvo = this.contatoService.saveContato(contato.converterContato());
        return ResponseEntity.ok(contatoSalvo);
    }
    @GetMapping("/favoritos")
    public ResponseEntity<List<Contato>> getContatoFavoritos() {
        List<Contato> contatos =  this.contatoService.getContatosFavoritos();
        return ResponseEntity.ok(contatos);
    }

    @PostMapping("/favorito/adicionar")
    public ResponseEntity<Contato> saveContatoFavorito(@RequestHeader Long id) {
        Contato contatoSalvo = this.contatoService.adicionarFavorito(id);
        return ResponseEntity.ok(contatoSalvo);
    }

    @PostMapping("/favorito/remover")
    public ResponseEntity<Contato> removeContatoFavorito(@RequestHeader Long id) {
        Contato contatoSalvo = this.contatoService.removerFavorito(id);
        return ResponseEntity.ok(contatoSalvo);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Contato>> getContatoAtivos() {
        List<Contato> contatos =  this.contatoService.getContatosAtivos();
        return ResponseEntity.ok(contatos);
    }

    @PostMapping("/contato/ativar")
    public ResponseEntity<Contato> ativarContato(@RequestHeader Long id) {
        Contato contatoSalvo = this.contatoService.ativarContato(id);
        return ResponseEntity.ok(contatoSalvo);
    }

    @PostMapping("/contato/desativar")
    public ResponseEntity desativarContato(@RequestHeader Long id) {
       this.contatoService.desativarContato(id);
        return ResponseEntity.ok().build();
    }

}
