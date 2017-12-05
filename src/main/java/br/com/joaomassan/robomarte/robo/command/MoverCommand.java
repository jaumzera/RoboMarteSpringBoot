package br.com.joaomassan.robomarte.robo.command;

import br.com.joaomassan.robomarte.robo.Robo;

/**
 *
 * @author jaumzera
 */
public class MoverCommand implements Command {

    public static final MoverCommand criarPara(Robo robo) {
        return new MoverCommand(robo);
    }

    private final Robo target;

    private MoverCommand(Robo target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.mover();
    }
}
