package br.com.joaomassan.robomarte.robo;

import lombok.Getter;

/**
 *
 * @author jaumzera
 */
public enum Sentidos {

    N(0, "Norte"),
    E(1, "Leste"),
    S(2, "Sul"),
    W(3, "Oeste");

    public static Sentidos peloOrdinal(int pos) {
        return Sentidos.values()[pos];
    }

    @Getter
    private final int ordinal;

    @Getter
    private final String value;

    private Sentidos(int ordinal, String value) {
        this.ordinal = ordinal;
        this.value = value;
    }

    public Sentidos virarEsquerda() {
        int novaPosicao = this.ordinal - 1;
        return Sentidos.peloOrdinal(novaPosicao < 0
                ? Sentidos.values().length - 1
                : novaPosicao);

    }

    public Sentidos virarDireita() {
        int novaPosicao = this.ordinal + 1;
        return Sentidos.peloOrdinal(novaPosicao > Sentidos.values().length - 1
                ? 0
                : novaPosicao);
    }
}
