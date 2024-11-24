import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class EnigmaFrame extends JFrame {

    String[] comboPatterns = { "1", "2", "3", "4", "5" };
    private JComboBox innerChooser = new JComboBox<String>(comboPatterns);
    private JComboBox middleChooser = new JComboBox<String>(comboPatterns);
    private JComboBox outerChooser = new JComboBox<String>(comboPatterns);

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
    private JLabel startingCharlabel = new JLabel("Starting Chars");
    private JLabel inputText = new JLabel("Input");
    private JLabel outputText = new JLabel("Output");

    public EnigmaFrame() {
        super();
        this.setLayout(new GridLayout(3, 1, 25, 25));
        inputSection.setLayout(new GridLayout(1, 2));
        outputSection.setLayout(new GridLayout(1, 2));
        selectionSection.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 25));

        selectionSection.add(innerSelectLabel);
        selectionSection.add(innerChooser);
        selectionSection.add(middleSelectLabel);
        selectionSection.add(middleChooser);
        selectionSection.add(outerSelectLabel);
        selectionSection.add(outerChooser);
        selectionSection.add(startingCharlabel);
        startingChars.setColumns(20);
        selectionSection.add(startingChars);
        selectionSection.add(encrypt);
        selectionSection.add(decrypt);

        inputSection.add(inputText);
        inputSection.add(intputTextField);
        intputTextField.setPreferredSize(new Dimension(200, 30));

        outputSection.add(outputText);
        outputSection.add(outputTextArea);
        outputTextArea.setPreferredSize(new Dimension(200, 30));

        this.add(selectionSection);
        this.add(inputSection);
        this.add(outputSection);

        this.pack();
    }

}
