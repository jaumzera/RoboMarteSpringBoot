package br.com.joaomassan.robomarte.robo;

import lombok.Value;

/**
 *
 * @author jaumzera
 */
@Value
public class Ponto {

    public static final Ponto em(int x, int y) {
        return new Ponto(x, y);
    }

    private int x, y;

    private Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ponto moverXEm(int x) {
        return Ponto.em(this.x + x, this.y);
    }

    public Ponto moverYEm(int y) {
        return Ponto.em(this.x, this.y + y);
    }
}
