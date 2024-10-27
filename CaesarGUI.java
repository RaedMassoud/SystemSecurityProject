/**
 * Created by RaedMassoud on 10/27/2024
 * Project: SystemSecurityProject
 */

import javax.swing.*;

public class CaesarGUI extends JFrame {
    private JTextField inputField, keyField;
    private JTextArea outputArea;
    private JButton encryptButton, decryptButton;

    public CaesarGUI() {
        setTitle("Caesar GUI");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Labels
        // Input label
        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setBounds(10, 10, 100, 25);
        add(inputLabel);

        // Key label
        JLabel keyLabel = new JLabel("Key:");
        keyLabel.setBounds(10, 50, 100, 25);
        add(keyLabel);

        // Fields
        // Input field
        inputField = new JTextField();
        inputField.setBounds(120, 10, 250, 25);
        add(inputField);

        // Key field
        keyField = new JTextField();
        keyField.setBounds(120, 50, 50, 25);
        add(keyField);

        // Buttons
        // Encrypt button
        encryptButton = new JButton("Encrypt");
        encryptButton.setFocusable(false);
        encryptButton.setBounds(10, 90, 120, 25);
        encryptButton.addActionListener(e -> {
            String inputText = inputField.getText().trim();
            String keyText = keyField.getText().trim();

            if (inputText.isEmpty() || keyText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Input and Key must not be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if either field is empty
            }

            int key = Integer.parseInt(keyText);
            String encrypted = Caesar.encrypt(inputText, key);
            outputArea.setText(encrypted);
        });
        add(encryptButton);

        // Decrypt button
        decryptButton = new JButton("Decrypt");
        decryptButton.setFocusable(false);
        decryptButton.setBounds(135, 90, 120, 25);
        decryptButton.addActionListener(e -> {
            String inputText = inputField.getText().trim();
            String keyText = keyField.getText().trim();

            if (inputText.isEmpty() || keyText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Input and Key must not be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if either field is empty
            }

            int key = Integer.parseInt(keyText);
            String decrypted = Caesar.decrypt(inputText, key);
            outputArea.setText(decrypted);
        });
        add(decryptButton);

        // Copy output to input button
        JButton copyButton = new JButton("Copy to Input");
        copyButton.setFocusable(false);
        copyButton.setBounds(260, 90, 120, 25);
        copyButton.addActionListener(e -> {
                inputField.setText(outputArea.getText());
        });
        add(copyButton);

        // Output area
        outputArea = new JTextArea();
        outputArea.setBounds(10, 130, 360, 100);
        outputArea.setEditable(false);
        add(outputArea);
    }
}
