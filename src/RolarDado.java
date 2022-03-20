import java.util.Random;

public class RolarDado {

        private static final Random RND = new Random();

        private int quantidade;
        private int faces;
        private int modificador;

        public RolarDado(int quantidade, int faces, int modificador) {
            this.quantidade = quantidade;
            this.faces = faces;
            this.modificador = modificador;
        }

        public RolarDado(int quantidade, int faces) {
            this(quantidade, faces, 0);
        }

        public RolarDado(int quantidade) {
            this(quantidade, 6);
        }

        public int rolar() {
            int total = 0;
            for (int i = 0; i < quantidade; i++) {
                total += RND.nextInt(faces) + 1;
            }
            total += modificador;
            return total > 0 ? total : 0;
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            sb.append(quantidade).append("D").append(faces);
            if (modificador == 0) return sb.toString();

            if (modificador > 0) {
                sb.append("+");
            }
            sb.append(modificador);
            return sb.toString();

        }
}
