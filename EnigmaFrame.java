import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;

public class EnigmaFrame extends JFrame {

    private JComboBox innerChooser;
    private JComboBox middleChooser;
    private JComboBox outerChooser;

    private JTextField startingChars = new JTextField();
    private JTextArea outputTextArea = new JTextArea();
    private JTextField intputTextField = new JTextField();

    private JButton encrypt = new JButton("Encrypt");
    private JButton decrypt = new JButton("Decrypt");

    private JPanel inputSection = new JPanel();
    private JPanel outputSection = new JPanel();
    private JPanel selectionSection = new JPanel();

    private JLabel innerSelectLabel = new JLabel("Inner rotor");
    private JLabel outerSelectLabel = new JLabel("Outer rotor");
    private JLabel middleSelectLabel = new JLabel("Middle rotor");
    private JLabel inputText = new JLabel("Input");
    private JLabel outputText = new JLabel("Output");

    public EnigmaFrame() {
        super();
        this.setLayout(new BorderLayout());
        inputSection.setLayout(new BorderLayout());
        outputSection.setLayout(new BorderLayout());
        selectionSection.setLayout(new BorderLayout());

        inputSection.add(inputText, BorderLayout.WEST);
        inputSection.add(intputTextField, BorderLayout.EAST);

        outputSection.add(outputText, BorderLayout.WEST);
        outputSection.add(outputTextArea, BorderLayout.EAST);

        this.add(selectionSection, BorderLayout.NORTH);
        this.add(inputSection, BorderLayout.CENTER);
        this.add(outputSection, BorderLayout.SOUTH);

        this.pack();
    }

}
