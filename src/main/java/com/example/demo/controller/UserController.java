package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DefaultUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
@AllArgsConstructor
public class UserController {

    private DefaultUserDetailsService service;

    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/block")
    public Boolean block(@RequestParam Long id) {
        return service.block(id);
    }

    @PutMapping("/unlock")
    public Boolean unlock(@RequestParam Long id) {
        return service.unlock(id);
    }
}
