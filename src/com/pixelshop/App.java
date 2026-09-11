package com.pixelshop;

import com.pixelshop.modelo.Produto;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    private static Produto produto1;
    private static Produto produto2;

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    consultarProduto();
                    break;
                case 3:
                    entradaEstoque();
                    break;
                case 4:
                    saidaEstoque();
                    break;
                case 5:
                    alterarPreco();
                    break;
                case 0:
                    System.out.println("\nSistema encerrado. Até mais!");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n====================================");
        System.out.println("          PIXELSHOP - ESTOQUE");
        System.out.println("====================================");
        System.out.println("1 - Cadastrar novo produto");
        System.out.println("2 - Consultar produto");
        System.out.println("3 - Entrada de estoque");
        System.out.println("4 - Saída de estoque");
        System.out.println("5 - Alterar preço");
        System.out.println("0 - Sair");
        System.out.println("====================================");
    }

    private static void cadastrarProduto() {
        System.out.println("\n--- CADASTRO DE PRODUTO ---");

        int numero;
        do {
            numero = lerInteiro("Cadastrar como produto 1 ou 2: ");
            if (numero != 1 && numero != 2) {
                System.out.println("Escolha somente 1 ou 2.");
            }
        } while (numero != 1 && numero != 2);

        String nome = lerTexto("Nome do produto: ");
        double preco = lerDouble("Preço inicial: R$ ");
        int quantidade = lerInteiro("Quantidade inicial em estoque: ");

        Produto novoProduto = new Produto(nome, preco, quantidade);

        if (numero == 1) {
            produto1 = novoProduto;
        } else {
            produto2 = novoProduto;
        }

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void consultarProduto() {
        Produto produto = selecionarProduto();

        if (produto == null) {
            return;
        }

        double valorTotal = produto.getPreco() * produto.getQuantidadeEstoque();

        System.out.println("\n--- DADOS DO PRODUTO ---");
        System.out.println("Nome: " + produto.getNome());
        System.out.printf("Preço unitário: R$ %.2f%n", produto.getPreco());
        System.out.println("Quantidade em estoque: " + produto.getQuantidadeEstoque());
        System.out.printf("Valor total em estoque: R$ %.2f%n", valorTotal);
    }

    private static void entradaEstoque() {
        Produto produto = selecionarProduto();

        if (produto == null) {
            return;
        }

        int quantidade = lerInteiro("Quantidade para adicionar: ");

        if (produto.adicionarEstoque(quantidade)) {
            System.out.println("Entrada realizada com sucesso!");
            System.out.println("Novo estoque: " + produto.getQuantidadeEstoque());
        }
    }

    private static void saidaEstoque() {
        Produto produto = selecionarProduto();

        if (produto == null) {
            return;
        }

        int quantidade = lerInteiro("Quantidade para remover: ");

        if (produto.removerEstoque(quantidade)) {
            System.out.println("Saída realizada com sucesso!");
            System.out.println("Novo estoque: " + produto.getQuantidadeEstoque());
        }
    }

    private static void alterarPreco() {
        Produto produto = selecionarProduto();

        if (produto == null) {
            return;
        }

        double novoPreco = lerDouble("Novo preço: R$ ");

        if (produto.setPreco(novoPreco)) {
            System.out.printf("Preço alterado com sucesso! Novo preço: R$ %.2f%n",
                    produto.getPreco());
        }
    }

    private static Produto selecionarProduto() {
        if (produto1 == null && produto2 == null) {
            System.out.println("\nNenhum produto cadastrado.");
            return null;
        }

        System.out.println("\n--- SELECIONE O PRODUTO ---");

        if (produto1 != null) {
            System.out.println("1 - " + produto1.getNome());
        }
        if (produto2 != null) {
            System.out.println("2 - " + produto2.getNome());
        }

        int numero = lerInteiro("Produto: ");

        if (numero == 1 && produto1 != null) {
            return produto1;
        }

        if (numero == 2 && produto2 != null) {
            return produto2;
        }

        System.out.println("Produto inválido ou não cadastrado.");
        return null;
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String valor = scanner.nextLine().trim().replace(",", ".");
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um preço válido.");
            }
        }
    }

    private static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("O nome não pode ficar vazio.");
        }
    }
}
