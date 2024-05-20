package org.desafio.desafioback.models.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String celular;
    private String telefone;
    private Boolean favorito;
    private Boolean ativo;
    private Date dataCadastro;

    public Contato() {
    }
    public Contato(Long id, String nome, String email, String celular, String telefone, Boolean favorito, Boolean ativo, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.favorito = favorito;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public Contato(Long id, String nome, String email, String celular) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.dataCadastro = new Date();
        this.favorito = false;
        this.ativo = true;
    }

    public Contato(Long id, String nome, String email, String celular, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.dataCadastro = new Date();
        this.favorito = false;
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
