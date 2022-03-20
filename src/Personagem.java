import java.util.Random;

public class Personagem {
    private static final Random RANDOM = new Random();

    private String nome;
    private int habilidades;
    private int defesa;
    private int vida;
    private Arma arma;

    public Personagem(String nome, int habilidades, int defesa, int vida, Arma arma) {
        if (habilidades <= 0) {
            throw new IllegalArgumentException("A skill deve ser maior que zero!");
        }

        if (defesa < 0) {
            throw new IllegalArgumentException("A defense deve ser maior que zero!");
        }

        if (vida < 0) {
            throw new IllegalArgumentException("A vida deve ser maior que zero!");
        }

        if (arma == null) {
            arma = Arma.BARE_HANDS;
        }

        this.nome = nome == null ? "" : nome;
        this.habilidades = habilidades;
        this.defesa = defesa;
        this.vida = vida;
        this.arma = arma;
    }

    public Personagem(String name, int skill, int defense, int life) {
        this(name, skill, defense, life, Arma.BARE_HANDS);
    }

    public static Personagem criarGoblin() {
        String nome[] = {"Redfury", "Kall", "Lector", "Giblles", "Toink"};
        String sobrenome[] = {"Potter", "the weak", "one eyed", "chief", "Lee"};

        String nomeGoblin = nome[RANDOM.nextInt(nome.length)] + " "
                + sobrenome[RANDOM.nextInt(sobrenome.length)];

        int habilidade = 8 + RANDOM.nextInt(9);
        int defesa = 1 + RANDOM.nextInt(4);
        int vida = 10 + RANDOM.nextInt(31);
        var goblin = new Personagem(nomeGoblin, habilidade, defesa, vida);
        goblin.setArma(new Arma("Punhal", new RolarDado(2, 4, -1)));
        return goblin;
    }

    public String getNome() {
        return nome;
    }

    public int getHabilidades() {
        return habilidades;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVida() {
        return vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma == null ? Arma.BARE_HANDS : arma;
    }

    public void ataque(Personagem inimigo) {
        if (!estaVivo()) {
            return;
        }

        System.out.printf("%s ataca %s! ", nome, inimigo.nome);
        int dado1 = RANDOM.nextInt(6) + 1;
        int dado2 = RANDOM.nextInt(6) + 1;
        int dado3 = RANDOM.nextInt(6) + 1;

        int roll = dado1 + dado2 + dado3;
        int alvo = habilidades - inimigo.defesa;
        if (roll <= alvo) {
            System.out.println("Acertou com " + arma + "!");
            int dano = arma.ferimento();
            inimigo.levarDano(dano);
        } else {
            System.out.println("ERROU !");
        }
    }
    public void levarDano(int dano) {
        vida = vida - dano;
        if (vida < 0) {
            vida = 0;
        }
        System.out.printf("%s levou %d de dano. Vida: %s%n",
                nome, dano, vida);
    }
}
