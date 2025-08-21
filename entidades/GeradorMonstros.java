package entidades;

public class GeradorMonstros {

    public Monstros gerarInimigo(String tipo) {
        return switch (tipo) {
            case "Slime" -> new Monstros("Slime", 30, 3, 10);
            case "Goblin" -> new Monstros("Goblin", 50, 5, 30);
            case "Orc" -> new Monstros("Orc", 80, 10, 50);
            case "Dragão" -> new Monstros("Dragão", 200, 20, 100);
            default -> new Monstros("Goblin Verde", 50, 8, 10);
        };
    }

}
