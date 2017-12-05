package br.com.joaomassan.robomarte.robo;

import br.com.joaomassan.robomarte.robo.command.CommandFactory;
import java.util.regex.Pattern;
import lombok.Getter;

/**
 *
 * @author jaumzera
 */
public class Robo {

    private static final Pattern COMMANDOS_ACEITOS = Pattern.compile("[LRM]+");

    @Getter
    private Posicao posicao;

    private final Terreno terreno;

    private CommandFactory commandFactory;

    public Robo(Terreno terreno) {
        this.terreno = terreno;
        this.posicao = new Posicao(Ponto.em(0, 0), Sentidos.N);
        this.commandFactory = CommandFactory.criarPara(this);
    }

    public void executarInstrucoes(String instrucoes) {
        validarEntrada(instrucoes);
        String[] comandos = instrucoes.split("");
        for (String comando : comandos) {
            commandFactory.parse(comando).execute();
        }
    }

    private void validarEntrada(String instrucoes) throws IllegalArgumentException {
        if (!COMMANDOS_ACEITOS.matcher(instrucoes).matches()) {
            throw new IllegalArgumentException("Os comandos aceitos:\n"
                    + "\t L      (left) vira à esquerda\n"
                    + "\t R      (right) vira à direita\n "
                    + "\t M      (move) faz o robo andar na direção configurada.");
        }
    }

    public void virarParaDireita() {
        Posicao novaPosicao = posicao.virarDireita();
        if (terreno.podeMoverPara(novaPosicao.getPonto())) {
            posicao = novaPosicao;
        } else {
            throw new IllegalArgumentException("Movimento não permitido");
        }
    }

    public void virarParaEsquerda() {
        Posicao novaPosicao = posicao.virarEsquerda();
        if (terreno.podeMoverPara(novaPosicao.getPonto())) {
            posicao = novaPosicao;
        } else {
            throw new IllegalArgumentException("Movimento não permitido");
        }
    }

    public void mover() {
        Posicao novaPosicao = posicao.mover();
        if (terreno.podeMoverPara(novaPosicao.getPonto())) {
            posicao = novaPosicao;
        } else {
            throw new IllegalArgumentException("Movimento não permitido");
        }
    }
}
