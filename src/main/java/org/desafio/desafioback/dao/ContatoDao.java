package org.desafio.desafioback.dao;

import org.desafio.desafioback.models.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoDao extends JpaRepository<Contato, Long> {

    List<Contato> findByFavoritoTrue();

    List<Contato> findByAtivoTrue();

    Contato findByCelular(String celular);

    Contato findByTelefone(String telefone);

    List<Contato> findAllByFavoritoTrue();

    List<Contato> findAllByAtivoTrue();
}
