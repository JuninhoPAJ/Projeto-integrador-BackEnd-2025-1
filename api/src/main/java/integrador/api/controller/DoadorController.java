package integrador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import integrador.api.model.Doador;
import integrador.api.model.User;
import integrador.api.repository.DoadorRepository;
import integrador.api.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/doador")
public class DoadorController {

    @Autowired
    private DoadorRepository doadorRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/cadastrar/{userId}")
    public ResponseEntity<?> cadastrar(@PathVariable Integer userId, @RequestBody Doador doador) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }

        doador.setUser(user);
        return ResponseEntity.ok(doadorRepository.save(doador));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Doador>> listar() {
        return ResponseEntity.ok(doadorRepository.findAll());
    }
}
