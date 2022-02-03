package br.edu.ifrs.restinga.provajogo.Model.Repositories;

import br.edu.ifrs.restinga.provajogo.Model.Entities.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends CrudRepository<Time, Integer> {
}
