package integrador.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import integrador.api.model.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {}
