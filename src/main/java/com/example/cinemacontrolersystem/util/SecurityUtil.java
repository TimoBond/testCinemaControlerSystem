package com.example.cinemacontrolersystem.util;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HexFormat;

public class SecurityUtil {
    public static byte[] generateSalt() {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[64];
            secureRandom.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
           throw   new CinemaSecurityException("Проблема генерации с салтом");

        }
    }


    public static String generatePassword(char[] chars) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = generateSalt();
        int iterations = 2000;
        PBEKeySpec pbeKeySpec = new PBEKeySpec(chars, salt, iterations, 512);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] passwordHash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
        HexFormat hex = HexFormat.of();
        return hex.formatHex(salt) + "$" + iterations + "$" + hex.formatHex(passwordHash);
    }
}
