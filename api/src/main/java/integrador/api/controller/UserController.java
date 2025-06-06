package integrador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import integrador.api.model.User;
import integrador.api.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastrar(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
