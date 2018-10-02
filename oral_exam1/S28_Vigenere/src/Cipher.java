import java.util.*;
import java.io.*;

/**
 * @Author Marc Shepherd
 * @version 1.0, 29 Sept 2018
 * @since SDK 1.8
 */

public class Cipher {

    //Variables
    private final String text, key;
    private String encryptedText = "";
    private String extendedKey = "";

    /**
     * Brings in plain-text and key to be used to encrypt & decrypt
     * @param plainText message that is to be encrypted
     * @param key       key used to assist in encryption
     */
    public Cipher(String plainText, String key) {
        this.text = plainText;
        this.key = key;
    }

    /**
     * Extends key out, repeating value until it reaches the specified length
     * of the given plaintext - mod 26 is used to carry over from z to a
     * Example...
     * plain-text: ATTACK AT DAWN
     * key: LEMON
     * Extended key becomes LEMONLEMONLE
     * @return void - used to instantiate extendedKey
     */
    public void extendKey() {
        char[] extendoKey = new char[100];
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (j == key.length()) {
                j = 0;
            }
            //extendoKey repeats, so indice i, key resets so indice j
            extendoKey[i] = key.charAt(j);
            j++;
        }
        extendedKey = new String(extendoKey);
    }

    /**
     * Encrypts plain-text using current object's <code>'text', 'key', and 'extendedKey'</code> to
     * calculate the variable 'encryptedText' and thus encrypt the plainText
     * @return encryptedText
     */
    public String encrypt() {

        for (int i =0; i < text.length(); i++) {

            encryptedText += (char)((text.charAt(i) + extendedKey.charAt(i) - 2 * 'A') % 26 + 'A');
            //encryptedText += (char) ((text.charAt(i) + extendedKey.charAt(i) + 26));
        }
        return encryptedText;
    }

    /**
     * Decrypts cipher code / encrypted plain-text using <code>'encryptedText' and 'extendedKey'</code>
     * @return decrypted
     */
    public String decrypt() {
        String decrypted = "";

        for (int i = 0; i < text.length(); i++) {
        decrypted += (char) ((encryptedText.charAt(i) - extendedKey.charAt(i) + 26) % 26 + 'A');
        }
        return decrypted;
    }
}

/*ENCRYPTING
 //Testing  . . . . System.out.println("Text value: " + Character.getNumericValue(text.charAt(i)) + " | Key value: " + Character.getNumericValue(key.charAt(i)));

            //System.out.println(((Character.getNumericValue(text.charAt(i)) - 10) + ((Character.getNumericValue(key.charAt(i))) - 10) % 26));
            //Returns int value that the specified unicode character represents
            //cipherCode[i] = ((Character.getNumericValue(text.charAt(i)) - 10)
            //              + ((Character.getNumericValue(extendedKey.charAt(i))) - 10) % 26);
            //...subtract 10 for
            //System.out.print(cipherCode[i] + " ");
            //cipherCode.append((char) ((Character.getNumericValue(text.charAt(i)) + 65) + ((extendedKey.charAt(i) + 65) % 26 + 'A')));
            //cipherCode += ((char) ((Character.getNumericValue(text.charAt(i))) + ((extendedKey.charAt(i)) % 26)));
 */