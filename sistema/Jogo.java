package sistema;

import entidades.GeradorMonstros;
import entidades.Jogador;
import entidades.Monstros;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            Random random = new Random();

            GeradorMonstros geradorMonstros = new GeradorMonstros();
            String[] nomesMonstros = { "Goblin", "Orc", "Dragão" };
            int indiceSorteio = random.nextInt(nomesMonstros.length);

            System.out.println("Bem-vindo ao RPG!");
            Jogador jogador = new Jogador("Heroi", "Guerreiro", "Terra");
            jogador.Status();
            Monstros monstro = geradorMonstros.gerarInimigo(nomesMonstros[indiceSorteio]);

            while (monstro.vida > 0 && jogador.vida > 0) {
                jogador.atacar(monstro);
                monstro.atacar(jogador);
                jogador.verificarLevelUp();
            }

            if (jogador.vida > 0) {
                System.out.println(jogador.nome + " venceu " + monstro.nome + "!");
            } else {
                System.out.println(jogador.nome + " foi derrotado por " + monstro.nome + "...");
            }

            leitor.close();
        }
    }
}