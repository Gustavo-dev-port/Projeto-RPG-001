package entidades;

import java.util.ArrayList;
import utils.Habilidades;

public class Jogador {
    public String nome;
    public String classe;
    public String origem;
    public double experiencia;
    public int nivel;
    public int xpParaProximoNivel;
    public int vida;
    public int mana;
    public ArrayList<Habilidades> habilidades;

    public Jogador(String nome, String classe, String origem) {
        this.nome = nome;
        this.classe = classe;
        this.origem = origem;
        this.habilidades = new ArrayList<>();
        this.experiencia = 0;
        this.nivel = 1;
        this.xpParaProximoNivel = 100;

        switch (classe) {
            case "Guerreiro" -> {
                this.vida = 150;
                this.mana = 0;
                this.habilidades.add(new Habilidades("Soco", 5));
                this.habilidades.add(new Habilidades("Corte Poderoso", 20));
                this.habilidades.add(new Habilidades("Estocada Rápida", 10));
            }
            case "Mago" -> {
                this.vida = 100;
                this.mana = 100;
                this.habilidades.add(new Habilidades("Soco", 5));
                this.habilidades.add(new Habilidades("Bola de Fogo", 30));
                this.habilidades.add(new Habilidades("Raio Congelante", 15));
            }
            case "Arqueiro" -> {
                this.vida = 120;
                this.mana = 50;
                this.habilidades.add(new Habilidades("Soco", 5));
                this.habilidades.add(new Habilidades("Flecha Precisa", 25));
                this.habilidades.add(new Habilidades("Tiro Rápido", 12));
            }
        }

        switch (origem) {
            case "Esparta" -> this.vida += 20; // Bônus de 20 de vida
            case "Valinor" -> this.mana += 10; // Bônus de 10 de mana
            // A gente pode adicionar mais origens aqui!
            // Bônus de 2 de ataque
            // A gente pode adicionar mais origens aqui!
        }
    }

    public void status() {
        System.out.println("--- STATUS DO HEROI ---");
        System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);
        System.out.println("Ataque: " + habilidades.stream().mapToInt(h -> h.dano).sum());
        System.out.println("Experiência: " + experiencia);
        System.out.println("------------------------");
    }

    public void atacar(Monstros alvo) {
        System.out.println(nome + " ataca " + alvo.nome + "!");
        alvo.vida -= habilidades.stream().mapToInt(h -> h.dano).sum();
        System.out.println(alvo.nome + " agora tem " + alvo.vida + " de vida.");
    }

    public void verificarLevelUp() {
        if (this.experiencia >= xpParaProximoNivel) {
            this.nivel++;
            this.vida += 10; // Aumenta a vida ao subir de nível
            this.habilidades.forEach(h -> h.dano += 5); // Aumenta o ataque ao subir de nível
            this.xpParaProximoNivel *= 2; // Dobra a XP necessária para o próximo nível
            System.out.println(nome + " subiu para o nível " + nivel + "!");
            System.out.println("Vida aumentada para " + vida + " e ataque para "
                    + habilidades.stream().mapToInt(h -> h.dano).sum() + ".");
            System.out.println("Proxima meta de XP: " + xpParaProximoNivel);
            System.out.println("----------------------------------");
        }
    }
}
