package integrador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import integrador.api.model.Voluntario;
import integrador.api.model.User;
import integrador.api.repository.VoluntarioRepository;
import integrador.api.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/cadastrar/{userId}")
    public ResponseEntity<?> cadastrar(@PathVariable Integer userId, @RequestBody Voluntario voluntario) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }

        voluntario.setUser(user);
        return ResponseEntity.ok(voluntarioRepository.save(voluntario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Voluntario>> listar() {
        return ResponseEntity.ok(voluntarioRepository.findAll());
    }
}
