package integrador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import integrador.api.model.Beneficiario;
import integrador.api.model.User;
import integrador.api.repository.BeneficiarioRepository;
import integrador.api.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/cadastrar/{userId}")
    public ResponseEntity<?> cadastrar(@PathVariable Integer userId, @RequestBody Beneficiario beneficiario) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }

        beneficiario.setUser(user);
        return ResponseEntity.ok(beneficiarioRepository.save(beneficiario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Beneficiario>> listar() {
        return ResponseEntity.ok(beneficiarioRepository.findAll());
    }
}
