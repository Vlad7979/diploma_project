package com.example.demo.service;

import com.example.demo.model.DefaultUserDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return DefaultUserDetails.build(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public Boolean block(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.get().setBlocked(true);
        userRepository.save(user.get());
        return user.get().getBlocked();
    }

    public Boolean unlock(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.get().setBlocked(false);
        userRepository.save(user.get());
        return !user.get().getBlocked();
    }
}
