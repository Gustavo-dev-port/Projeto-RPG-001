package sistema;

import entidades.GeradorMonstros;
import entidades.Jogador;
import entidades.Monstros;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            System.out.println("Bem-vindo, meu jovem sonhador!");
            System.out.println("=============================");
            System.out.println("--- Criação de Personagem ---");

            System.out.println("Qual é o seu nome, nobre aventureiro?");
            String nome = leitor.nextLine();

            System.out.println("Escolha sua Classe:");
            System.out.println("1. Guerreiro");
            System.out.println("2. Mago");
            System.out.println("3. Arqueiro");
            String classe = leitor.nextLine();
            switch (classe) {
                case "1" -> classe = "Guerreiro";
                case "2" -> classe = "Mago";
                case "3" -> classe = "Arqueiro";
                default -> {
                    System.out.println("Opção inválida! Definindo como Guerreiro.");
                    classe = "Guerreiro";
                }
            }
            System.out.println("Você escolheu a classe: " + classe);
            System.out.println("=============================");
            System.out.println("Escolha sua origem! (Dá um bônus inicial)");
            System.out.println("1. Nobre");
            System.out.println("2. Camponês");
            System.out.println("3. Mercador");
            String origem = leitor.nextLine();
            switch (origem) {
                case "1" -> origem = "Nobre";
                case "2" -> origem = "Camponês";
                case "3" -> origem = "Mercador";
                default -> {
                    System.out.println("Opção inválida! Definindo como Nobre.");
                    origem = "Nobre";
                }
            }
            System.out.println("Você escolheu a origem: " + origem);
            System.out.println("=============================");
            Jogador heroi = new Jogador(nome, classe, origem);
            System.out.println("Personagem criado com sucesso!");
            heroi.status();
            System.out.println("=============================");

            Random random = new Random();
            GeradorMonstros gerador = new GeradorMonstros();
            String[] tipoInimigo = { "Slime Gosmento", "Goblin Verde", "Orc Bruto" };

            int sorteioInimigo = random.nextInt(tipoInimigo.length);
            String inimigoEscolhido = tipoInimigo[sorteioInimigo];
            Monstros inimigoAtual = gerador.gerarInimigo(inimigoEscolhido);
            System.out
                    .println(heroi.nome + ", você encontrou um " + inimigoAtual.nome + "! Prepare-se para a batalha!");

            OUTER: while (inimigoAtual.vida > 0 && heroi.vida > 0) {
                System.out.println("=============================");
                System.out.println("------- TURNO ATUAL ------");
                System.out.println("Inimigo: " + inimigoAtual.nome + " | Vida: " + inimigoAtual.vida);
                System.out.println("Herói: " + heroi.nome + " | Vida: " + heroi.vida);
                System.out.println("=============================");
                System.out.println("Escolha uma ação:");
                System.out.println("1. Atacar");
                System.out.println("2. Fugir");
                System.out.println("3. Usar item");
                String acao = leitor.nextLine();
                switch (acao) {
                    case "1" -> {
                        // Atacar o inimigo
                        System.out.println("Vai atacar com o que?");
                        System.out.println("1. " + heroi.habilidades.get(0).nome + " (Dano: "
                                + heroi.habilidades.get(0).dano + ")");
                        System.out.println("2. " + heroi.habilidades.get(1).nome + " (Dano: "
                                + heroi.habilidades.get(1).dano + ")");
                        System.out.println("3. " + heroi.habilidades.get(2).nome + " (Dano: "
                                + heroi.habilidades.get(2).dano + ")");
                        String escolha = leitor.nextLine();
                        switch (escolha) {
                            case "1" -> {
                                inimigoAtual.vida -= heroi.habilidades.get(0).dano;
                                System.out.println(heroi.nome + " usou " + heroi.habilidades.get(0).nome + "!");
                            }
                            case "2" -> {
                                inimigoAtual.vida -= heroi.habilidades.get(1).dano;
                                System.out.println(heroi.nome + " usou " + heroi.habilidades.get(1).nome + "!");
                            }
                            case "3" -> {
                                inimigoAtual.vida -= heroi.habilidades.get(2).dano;
                                System.out.println(heroi.nome + " usou " + heroi.habilidades.get(2).nome + "!");
                            }
                            default -> System.out.println("Habilidade inválida!");
                        }
                    }
                    case "2" -> {
                        // Fugir da batalha
                        System.out.println(heroi.nome + " fugiu da batalha!");
                        break OUTER;
                    }
                    default -> System.out.println("Ação inválida! Tente novamente.");
                }
                if (inimigoAtual.vida <= 0) {
                    System.out.println("Você derrotou " + inimigoAtual.nome + "!");
                    break;
                } else if (heroi.vida <= 0) {
                    System.out.println(heroi.nome + " foi derrotado! Fim de jogo.");
                    break;
                } else {
                    // Inimigo ataca o herói
                    inimigoAtual.atacar(heroi);
                }
            }
        }
    }
}
