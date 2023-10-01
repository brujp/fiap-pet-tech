package br.com.fiap.pettech.services;

import br.com.fiap.pettech.entities.Produto;
import br.com.fiap.pettech.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
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
    public Optional<Produto> findById(UUID id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        produto = produtoRepository.save(produto);
        return produto;
    }

    public Produto update(UUID id, Produto produtoAtualizado) {
        Produto buscaProduto = produtoRepository.getOne(id);
        buscaProduto.setNome(produtoAtualizado.getNome());
        buscaProduto.setDescricao(produtoAtualizado.getDescricao());
        buscaProduto.setUrlDaImagem(produtoAtualizado.getUrlDaImagem());
        buscaProduto.setPreco(produtoAtualizado.getPreco());
        buscaProduto = produtoRepository.save(buscaProduto);

        return buscaProduto;
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

}
