/**
 * Created by RaedMassoud on 10/27/2024
 * Project: SystemSecurityProject
 */
public class Caesar {

    // Main encryption function
    public static String encrypt(String input, int key) {
        key = Math.abs(key) % 26; // Ensure key is within 0-25
        StringBuilder output = new StringBuilder();

        // Traverse text
        for(char C : input.toCharArray()) {

            // Uppercase
            if(Character.isUpperCase(C)) {
                char encryptedC = (char) ((C + key - 'A') % 26 + 'A');
                output.append(encryptedC);
            }
            // Lowercase
            else if(Character.isLowerCase(C)) {
                char encryptedC = (char) ((C + key - 'a') % 26 + 'a');
                output.append(encryptedC);
            }
            // Ignore white space, numbers, symbols
        }
        // returns encrypted output
        return output.toString();
    }

    // Main decryption function
    public static String decrypt(String input, int key) {
        // Caesar decryption is encryption going backwards OR going forward until
        // it wraps back to the original placement (0-26)
        key = Math.abs(key) % 26; // Ensure key is within 0-25
        return encrypt(input, 26 - key);
    }
}
