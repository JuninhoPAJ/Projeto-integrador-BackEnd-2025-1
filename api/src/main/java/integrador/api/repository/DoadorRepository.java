package integrador.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import integrador.api.model.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Integer> {}
