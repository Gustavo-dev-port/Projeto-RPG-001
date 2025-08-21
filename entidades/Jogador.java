package entidades;

public class Jogador {
    public String nome;
    public String classe;
    public String origem;
    public double experiencia;
    public int nivel;
    public int xpParaProximoNivel;
    public int vida;
    public int mana;
    public int ataque;

    public Jogador(String nome, String classe, String origem) {
        this.nome = nome;
        this.classe = classe;
        this.origem = origem;
        this.experiencia = 0;
        this.nivel = 1;
        this.xpParaProximoNivel = 100;

        switch (classe) {
            case "Guerreiro" -> {
                this.vida = 150;
                this.mana = 0;
                this.ataque = 20;
            }
            case "Mago" -> {
                this.vida = 100;
                this.mana = 100;
                this.ataque = 10;
            }
            case "Arqueiro" -> {
                this.vida = 120;
                this.mana = 50;
                this.ataque = 15;
            }
        }

        switch (origem) {
            case "Esparta" -> this.vida += 20; // Bônus de 20 de vida
            case "Valinor" -> this.mana += 10; // Bônus de 10 de mana
            case "Floresta" -> this.ataque += 2;
            // A gente pode adicionar mais origens aqui!
            // Bônus de 2 de ataque
            // A gente pode adicionar mais origens aqui!
        }
    }

    public void Status() {
        System.out.println("--- STATUS DO HEROI ---");
        System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);
        System.out.println("Ataque: " + ataque);
        System.out.println("Experiência: " + experiencia);
        System.out.println("------------------------");
    }

    public void atacar(Monstros alvo) {
        System.out.println(nome + " ataca " + alvo.nome + "!");
        alvo.vida -= ataque;
        System.out.println(alvo.nome + " agora tem " + alvo.vida + " de vida.");
    }

    public void verificarLevelUp() {
        if (this.experiencia >= xpParaProximoNivel) {
            this.nivel++;
            this.vida += 10; // Aumenta a vida ao subir de nível
            this.ataque += 5; // Aumenta o ataque ao subir de nível
            this.xpParaProximoNivel *= 2; // Dobra a XP necessária para o próximo nível
            System.out.println(nome + " subiu para o nível " + nivel + "!");
            System.out.println("Vida aumentada para " + vida + " e ataque para " + ataque + ".");
            System.out.println("Proxima meta de XP: " + xpParaProximoNivel);
            System.out.println("----------------------------------");
        }
    }
}
