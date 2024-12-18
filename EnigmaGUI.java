import javax.swing.JFrame;

public class EnigmaGUI {

    public static void main(String[] args) {
        EnigmaFrame frame = new EnigmaFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Enigma enigma;
        String message;
        String outputMessage;

        while (true) {

            try {
                // creates a new enigma with the info from the selection section
                enigma = new Enigma(frame.getInner(), frame.getMiddle(), frame.getOuter(), frame.getStartingChars());
                message = frame.getMessage();

                if (frame.encryptOrNot()) {
                    outputMessage = enigma.encrypt(message);
                } else {
                    outputMessage = enigma.decrypt(message);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                outputMessage = "Error, make sure that your input text is valid";
            } catch (Throwable e) {
                outputMessage = "Error, make sure that your starting sequence is valid";
            }
            frame.setMessage(outputMessage);

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}