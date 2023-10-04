package br.com.fiap.pettech.services;

import br.com.fiap.pettech.entities.Produto;
import br.com.fiap.pettech.controllers.exceptions.ControllerNotFoundException;
import br.com.fiap.pettech.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class ProdutoService {

    //Implementação do CRUD

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<Produto> findAll() {
        return produtoRepository.findAll();
    }

    //Optional - Pode ser ou não que exista um produto com o id passado
    public Produto findById(UUID id) {
        return produtoRepository.findById(id).orElseThrow(() ->
                new ControllerNotFoundException("Produto não encontrado"));
    }

    public Produto save(Produto produto) {
        produto = produtoRepository.save(produto);
        return produto;
    }

    public Produto update(UUID id, Produto produtoAtualizado) {

        try {
            Produto buscaProduto = produtoRepository.getOne(id);
            buscaProduto.setNome(produtoAtualizado.getNome());
            buscaProduto.setDescricao(produtoAtualizado.getDescricao());
            buscaProduto.setUrlDaImagem(produtoAtualizado.getUrlDaImagem());
            buscaProduto.setPreco(produtoAtualizado.getPreco());
            buscaProduto = produtoRepository.save(buscaProduto);

            return buscaProduto;
        } catch(EntityNotFoundException e) {
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

}
