package br.edu.ifrs.restinga.provajogo.Controller;

import br.edu.ifrs.restinga.provajogo.Model.Entities.Jogo;
import br.edu.ifrs.restinga.provajogo.Model.Services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JogosController {

    @Autowired
    JogoService jogoService;

    @PostMapping(path = "/cadastrarJogo")
    public ResponseEntity<Object> cadastrarJogo(@RequestBody Jogo jogo) {
        return jogoService.criarJogo(jogo);
    }

    @GetMapping(path = "/recuperarJogo/{id}")
    public ResponseEntity<?> recuperarJogo(@PathVariable int id) {
        return jogoService.recuperarJogo(id);
    }

    @GetMapping(path = "/recuperarJogos")
    public ResponseEntity<Iterable> recuperarJogos() {
        return jogoService.recuperarJogos();
    }

    @PutMapping(path = "/atualizarJogo/{id}/{gol1}/{gol2}")
    public ResponseEntity<Object> atualizarJogos(@PathVariable("id") int id,@PathVariable("gol1") int golTime1,@PathVariable("gol2") int golTime2) {
        return jogoService.atualizarJogo(id, golTime1, golTime2);
    }

    @DeleteMapping(path = "/deletarJogo/{id}")
    public ResponseEntity<Object> deletarJogo(@PathVariable int id){
        return jogoService.deletarJogo(id);
    }
}
