package sistema;

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
        }
    }
}