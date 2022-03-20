import java.util.Random;

public class Arma {
    public static final Arma BARE_HANDS = new Arma("MÃOS LIMPAS", new RolarDado(0,0, 1));

    private static final Random RND = new Random();
    private String nome;
    private RolarDado dano;

    public Arma(String name, RolarDado dano) {
        this.nome = name;
        if (dano == null) {
            throw new IllegalArgumentException("O Dano não pode ser Nulo!");
        }
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public RolarDado getDano() {
        return dano;
    }

    public int ferimento() {
        return dano.rolar();
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", nome, dano);
    }
}
