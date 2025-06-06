package integrador.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import integrador.api.model.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {
    // Métodos adicionais, se necessário
}
