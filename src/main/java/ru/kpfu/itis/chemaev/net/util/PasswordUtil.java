package ru.kpfu.itis.chemaev.net.util;

import jakarta.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordUtil.class);

    public static String encrypt(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.warn("Cannot find algorithm", e);
            return null;
        }
    }

    /**
     * This function returns:
     * 0 if password is invalid;
     * 1 if password is weak;
     * 2 if password is strong
     */
    public static int checkPassword(String password) {
        int passwordLength = 8, upChars = 0, lowChars = 0;
        int special = 0, digits = 0;
        char ch;

        int total = password.length();
        if (total < passwordLength) {
            System.out.println("\nThe Password is invalid!");
            return 0;
        } else {
            for (int i = 0; i < total; i++) {
                ch = password.charAt(i);
                if (Character.isUpperCase(ch))
                    upChars = 1;
                else if (Character.isLowerCase(ch))
                    lowChars = 1;
                else if (Character.isDigit(ch))
                    digits = 1;
                else
                    special = 1;
            }
        }
        if (upChars == 1 && lowChars == 1 && digits == 1 && special == 1) {
            System.out.println("\nThe Password is Strong.");
            return 2;
        } else {
            System.out.println("\nThe Password is Weak.");
            return 1;
        }
    }
}
