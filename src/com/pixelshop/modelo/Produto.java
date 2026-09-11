package com.pixelshop.modelo;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double precoInicial, int quantidadeInicial) {
        this.nome = nome;
        this.preco = precoInicial < 0 ? 0.0 : precoInicial;
        this.quantidadeEstoque = quantidadeInicial < 0 ? 0 : quantidadeInicial;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public boolean setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
            return true;
        }
        System.out.println("Erro: o preço deve ser maior que zero.");
        return false;
    }

    public boolean setQuantidadeEstoque(int qtd) {
        if (qtd >= 0) {
            this.quantidadeEstoque = qtd;
            return true;
        }
        System.out.println("Erro: o estoque não pode ser negativo.");
        return false;
    }

    public boolean adicionarEstoque(int qtd) {
        if (qtd > 0) {
            quantidadeEstoque += qtd;
            return true;
        }
        System.out.println("Erro: a quantidade adicionada deve ser maior que zero.");
        return false;
    }

    public boolean removerEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Erro: a quantidade removida deve ser maior que zero.");
            return false;
        }

        if (qtd <= quantidadeEstoque) {
            quantidadeEstoque -= qtd;
            return true;
        }

        System.out.println("Erro: estoque insuficiente.");
        return false;
    }
}
