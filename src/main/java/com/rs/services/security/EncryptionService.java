package com.rs.services.security;

/**
 * created by rs 1/31/2022.
 */
public interface EncryptionService {

    String encryptString(String input);
    boolean checkPassword(String plainPassword,String encryptedPassword);

}
