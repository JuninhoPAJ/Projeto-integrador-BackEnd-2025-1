package integrador.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import integrador.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {}
