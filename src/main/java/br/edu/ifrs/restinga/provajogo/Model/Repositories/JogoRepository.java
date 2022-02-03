package br.edu.ifrs.restinga.provajogo.Model.Repositories;

import br.edu.ifrs.restinga.provajogo.Model.Entities.Jogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Integer> {
}
