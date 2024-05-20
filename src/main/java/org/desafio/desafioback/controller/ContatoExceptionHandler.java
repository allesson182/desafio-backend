package org.desafio.desafioback.controller;


import org.desafio.desafioback.exception.ContatoJaCadastradoException;
import org.desafio.desafioback.exception.ContatoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ContatoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContatoJaCadastradoException.class)
    public ResponseEntity<String> handleCelularJaCadastradoException(ContatoJaCadastradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ContatoNaoEncontradoException.class)
    public ResponseEntity<String> handleContatoNaoEncontradoException(ContatoNaoEncontradoException e) {
        return ResponseEntity.notFound().build();
    }
}
