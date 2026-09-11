package com.pixelshop.testes;

import com.pixelshop.modelo.Produto;

public class TesteCriacaoProduto {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Controle sem Fio", 199.90, 10);
        Produto produto2 = new Produto("Jogo RPG", 249.90, 5);

        produto1.setPreco(179.90);

        System.out.println("=== TESTE DE CRIAÇÃO DE PRODUTOS ===");
        System.out.println("\nProduto 1:");
        System.out.println("Nome: " + produto1.getNome());
        System.out.printf("Preço: R$ %.2f%n", produto1.getPreco());
        System.out.println("Estoque: " + produto1.getQuantidadeEstoque());

        System.out.println("\nProduto 2:");
        System.out.println("Nome: " + produto2.getNome());
        System.out.printf("Preço: R$ %.2f%n", produto2.getPreco());
        System.out.println("Estoque: " + produto2.getQuantidadeEstoque());
    }
}
