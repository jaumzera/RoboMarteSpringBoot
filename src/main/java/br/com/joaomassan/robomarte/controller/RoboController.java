package br.com.joaomassan.robomarte.controller;

import br.com.joaomassan.robomarte.robo.Robo;
import br.com.joaomassan.robomarte.robo.Terreno;
import javax.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jaumzera
 */
@RestController
@RequestMapping("rest/mars")
public class RoboController {

    @PostMapping(
            value = "{command}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String executarComando(@PathVariable("command") String command) {
        Robo robo = new Robo(Terreno.quadrado(5));
        robo.executarInstrucoes(command);
        return robo.getPosicao().toString();
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

}
