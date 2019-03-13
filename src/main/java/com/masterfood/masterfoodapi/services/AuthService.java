package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.User;
import com.masterfood.masterfoodapi.repository.UserRepository;
import com.wirelabs.exceptions.EntityNotFoundException;
import com.wirelabs.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Value("${default.sender}")
    private String sender;

    private UserRepository repositoryUser;

    private BCryptPasswordEncoder pe;

    private EmailService emailService;

    private Random rand = new Random();

    @Autowired
    public AuthService(UserRepository repositoryUser, BCryptPasswordEncoder pe, EmailService emailService) {
        this.repositoryUser = repositoryUser;
        this.pe = pe;
        this.emailService = emailService;
    }

    public void sendNewPassword(String email) {

        User user = repositoryUser.findByEmail(email);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }

        String newPass = newPassword();
        user.setPassword(pe.encode(newPass));

        repositoryUser.save(user);
        emailService.sendNewPasswordEmail(user.getEmail(), newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) { // gera um digito
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1) { // gera letra maiuscula
            return (char) (rand.nextInt(26) + 65);
        } else { // gera letra minuscula
            return (char) (rand.nextInt(26) + 97);
        }
    }
}