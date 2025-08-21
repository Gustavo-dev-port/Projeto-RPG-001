package entidades;

public class Monstros {
    public String nome;
    public int vida;
    public int ataque;
    public int recompensaXp;

    // Construtor completo
    public Monstros(String nome, int vida, int ataque, int recompensaXp) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.recompensaXp = recompensaXp;
    }

    public void atacar(Jogador alvo) {
        System.out.println(nome + " ataca " + alvo.nome + "!");
        alvo.vida -= ataque;
        System.out.println(alvo.nome + " agora tem " + alvo.vida + " de vida.");
    }
}
