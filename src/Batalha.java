public class Batalha {

    public static void main(String[] args) {
        var espada = new Arma("Espada", new RolarDado(1, 8));
        System.out.println("DANO DA ESPADA:" + espada.getDano());
        var heroi = new Personagem("Knight", 14, 5, 80);
        heroi.setArma(espada);

        var inimigo = Personagem.criarGoblin();

        System.out.println("Nome do Héroi: " + heroi.getNome());
        System.out.println("Nome do Inimigo: " + inimigo.getNome());

        //BATALHA ATE A MORTE!!!!
        int turno = 1;
        //Enquanto o heroi e o inimigo estao vivos
        while (heroi.estaVivo() && inimigo.estaVivo()) {
            System.out.println("TURNO " + turno);
            heroi.ataque(inimigo);
            inimigo.ataque(heroi);
            turno++;
            System.out.println();
        }

        var vencedor = heroi.getVida() > 0 ? heroi : inimigo;
        System.out.println(vencedor.getNome() + " venceu!");
    }
}
