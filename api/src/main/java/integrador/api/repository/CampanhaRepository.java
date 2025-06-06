package integrador.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import integrador.api.model.Campanha;

@Repository
public interface CampanhaRepository extends CrudRepository<Campanha, Integer> {
    // Métodos adicionais, se necessário
}
