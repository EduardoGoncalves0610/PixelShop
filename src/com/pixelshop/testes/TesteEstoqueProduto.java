package com.pixelshop.testes;

import com.pixelshop.modelo.Produto;

public class TesteEstoqueProduto {
    public static void main(String[] args) {
        Produto produto = new Produto("Headset Gamer", 299.90, 10);

        System.out.println("=== TESTE DE OPERAÇÕES DE ESTOQUE ===");
        System.out.println("Estoque inicial: " + produto.getQuantidadeEstoque());

        System.out.println("\nAdicionando 5 unidades...");
        System.out.println("Resultado: " + produto.adicionarEstoque(5));
        System.out.println("Estoque atual: " + produto.getQuantidadeEstoque());

        System.out.println("\nRemovendo 3 unidades...");
        System.out.println("Resultado: " + produto.removerEstoque(3));
        System.out.println("Estoque atual: " + produto.getQuantidadeEstoque());

        System.out.println("\nTentando remover 20 unidades...");
        System.out.println("Resultado: " + produto.removerEstoque(20));
        System.out.println("Estoque atual: " + produto.getQuantidadeEstoque());

        System.out.println("\nTestando alteração de preço válida...");
        System.out.println("Resultado: " + produto.setPreco(279.90));
        System.out.printf("Preço atual: R$ %.2f%n", produto.getPreco());

        System.out.println("\nTestando alteração de preço inválida...");
        System.out.println("Resultado: " + produto.setPreco(0));
        System.out.printf("Preço mantido: R$ %.2f%n", produto.getPreco());
    }
}
