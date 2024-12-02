import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class EnigmaFrame extends JFrame {

    // private fields that will be passed on to the UI file
    private Boolean encryptOrDecrypt;
    private String startingCharString;
    private String message;
    private String innerRotor;
    private String middleRotor;
    private String outerRotor;

    // creating all the component needed
    String[] comboPatterns = { "1", "2", "3", "4", "5" };
    private JComboBox innerChooser = new JComboBox<String>(comboPatterns);
    private JComboBox middleChooser = new JComboBox<String>(comboPatterns);
    private JComboBox outerChooser = new JComboBox<String>(comboPatterns);

    private JTextField startingChars = new JTextField();
    private JTextArea outputTextArea = new JTextArea();
    private JTextField intputTextField = new JTextField();

    private JButton encrypt = new JButton("Encrypt");
    private JButton decrypt = new JButton("Decrypt");
    private Color nonPressedColor = encrypt.getBackground();
    private Color pressedColor = nonPressedColor.darker();

    private JPanel inputSection = new JPanel();
    private JPanel outputSection = new JPanel();
    private JPanel selectionSection = new JPanel();

    private JLabel innerSelectLabel = new JLabel("Inner rotor");
    private JLabel outerSelectLabel = new JLabel("Outer rotor");
    private JLabel middleSelectLabel = new JLabel("Middle rotor");
    private JLabel startingCharlabel = new JLabel("Starting Chars");
    private JLabel inputText = new JLabel("Input");
    private JLabel outputText = new JLabel("Output");

    // instantiating all the needed components
    public EnigmaFrame() {
        super();

        // Sets one main layout and 3 subdivisions for each one of the sections
        this.setLayout(new GridLayout(3, 1, 25, 25));
        inputSection.setLayout(new GridLayout(1, 2));
        outputSection.setLayout(new GridLayout(1, 2));
        selectionSection.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 25));

        // Adds Action Listener to innerChooser
        innerChooser.addActionListener((e) -> {
            innerRotor = (String) innerChooser.getSelectedItem();
            // System.out.println(innerRotor);
        });

        // Adds Action Listener to middleChooser
        middleChooser.addActionListener((e) -> {
            middleRotor = (String) middleChooser.getSelectedItem();
            // System.out.println(middleRotor);
        });

        // Adds Action Listener to innerChooser
        outerChooser.addActionListener((e) -> {
            outerRotor = (String) outerChooser.getSelectedItem();
            // System.out.println(outerRotor);
        });

        // Adds Action Listeners to the Encryption Buttons
        encrypt.addActionListener((e) -> {
            if (!(encrypt.isSelected())) {
                encryptOrDecrypt = true;
                encrypt.setSelected(true);
                encrypt.setBackground(pressedColor);
                encrypt.setOpaque(true);
                decrypt.setSelected(false);
                decrypt.setBackground(nonPressedColor);
                decrypt.setOpaque(true);
            }
        });
        decrypt.addActionListener((e) -> {
            if (!(decrypt.isSelected())) {
                encryptOrDecrypt = false;
                decrypt.setSelected(true);
                decrypt.setBackground(pressedColor);
                decrypt.setOpaque(true);
                encrypt.setSelected(false);
                encrypt.setBackground(nonPressedColor);
                encrypt.setOpaque(true);
            }
        });

        // Adds ActionListener to startingChars
        startingChars.addActionListener((e) -> {
            startingCharString = startingChars.getText();
            // System.out.println(startingCharString);
        });

        // Prevents outputTextArea from being edited
        outputTextArea.setEditable(false);

        // Adds ActionListener to inputTextField
        intputTextField.addActionListener((e) -> {
            message = intputTextField.getText();
        });

        // Adds all the components in the selection section
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

        // Adds all the components in the Input Section
        inputSection.add(inputText);
        inputSection.add(intputTextField);
        intputTextField.setPreferredSize(new Dimension(200, 30));

        // Adds all the components in the Output Section
        outputSection.add(outputText);
        outputSection.add(outputTextArea);
        outputTextArea.setPreferredSize(new Dimension(200, 30));

        // Adds the layouts together and pack them
        this.add(selectionSection);
        this.add(inputSection);
        this.add(outputSection);
        this.pack();
    }

    // Helper Methods
    public Boolean encryptOrNot() {
        if (encryptOrDecrypt != null) {
            return encryptOrDecrypt;
        }
        return true;
    }

    public String getStartingChars() throws Throwable {
        // This would have been much simpler if I Could edit the Rotor class and make
        // sure it throws an Exception if the value of the starting character is not
        // acceptable
        String rotors[] = { "#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV",
                "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND" };

        // this checks whether or not the characters in the starting sequence are
        // contained in the rotors
        for (String rotor : rotors) {
            for (int i = 0; i < 3; i++) {
                if (rotor.indexOf(startingCharString.substring(i, i + 1)) < 0) {
                    throw new Throwable();
                }
            }
        }

        if (startingCharString != null) {
            return startingCharString;
        }

        return "AAA";
    }

    public String getMessage() {
        if (message != null) {
            return message;
        }
        return "HELLO#WORLD";
    }

    public void setMessage(String message) {
        // outputTextArea.setText("HELLOOOO");
        outputTextArea.setText(message);
    }

    public int getInner() {
        try {
            return Integer.parseInt(innerRotor);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public int getOuter() {
        try {
            return Integer.parseInt(outerRotor);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public int getMiddle() {
        try {
            return Integer.parseInt(middleRotor);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

}
