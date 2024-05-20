package org.desafio.desafioback.models.dto;

import org.desafio.desafioback.models.entity.Contato;

public class ContatoDto {
    private Long id;
    private String nome;
    private String email;
    private String celular;
    private String telefone;


    public ContatoDto() {
    }
    public ContatoDto( String nome, String email, String celular) {

        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Contato converterContato() {
        if (this.telefone == null)
            return new Contato(this.id, this.nome, this.email, this.celular);

        return new Contato(this.id, this.nome, this.email, this.celular, this.telefone);
    }


}
