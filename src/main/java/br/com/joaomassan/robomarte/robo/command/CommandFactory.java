package br.com.joaomassan.robomarte.robo.command;

import br.com.joaomassan.robomarte.robo.Robo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jaumzera
 */
public class CommandFactory {

    public static final CommandFactory criarPara(Robo target) {
        return new CommandFactory(target);
    }

    private Robo target;

    private Map<String, Command> commandMapper = new HashMap<>();

    public CommandFactory(Robo target) {
        this.target = target;
        this.commandMapper.put("M", MoverCommand.criarPara(target));
        this.commandMapper.put("L", VirarEsquerdaCommand.criarPara(target));
        this.commandMapper.put("R", VirarDireitaCommand.criarPara(target));
    }

    public Command parse(String command) {
        return commandMapper.get(command);
    }

}
