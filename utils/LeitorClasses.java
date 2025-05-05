
package utils;

import entidades.Classe;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LeitorClasses {
    static List<Classe> classes = new ArrayList<>();

    @SuppressWarnings("CallToPrintStackTrace")
    public static List<Classe> lerClasses(String caminhoRelativo) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoRelativo));

            for (String linha : linhas) {
                linha = linha.trim();

                if (linha.isEmpty() || linha.startsWith("#"))
                    continue;

                String[] partes = linha.split("\\|");

                if (partes.length < 12) {
                    System.out.println("Linha mal formatada: " + linha);
                    continue;
                }

                String nome = partes[0];
                String descricao = partes[1];
                int nivel = Integer.parseInt(partes[2]);
                int pv = Integer.parseInt(partes[3]);
                int pm = Integer.parseInt(partes[4]);
                int forca = Integer.parseInt(partes[5]);
                int destreza = Integer.parseInt(partes[6]);
                int constituicao = Integer.parseInt(partes[7]);
                int inteligencia = Integer.parseInt(partes[8]);
                int sabedoria = Integer.parseInt(partes[9]);
                int carisma = Integer.parseInt(partes[10]);
                List<String> habilidades = Arrays.asList(partes[11].split(","));

                Classe classe = new Classe(nome, descricao, nivel, pv, pm, forca, destreza,
                        constituicao, inteligencia, sabedoria, carisma, habilidades);

                classes.add(classe);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace(); // Adicione esta linha para ver o stack trace completo
        }

        return classes;
    }
}
