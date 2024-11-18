public class Rotor {

    private String rotorValues;
    private char startChar;

    public Rotor(String v, char c) {
        this.rotorValues = new String(v);
        this.startChar = c;

        while (!this.rotate())
            ;

    }

    public boolean rotate() {
        // Creates a string that removes the last character of rotorValues
        String allButLast = this.rotorValues.substring(0, 26);

        // Creates a String containing only the last character of rotorValues
        String Last = this.rotorValues.substring(26);

        // Concatonates the two created string together
        this.rotorValues = Last.concat(allButLast);

        // Returns true if the rotor complete one rotation
        if (this.rotorValues.charAt(0) == this.startChar) {
            return true;
        } else {
            return false;
        }

    }

    // breaks down rotorValues into a char array and finds the index of c in the
    // array
    public int indexOf(char c) {
        int i = -1;
        char[] tempArr = this.rotorValues.toCharArray();
        for (int k = 0; k < 27; k++) {
            if (c == tempArr[k]) {
                i = k;
            }
        }
        return i;
    }

    // breaks down rotorValues into a char array and finds the char at index idx
    public char charAt(int idx) {
        char i = '0';
        char[] tempArr = this.rotorValues.toCharArray();
        i = tempArr[idx];
        return i;
    }

    /*
     * public static void main(String[] args) {
     * 
     * Rotor r1 = new Rotor("#GNUAHOVBIPWCJQXDKRYELSZFMT", '#');
     * System.out.println(r1.rotorValues);
     * 
     * System.out.println(r1.indexOf('T'));
     * System.out.println(r1.indexOf('G'));
     * System.out.println(r1.indexOf('A'));
     * System.out.println(r1.indexOf('F'));
     * System.out.println(r1.indexOf('#'));
     * 
     * System.out.println(r1.charAt(26));
     * System.out.println(r1.charAt(1));
     * System.out.println(r1.charAt(4));
     * System.out.println(r1.charAt(24));
     * System.out.println(r1.charAt(0));
     * 
     * r1.rotate();
     * System.out.println(r1.rotorValues);
     * 
     * for (int i = 0; i < 25; i++) {
     * r1.rotate();
     * }
     * System.out.println(r1.rotate());
     * 
     * for (int i = 0; i < 21; i++) {
     * r1.rotate();
     * }
     * System.out.println(r1.rotate());
     * 
     * }
     */

}
