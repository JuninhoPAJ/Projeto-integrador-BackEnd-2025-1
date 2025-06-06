package integrador.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import integrador.api.model.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {}
