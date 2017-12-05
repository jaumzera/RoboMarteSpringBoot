package br.com.joaomassan.robomarte.robo.command;

import br.com.joaomassan.robomarte.robo.Posicao;
import br.com.joaomassan.robomarte.robo.Robo;

/**
 *
 * @author jaumzera
 */
public class VirarDireitaCommand implements Command {

    public static final VirarDireitaCommand criarPara(Robo robo) {
        return new VirarDireitaCommand(robo);
    }

    private final Robo target;

    private VirarDireitaCommand(Robo target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.virarParaDireita();
    }

}
