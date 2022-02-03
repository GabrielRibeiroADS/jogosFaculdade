package br.edu.ifrs.restinga.provajogo.Model.Services;


import br.edu.ifrs.restinga.provajogo.Model.Entities.Jogo;
import br.edu.ifrs.restinga.provajogo.Model.Mensagem.Mensagem;
import br.edu.ifrs.restinga.provajogo.Model.Repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;


    public ResponseEntity<Object> criarJogo(Jogo jogo){

        if (jogo.getTime1().getCorCamisa().equals(jogo.getTime2().getCorCamisa())){
            return new ResponseEntity<>(new Mensagem("Camisa dos dois times iguais."), HttpStatus.BAD_REQUEST);
        }
        if (jogo.getTime1().getNomeTime().equals(jogo.getTime2().getNomeTime())){
            return new ResponseEntity<>(new Mensagem("Nomes dos times são iguais."), HttpStatus.BAD_REQUEST);
        }
        jogo.getTime1().setNumeroGol(0);
        jogo.getTime2().setNumeroGol(0);
        jogoRepository.save(jogo);

        return new ResponseEntity<>(new Mensagem("Jogo criado com sucesso"), HttpStatus.CREATED);
    }

    public ResponseEntity<?> recuperarJogo(int id){
        Optional<Jogo> jogoEncontrado = jogoRepository.findById(id);
        if (jogoEncontrado.isPresent()){
            return new ResponseEntity<>(jogoEncontrado, HttpStatus.ACCEPTED);
        }else return new ResponseEntity<>(new Mensagem("Jogo não existe."),HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Iterable> recuperarJogos(){
        Iterable<Jogo> jogos = jogoRepository.findAll();
        return new ResponseEntity<Iterable>(jogos, HttpStatus.OK);
    }

    public ResponseEntity<Object> atualizarJogo(int id, int golTime1, int golTime2){
        Optional<Jogo> jogoExiste = jogoRepository.findById(id);
        if (!jogoExiste.isPresent()){
            return new ResponseEntity<Object>(new Mensagem("Jogo nao existe"), HttpStatus.BAD_REQUEST);
        }
//        if ((jogoExiste.get().getTime1().getNumeroGol()+jogoExiste.get().getTime2().getNumeroGol())==0){
//            return new ResponseEntity<Object>(new Mensagem("Placar inalterado, portanto, atualizacao invalida"), HttpStatus.NOT_ACCEPTABLE);
//        }
        if ((golTime1+golTime2)==0){
            return new ResponseEntity<Object>(new Mensagem("Placar inalterado, portanto, atualizacao invalida"), HttpStatus.NOT_ACCEPTABLE);
        }

        jogoExiste.get().getTime1().setNumeroGol(golTime1);
        jogoExiste.get().getTime2().setNumeroGol(golTime2);

        jogoRepository.save(jogoExiste.get());

        return new ResponseEntity<Object>(jogoExiste.get(), HttpStatus.ACCEPTED);

    }

    public ResponseEntity<Object> deletarJogo(int id) {
        Optional<Jogo> jogoExiste = jogoRepository.findById(id);
        if (jogoExiste.isPresent()){
            jogoRepository.delete(jogoExiste.get());
            return new ResponseEntity<Object>(new Mensagem("Deletado com sucesso"), HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(new Mensagem("Jogo não existe."), HttpStatus.BAD_REQUEST);
        }
    }

    public Jogo atualizacaoJogo(int id, Jogo jogo){
        Jogo jogoAtualizado = new Jogo();
        jogoAtualizado.setId(id);
        jogoAtualizado.setData(jogo.getData());
        jogoAtualizado.setLocal(jogo.getLocal());
        jogoAtualizado.getTime1().setNomeTime(jogo.getTime1().getNomeTime());
        jogoAtualizado.getTime2().setNomeTime(jogo.getTime2().getNomeTime());
        jogoAtualizado.getTime1().setCorCamisa(jogo.getTime1().getCorCamisa());
        jogoAtualizado.getTime2().setCorCamisa(jogo.getTime2().getCorCamisa());
        jogoAtualizado.getTime1().setNumeroGol(jogo.getTime1().getNumeroGol());
        jogoAtualizado.getTime2().setNumeroGol(jogo.getTime2().getNumeroGol());

        return jogoAtualizado;
    }
}


