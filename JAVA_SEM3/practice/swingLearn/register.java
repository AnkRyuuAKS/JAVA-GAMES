import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class register extends JFrame {

    JTextField tfName, tfMobile;
    JRadioButton male, female;
    JTextArea taAddress;
    JCheckBox cbTerms;
    JButton btnSubmit, btnReset;
    JTextArea taOutput;

    register() {
        setTitle("User Registration Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main container
        setLayout(new GridLayout(1, 1));

        // ===== LEFT PANEL – Form =====
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 2, 5, 5));

        // Name
        leftPanel.add(new JLabel("Name:"));
        tfName = new JTextField();
        leftPanel.add(tfName);

        // Mobile
        leftPanel.add(new JLabel("Mobile:"));
        tfMobile = new JTextField();
        leftPanel.add(tfMobile);

        // Gender
        leftPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        leftPanel.add(genderPanel);

        // Address
        leftPanel.add(new JLabel("Address:"));
        taAddress = new JTextArea(3, 20);
        JScrollPane sp = new JScrollPane(taAddress);
        leftPanel.add(sp);

        // Terms & Conditions
        cbTerms = new JCheckBox("I accept terms and conditions");
        leftPanel.add(cbTerms);
        leftPanel.add(new JLabel("")); // empty

        // Buttons
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");

        leftPanel.add(btnSubmit);
        leftPanel.add(btnReset);

        // ===== RIGHT PANEL – Output =====
        taOutput = new JTextArea();
        taOutput.setEditable(false);
        JScrollPane spOutput = new JScrollPane(taOutput);

        add(leftPanel);
        add(spOutput);

        // ===== SUBMIT BUTTON ACTION =====
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cbTerms.isSelected()) {
                    JOptionPane.showMessageDialog(null, 
                        "Please accept terms and conditions!");
                    return;
                }

                String name = tfName.getText();
                String mobile = tfMobile.getText();
                String gender = male.isSelected() ? "Male" :
                                female.isSelected() ? "Female" : "Not Selected";
                String address = taAddress.getText();

                taOutput.setText("Submitted Successfully!\n\n");
                taOutput.append("Name: " + name + "\n");
                taOutput.append("Mobile: " + mobile + "\n");
                taOutput.append("Gender: " + gender + "\n");
                taOutput.append("Address:\n" + address + "\n");

                JOptionPane.showMessageDialog(null, "Submitted Successfully!");
            }
        });

        // ===== RESET BUTTON ACTION =====
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfMobile.setText("");
                taAddress.setText("");
                bg.clearSelection();
                cbTerms.setSelected(false);
                taOutput.setText("");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new register();
    }
}
