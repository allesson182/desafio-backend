package org.desafio.desafioback;

import org.desafio.desafioback.dao.ContatoDao;
import org.desafio.desafioback.models.entity.Contato;
import org.desafio.desafioback.service.ContatoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ContatoService.class)
public class ContatoTest {


    @Autowired
    public ContatoDao contatoDao;

    @Autowired
    public ContatoService contatoService;


    @BeforeEach
    public void criarContato(){
        Contato contato = new Contato();
        contato.setId(999L);
        contato.setAtivo(true);
        contato.setCelular("123456789");
        contato.setDataCadastro(new Date());
        contato.setEmail("email@teste.com");
        contato.setFavorito(true);
        contato.setNome("Teste");
        contato.setTelefone("123456789");

        contatoDao.save(contato);
    }


    @Test
    public void testDelete() {
        Contato contato = contatoService.getContatoById(999L);
        Long id = contato.getId();
        contatoDao.deleteById(999L);
        assertNull(contatoDao.findById(id).orElse(null));
    }

    @Test
    public void testGetContatos() {
        List<Contato> contatos = contatoService.getContatos();
        Assertions.assertFalse(contatos.isEmpty());
    }

    @Test
    public void testGetContatoById() {
        Contato contato = contatoService.getContatoById(999L);
        Assertions.assertNotNull(contato);
    }

    @Test
    public void testGetContatosFavoritos() {
        List<Contato> contatos = contatoService.getContatosFavoritos();
        Assertions.assertFalse(contatos.isEmpty());
    }
    @Test
    public void testGetContatosAtivos() {
        List<Contato> contatos = contatoService.getContatosAtivos();
        Assertions.assertFalse(contatos.isEmpty());
    }
    @Test
    public void testGetContatoByCelular() {
        Contato contato = contatoService.getContatoByCelular("123456789");
        Assertions.assertNotNull(contato);
    }
    @Test
    public void testAtivarContato() {
        Contato contato = contatoService.ativarContato(999L);
        Assertions.assertTrue(contato.getAtivo());
    }

    @Test
    public void testDesativarContato() {
        Contato contato = contatoService.desativarContato(999L);
        Assertions.assertFalse(contato.getAtivo());
    }
    @Test
    public void testAdicionarFavorito() {
        Contato contato = contatoService.adicionarFavorito(999L);
        Assertions.assertTrue(contato.getFavorito());
    }
    @Test
    public void testRemoverFavorito() {
        Contato contato = contatoService.removerFavorito(999L);
        Assertions.assertFalse(contato.getFavorito());
    }
    @Test
    public void testSaveContato() {
        Contato contato = new Contato();
        contato.setId(1000L);
        contato.setAtivo(true);
        contato.setCelular("999999999");
        contato.setDataCadastro(new Date());
        contato.setEmail("novocontato@email.com");
        contato.setFavorito(true);
        contato.setNome("Novo Contato");
        contato.setTelefone("123456789");
        contatoService.saveContato(contato);
        Contato contatoSalvo = contatoService.getContatoById(1000L);
        Assertions.assertNotNull(contatoSalvo);
    }

}
