package com.rs.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * created by rs 1/31/2022.
 */
@Service
public class EncryptionServiceImpl implements EncryptionService {

    @Autowired
    PasswordEncoder passwordEncoder;

    public String encryptString(String input) {
        return passwordEncoder.encode(input);
    }

    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return passwordEncoder.matches(plainPassword, encryptedPassword);
    }
}
