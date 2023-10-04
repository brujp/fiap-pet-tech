package br.com.fiap.pettech.dtos;

import java.util.UUID;

//Record - Lidar com estruturas imutáveis para armazenar dados
public record ProdutoDTO(
        UUID id,
        String nome,
        String descricao,
        String urlDaImagem,
        double preco
) {
}
