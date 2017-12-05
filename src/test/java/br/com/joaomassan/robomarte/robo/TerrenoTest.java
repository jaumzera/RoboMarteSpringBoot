package br.com.joaomassan.robomarte.robo;

import br.com.joaomassan.robomarte.robo.Ponto;
import br.com.joaomassan.robomarte.robo.Terreno;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author jaumzera
 */
public class TerrenoTest {

    public TerrenoTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoCriarMedidasNegativas() {
        Terreno.retangular(-3, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoCriarTerrenoComMedidasZeradas() {
        Terreno.quadrado(0);
    }

    @Test
    public void deveCriarUmTerrenoXPorY() {
        Terreno terreno = Terreno.retangular(23, 4);
        Assert.assertEquals(23 * 4, terreno.getArea());
    }

    @Test
    public void deveCriarUmTerrenoQuadrado() {
        Terreno terreno = Terreno.quadrado(5);
        Assert.assertEquals(25, terreno.getArea());
    }

    @Test
    public void deveAssegurarPosicoesValidas() {
        Terreno terreno = Terreno.quadrado(5);
        assertTrue(terreno.podeMoverPara(Ponto.em(0, 0)));
        assertTrue(terreno.podeMoverPara(Ponto.em(1, 1)));
        assertTrue(terreno.podeMoverPara(Ponto.em(2, 2)));
        assertTrue(terreno.podeMoverPara(Ponto.em(3, 3)));
        assertTrue(terreno.podeMoverPara(Ponto.em(4, 4)));
        assertFalse(terreno.podeMoverPara(Ponto.em(5, 5)));
    }

}
