// DESENVOLVIMENTO DE APLICAÇÕES MULTICAMADAS

// Sistemas de Informação (Noite)

// Aluna: Caroline Videira Sales


public class Porção {

    private int RestauracaoMaxima = 10;

    public int restaurarHP(int[] dados) {
        var VidaRestaurada = 0;

        if (!vazio()) {
            for (int d : dados) {
                VidaRestaurada += d;
            }

            if (VidaRestaurada > 10) {
                VidaRestaurada = 10;
            }

            RestauracaoMaxima -= VidaRestaurada;
            return VidaRestaurada;
        }
        return 0;
    }

    private boolean vazio(){
        if (this.RestauracaoMaxima <= 0) {
            return true;
        }
        return false;
}

}