package com.anamika.authsystem.service;

import com.anamika.authsystem.dto.RegisterRequest;
import com.anamika.authsystem.entity.User;
import com.anamika.authsystem.entity.Role;
import com.anamika.authsystem.repository.RoleRepository;
import com.anamika.authsystem.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {

        // 1️⃣ Check if user exists
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // 2️⃣ Hash password
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        // 3️⃣ Assign USER role
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));

        // 4️⃣ Save user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(hashedPassword);
        user.setEnabled(true);
        user.setRoles(Set.of(userRole));

        userRepository.save(user);
    }
}
