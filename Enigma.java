public class Enigma {

    // rotorInit contains all the possible rotor sequences
    private String rotorInit[] = { "#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV",
            "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND" };

    // rotors stores the rotors that have been initialized
    private Rotor rotors[];

    public Enigma(int id1, int id2, int id3, String start) {

        rotors = new Rotor[3];

        // inner rotor
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0));

        // middle rotor
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1));

        // outer rotor
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2));

    }

    public String encrypt(String message) {
        // char message is an array containing all the characters in the message
        char[] messageArr = message.toCharArray();

        // indexes to find the letter allignment
        int innerIndex, middleIndex;

        // encrypted letter and char to store the outer letter to be found in the middle
        // rotor
        char encryptedChar, outLetter;

        String encryptedMessage = new String("");

        for (int i = 0; i < message.length(); i++) {

            // Look at position of letter in the inner rotor
            innerIndex = this.rotors[0].indexOf(messageArr[i]);

            // Look at alligned character in the outer rotor
            outLetter = this.rotors[2].charAt(innerIndex);

            // Look at position of outLetter in middle rotor
            middleIndex = this.rotors[1].indexOf(outLetter);

            // Look at letter alligned with middleIndex in the outer rotor
            encryptedChar = this.rotors[2].charAt(middleIndex);

            // append encryptedChar to encryptedMessage
            encryptedMessage = encryptedMessage + "" + encryptedChar;

            // rotate
            this.rotate();

        }

        return encryptedMessage;
    }

    public String decrypt(String message) {

        // messageArr stores a char array containing the characters in message
        char[] messageArr = message.toCharArray();

        // indexes to keep track of letter allignment
        int outerIndex, middleIndex;

        // middleChar stores the character alligned with the encrypted character in the
        // middle rotor
        // decryptedMessage stores the decrypted character
        char middleChar, decryptedChar;

        String decryptedMessage = new String("");

        for (int i = 0; i < message.length(); i++) {

            // Look at position of letter in the outer rotor
            outerIndex = rotors[2].indexOf(messageArr[i]);

            // Look at letter at alligned in the middle rotor
            middleChar = rotors[1].charAt(outerIndex);

            // Look for the position of MiddleChar in the outer rotor
            middleIndex = rotors[2].indexOf(middleChar);

            // Look for the letter alligned with middleChar in the inner rotor
            decryptedChar = rotors[0].charAt(middleIndex);

            // append decrypted char to end to decrypted Message
            decryptedMessage = decryptedMessage + "" + decryptedChar;

            // rotate
            rotate();
        }

        return decryptedMessage;

    }

    // this method handles rotation among the different rotors
    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }

    /*
     * public static void main(String[] args) {
     * 
     * // String[] args = {"1", "2", "3", "###", "encrypt", "AAA"};
     * 
     * Enigma enig1 = new Enigma(1, 2, 3, "###");
     * System.out.println(enig1.encrypt("AAA")); // Expected OUTPUT NDU
     * System.out.println(enig1.encrypt("KINGA")); // Expected OUTPUT PEKKI
     * System.out.println(enig1.encrypt("MY#NAME#IS#ANDRE"));
     * 
     * Enigma enig2 = new Enigma(1, 2, 3, "###");
     * System.out.println(enig2.decrypt("NDU"));
     * System.out.println(enig2.decrypt("PEKKI"));
     * System.err.println(enig2.decrypt("UQHEBYKLTOIMWHEB"));
     * 
     * 
     * }
     */

}
