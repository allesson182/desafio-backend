package org.desafio.desafioback.service;

import org.desafio.desafioback.dao.ContatoDao;
import org.desafio.desafioback.exception.ContatoJaCadastradoException;
import org.desafio.desafioback.exception.ContatoNaoEncontradoException;
import org.desafio.desafioback.models.entity.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private  ContatoDao contatoDao;



    public List<Contato> getContatos() {
        return contatoDao.findAll();
    }
    public Contato getContatoById(Long id) {
        return contatoDao.findById(id).orElse(null);
    }

    public Contato saveContato(Contato contato) {
        if (contatoDao.findByCelular(contato.getCelular()) != null)
            throw new ContatoJaCadastradoException("Contato já está cadastrado");

        return contatoDao.save(contato);
    }
    public void deleteContato(Long id) {
        contatoDao.deleteById(id);
    }
    public List<Contato> getContatosFavoritos() {
        return contatoDao.findAllByFavoritoTrue();
    }

    public List<Contato> getContatosAtivos() {
        return contatoDao.findAllByAtivoTrue();
    }

    public Contato getContatoByCelular(String celular) {
        return contatoDao.findByCelular(celular);
    }

    public Contato ativarContato(Long contatoId) {
        Contato contato = contatoDao.findById(contatoId).orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado"));
        contato.setAtivo(true);
        return contatoDao.save(contato);
    }

    public Contato desativarContato(Long id) {
        Contato contato = contatoDao.findById(id).orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado"));
        contato.setAtivo(false);
        return contatoDao.save(contato);
    }

    public Contato adicionarFavorito(Long id) {
        Contato contato = contatoDao.findById(id).orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado"));
        contato.setFavorito(true);
        return contatoDao.save(contato);
    }
    public Contato removerFavorito(Long id) {
        Contato contato = contatoDao.findById(id).orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado"));
        contato.setFavorito(false);
        return contatoDao.save(contato);
    }

    public Contato atualizarContato(Contato contato) {
        Contato contatoSalvo = contatoDao.findById(contato.getId()).orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado"));
        contatoSalvo.setNome(contato.getNome());
        contatoSalvo.setEmail(contato.getEmail());
        contatoSalvo.setCelular(contato.getCelular());
        contatoSalvo.setTelefone(contato.getTelefone());
        return contatoDao.save(contatoSalvo);
    }
}
