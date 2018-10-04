import java.util.*;
import java.io.*;

/**
 * <div>
 * This assignment is part of the homework grid listed in Introduction to Software Design, taught by Professor Casavant.
 * This program is based off of the Vigenere Cipher, a way to scheme to encrypt and likewise decrypt messages.
 * The program asks a user for two inputs: the desired message to be encrypted, as well as a complementary key.
 * The key is used in conjunction with the plain-text message as a way of encryption.
 * </div>
 * <p>
 * Message: Attack at dawn
 * Key: Lemon
 * </p>
 *
 * <div>
 * <h3>-Encryption-</h3>
 * <p>
 * If the key is uneven in terms of number of letters (shorter, longer), the key will fit to
 * match with the message. Based on the above example... Lemon will repeat itself to match attack at dawn, thus becoming
 * lemonlemonle. In terms of the actual process, first, each letter (message, key) is paired up i.e. A with L, T with E, C with O.
 * Letters correspond to numeric values. In the case of the alphabet, it is 0-25, with A being 0, and Z being 25. To encrypt each letter,
 * start at the messages letter (or numeric value), and add the corresponding key's letter (or numeric value), with Z carrying over to A.
 * This will lead to a complete Vigenere encryption. A quick example is the second letters.... T and E (19 and 4)
 * just increase 4 starting at 19, i.e. 23 (which is equivalent to the letter X).
 * </p>
 *  </div>
 *
 *  <div>
 *  <h3>-Decryption-</h3>
 *  <p>
 *  Decrypting the cipher code is very much the same as encrypting. Use practically the same process, but instead of adding,
 *  you subtract the key letters from the cipher (encrypted) code letters you just encrypted.
 *  </p>
 *  </div>
 * @author Marc Shepherd
 * @version 1.0
 */
public class Vigenere {

    public static void main(String [] args) throws IOException {

        //Variables
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String key, plainText, encrypted, decrypted;

        //User input and uppercase (text, key)
        System.out.println("Please enter desired text to be encrypted.");
        plainText = input.readLine().replaceAll("\\s", "").toUpperCase(); // \\s Replaces all whitespaces and non-visible characters w/ ""
        System.out.println("Please enter desired key to assist in encrypting (suggestion: software, ISD...).");
        key = input.readLine().replaceAll("\\s", "").toUpperCase();

        //Encryption
        Cipher cipher = new Cipher(plainText, key);
        cipher.extendKey();
        encrypted = cipher.encrypt();
        System.out.println(plainText + " encrypted becomes " + encrypted + ".");

        //Decryption
        decrypted = cipher.decrypt();
        System.out.println(encrypted + " decrypted becomes " + decrypted + ".");
    }
}
