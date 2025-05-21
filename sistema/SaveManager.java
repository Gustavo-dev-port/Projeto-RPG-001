package sistema;

import java.nio.file.*;
import utils.Criptografia;

public class SaveManager {
    private static final Path CAMINHO = Paths.get("textos", "save.txt");

    public static void salvar(String conteudo) {
        try {
            String criptografado = Criptografia.criptografar(conteudo);
            Files.writeString(CAMINHO, criptografado);
            System.out.println("Jogo Salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }

    }

    public static String carregar() {
        try {
            if (!Files.exists(CAMINHO))
                return null;
            String criptografado = Files.readString(CAMINHO);
            return Criptografia.descriptografar(criptografado);

        } catch (Exception e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }
}