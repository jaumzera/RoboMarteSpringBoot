package br.com.joaomassan.robomarte.robo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jaumzera
 */
@Data
@EqualsAndHashCode(of = {"largura", "altura"})
public class Terreno {

    public static final Terreno quadrado(int m2) {
        return new Terreno(m2, m2);
    }

    public static final Terreno retangular(int x, int y) {
        return new Terreno(x, y);
    }

    private final int largura, altura;

    private Terreno(int deLargura, int deAltura) {
        if (deLargura < 1 || deAltura < 1) {
            throw new IllegalArgumentException("O terreno deve ser pelo menos 1x1");
        }

        this.largura = deLargura;
        this.altura = deAltura;
    }

    public boolean podeMoverPara(Ponto novoPonto) {
        return isXValidoPara(novoPonto.getX())
                && isYValidoPara(novoPonto.getY());
    }

    private boolean isXValidoPara(int x) {
        return x >= 0 && x < largura;
    }

    private boolean isYValidoPara(int y) {
        return y >= 0 && y < altura;
    }

    public int getArea() {
        return altura * largura;
    }

}
