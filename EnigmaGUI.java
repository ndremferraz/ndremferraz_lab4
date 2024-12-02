import javax.swing.JFrame;

public class EnigmaGUI {

    public static void main(String[] args) {
        EnigmaFrame frame = new EnigmaFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String message;

        while (true) {
            message = frame.getMessage();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame.setMessage(message);
        }

    }

}