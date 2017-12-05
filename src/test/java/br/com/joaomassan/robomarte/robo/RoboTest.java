package br.com.joaomassan.robomarte.robo;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jaumzera
 */
public class RoboTest {

    @Test
    public void deveCriarUmRobo() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        Assert.assertNotNull(robo);
    }

    @Test
    public void deveEstarNaPosicaoInicialAoCriar() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        Assert.assertEquals("(0, 0, N)", robo.getPosicao().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoSairDoTerrenoAOeste() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("LM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoSairDoTerrenoALeste() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("RMMMMM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoSairDoTerrenoAOSul() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("RRM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoSairDoTerrenoAONorte() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("MMMMM");
    }

    @Test
    public void deveVirar360GrausParaEsquerda() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);

        robo.executarInstrucoes("L");
        Assert.assertEquals("(0, 0, W)", robo.getPosicao().toString());

        robo.executarInstrucoes("L");
        Assert.assertEquals("(0, 0, S)", robo.getPosicao().toString());

        robo.executarInstrucoes("L");
        Assert.assertEquals("(0, 0, E)", robo.getPosicao().toString());

        robo.executarInstrucoes("L");
        Assert.assertEquals("(0, 0, N)", robo.getPosicao().toString());
    }

    @Test
    public void deveVirar360GrausParaDireita() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("R");
        Assert.assertEquals("(0, 0, E)", robo.getPosicao().toString());
        robo.executarInstrucoes("R");
        Assert.assertEquals("(0, 0, S)", robo.getPosicao().toString());
        robo.executarInstrucoes("R");
        Assert.assertEquals("(0, 0, W)", robo.getPosicao().toString());
        robo.executarInstrucoes("R");
        Assert.assertEquals("(0, 0, N)", robo.getPosicao().toString());
    }

    @Test
    public void deveAndarParaNorteAteOFim() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("M");
        Assert.assertEquals("(0, 1, N)", robo.getPosicao().toString());
        robo.executarInstrucoes("MM");
        Assert.assertEquals("(0, 3, N)", robo.getPosicao().toString());
        robo.executarInstrucoes("M");
        Assert.assertEquals("(0, 4, N)", robo.getPosicao().toString());
    }

    @Test
    public void deveAndarParaOSulAteOFim() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("MMMM");
        Assert.assertEquals("(0, 4, N)", robo.getPosicao().toString());
        robo.executarInstrucoes("LLM");
        Assert.assertEquals("(0, 3, S)", robo.getPosicao().toString());
        robo.executarInstrucoes("MM");
        Assert.assertEquals("(0, 1, S)", robo.getPosicao().toString());
    }

    @Test
    public void deveAndarParaOLesteAteOFim() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("RMM");
        Assert.assertEquals("(2, 0, E)", robo.getPosicao().toString());
        robo.executarInstrucoes("MM");
        Assert.assertEquals("(4, 0, E)", robo.getPosicao().toString());
    }

    @Test
    public void deveAndarParaOesteAteOFim() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("RMMMM");
        Assert.assertEquals("(4, 0, E)", robo.getPosicao().toString());
        robo.executarInstrucoes("LLMM");
        Assert.assertEquals("(2, 0, W)", robo.getPosicao().toString());
        robo.executarInstrucoes("M");
        Assert.assertEquals("(1, 0, W)", robo.getPosicao().toString());
        robo.executarInstrucoes("M");
        Assert.assertEquals("(0, 0, W)", robo.getPosicao().toString());
    }

    @Test
    public void deveDarUmGiroHorarioNoTerreno() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("MMMM");
        robo.executarInstrucoes("RMMMM");
        robo.executarInstrucoes("RMMMM");
        robo.executarInstrucoes("RMMMM");
        Assert.assertEquals("(0, 0, W)", robo.getPosicao().toString());
    }

    @Test
    public void deveDarUmGiroAntiHorarioNoTerreno() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("LLLMMMMLMMMMLMMMMLMMMM");
        Assert.assertEquals("(0, 0, S)", robo.getPosicao().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoAceitarComandosEstranhos() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("I");
    }

    /**
     * Teste do exemplo do email. Exemplo: Se o robô está na posição (0,0,N), o
     * comando "MML" fará ele chegar na posição (0,2,W)
     */
    @Test
    public void deveMoverConformeAEspecificacaoDoEmail() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("MML");
        Assert.assertEquals("(0, 2, W)", robo.getPosicao().toString());
    }

    @Test
    public void deveIrPara20S() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("MMRMMRMM");
        Assert.assertEquals("(2, 0, S)", robo.getPosicao().toString());
    }

    @Test
    public void deveIrPara02W() {
        Terreno terreno = Terreno.quadrado(5);
        Robo robo = new Robo(terreno);
        robo.executarInstrucoes("MML");
        Assert.assertEquals("(0, 2, W)", robo.getPosicao().toString());
    }
}
