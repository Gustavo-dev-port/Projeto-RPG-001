package sistema;

<<<<<<< Updated upstream
import entidades.Classe;
import java.nio.file.Paths;
import java.util.List;
import utils.LeitorClasses;

public class Jogo {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\janps\\Desktop\\Facul\\Projeto-RPG-001\\textos\\classes.txt";

        System.out.println("Verificando caminho: " + Paths.get(caminho).toAbsolutePath());
        List<Classe> classes = LeitorClasses.lerClasses(caminho);

        if (classes.isEmpty()) {
            System.out.println("NENHUMA CLASSE FOI CARREGADA.");
        } else {
            for (Classe c : classes) {
                System.out.println("Classe: " + c.getNome());
                System.out.println("Descrição: " + c.getDescricao());
                System.out.println("Habilidades: " + c.getHabilidades());
                System.out.println("--------------------------");
            }
=======
import entidades.GeradorMonstros;
import entidades.Jogador;
import entidades.Monstros;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
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
>>>>>>> Stashed changes
        }
    }
}