package br.com.joaomassan.robomarte.robo;

import br.com.joaomassan.robomarte.robo.Sentidos;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaumzera
 */
public class SentidosTest {

    public SentidosTest() {
    }

    @Test
    public void testValueOf() {
        assertEquals(Sentidos.N, Sentidos.valueOf("N"));
        assertEquals(Sentidos.S, Sentidos.valueOf("S"));
        assertEquals(Sentidos.E, Sentidos.valueOf("E"));
        assertEquals(Sentidos.W, Sentidos.valueOf("W"));
    }

    @Test
    public void testPeloOrdinal() {
        assertEquals(Sentidos.N, Sentidos.peloOrdinal(0));
        assertEquals(Sentidos.E, Sentidos.peloOrdinal(1));
        assertEquals(Sentidos.S, Sentidos.peloOrdinal(2));
        assertEquals(Sentidos.W, Sentidos.peloOrdinal(3));
    }

    @Test
    public void testVirarEsquerda() {
        assertEquals(Sentidos.E, Sentidos.N.virarDireita());
        assertEquals(Sentidos.S, Sentidos.E.virarDireita());
        assertEquals(Sentidos.W, Sentidos.S.virarDireita());
        assertEquals(Sentidos.N, Sentidos.W.virarDireita());
    }

    @Test
    public void testVirarDireita() {
        assertEquals(Sentidos.W, Sentidos.N.virarEsquerda());
        assertEquals(Sentidos.W, Sentidos.S.virarDireita());
        assertEquals(Sentidos.S, Sentidos.E.virarDireita());
        assertEquals(Sentidos.E, Sentidos.N.virarDireita());
    }

    @Test
    public void testGetOrdinal() {
        assertEquals(0, Sentidos.N.getOrdinal());
        assertEquals(1, Sentidos.E.getOrdinal());
        assertEquals(2, Sentidos.S.getOrdinal());
        assertEquals(3, Sentidos.W.getOrdinal());
    }
}
