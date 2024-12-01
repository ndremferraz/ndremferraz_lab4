import javax.swing.JFrame;

public class EnigmaGUI {

    public static void main(String[] args) {
        EnigmaFrame frame = new EnigmaFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}