package feiner.dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class GUI extends JFrame {
    private EnglishDictionary dictionary;
    private JTextField inputField;
    private JTextArea definitionsArea;

    public GUI() {
        setTitle("English Dictionary");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        try {
            dictionary = new EnglishDictionary();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "didn't work:(");
            return;
        }
        inputField = new JTextField();
        inputField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                updateDefinitions(inputField.getText());
            }
        });
        add(inputField, BorderLayout.NORTH);
        definitionsArea = new JTextArea();
        definitionsArea.setEditable(false);
        add(new JScrollPane(definitionsArea), BorderLayout.CENTER);
    }

    private void updateDefinitions(String word) {
        definitionsArea.setText(""); // Clears prev definitions
        if (!word.isEmpty()) {
            List<String> definitions = dictionary.getDefinition(word);
            if (definitions != null && !definitions.isEmpty()) {
                for (String d : definitions) {
                    definitionsArea.append(d);
                }
            } else {
                definitionsArea.setText("No definitions found.");
            }
        }
    }

    public static void main(String[] args) {
            GUI frame = new GUI();
            frame.setVisible(true);
        }
    }
