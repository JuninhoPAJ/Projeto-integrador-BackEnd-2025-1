package integrador.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import integrador.api.model.Doacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {}
