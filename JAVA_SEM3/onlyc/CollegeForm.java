import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollegeForm extends JFrame {

    // Fields
    JTextField Name, Mobile;
    JComboBox<String> Age;
    JTextArea About;
    JRadioButton student, Teacher, others;
    JRadioButton male, female, trans;
    JCheckBox tcBox, Subscribed;
    JTextArea Output;
    JButton btnSubmit, btnReset;

    public CollegeForm() {
        setTitle("College Details Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ------------------ TOP PANEL ------------------
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 102, 204));
        JLabel title = new JLabel("NIT JAMSHEDPUR");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        topPanel.add(title);
        add(topPanel, BorderLayout.NORTH);

        // ------------------ CENTER PANEL ------------------
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        add(centerPanel, BorderLayout.CENTER);

        // ===== LEFT PANEL =====
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5); // padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // Name
        gbc.gridx = 0; gbc.gridy = row;
        leftPanel.add(new JLabel("Name:"), gbc);
        Name = new JTextField(15);
        gbc.gridx = 1;
        leftPanel.add(Name, gbc);
        row++;

        // Age
        gbc.gridx = 0; gbc.gridy = row;
        leftPanel.add(new JLabel("Age:"), gbc);
        String[] ages = new String[11];
        for(int i = 0; i <= 10; i++) ages[i] = String.valueOf(10 + i);
        Age = new JComboBox<>(ages);
        gbc.gridx = 1;
        leftPanel.add(Age, gbc);
        row++;

        // Mobile
        gbc.gridx = 0; gbc.gridy = row;
        leftPanel.add(new JLabel("Mobile:"), gbc);
        Mobile = new JTextField(15);
        gbc.gridx = 1;
        leftPanel.add(Mobile, gbc);
        row++;

        // About
        gbc.gridx = 0; gbc.gridy = row;
        leftPanel.add(new JLabel("About:"), gbc);
        About = new JTextArea(4, 15);
        About.setLineWrap(true);
        About.setWrapStyleWord(true);
        JScrollPane scrollAbout = new JScrollPane(About);
        gbc.gridx = 1;
        leftPanel.add(scrollAbout, gbc);
        row++;

        // Gender
        gbc.gridx = 0; gbc.gridy = row;
        leftPanel.add(new JLabel("Gender:"), gbc);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        trans = new JRadioButton("Trans");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male); genderGroup.add(female); genderGroup.add(trans);
        genderPanel.add(male); genderPanel.add(female); genderPanel.add(trans);
        gbc.gridx = 1;
        leftPanel.add(genderPanel, gbc);
        row++;

        // Role
        gbc.gridx = 0; gbc.gridy = row;
        leftPanel.add(new JLabel("Role:"), gbc);
        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        student = new JRadioButton("Student");
        Teacher = new JRadioButton("Teacher");
        others = new JRadioButton("Others");
        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(student); roleGroup.add(Teacher); roleGroup.add(others);
        rolePanel.add(student); rolePanel.add(Teacher); rolePanel.add(others);
        gbc.gridx = 1;
        leftPanel.add(rolePanel, gbc);
        row++;

        // Subscription checkbox
        gbc.gridx = 0; gbc.gridy = row;
        Subscribed = new JCheckBox("Have you subscribed?");
        gbc.gridwidth = 2;
        leftPanel.add(Subscribed, gbc);
        row++;

        // Terms & conditions
        gbc.gridx = 0; gbc.gridy = row;
        tcBox = new JCheckBox("I accept terms and conditions");
        gbc.gridwidth = 2;
        leftPanel.add(tcBox, gbc);
        row++;

        // Buttons
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 1;
        btnSubmit = new JButton("Submit");
        leftPanel.add(btnSubmit, gbc);
        gbc.gridx = 1;
        btnReset = new JButton("Reset");
        leftPanel.add(btnReset, gbc);

        centerPanel.add(leftPanel);

        // ===== RIGHT PANEL =====
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Output"));
        Output = new JTextArea();
        Output.setEditable(false);
        Output.setLineWrap(true);
        Output.setWrapStyleWord(true);
        JScrollPane scrollOutput = new JScrollPane(Output);
        rightPanel.add(scrollOutput, BorderLayout.CENTER);
        centerPanel.add(rightPanel);

        // ------------------ BOTTOM PANEL ------------------
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        bottomPanel.setBackground(new Color(230, 230, 250));
        bottomPanel.add(new JLabel("Contact: info@nitjsr.ac.in"));
        bottomPanel.add(new JLabel("Phone: +91-9876543210"));
        bottomPanel.add(new JLabel("Website: www.nitjsr.ac.in"));
        add(bottomPanel, BorderLayout.SOUTH);

        // ------------------ EVENT LISTENERS ------------------
        btnSubmit.addActionListener(e -> {
            if(!tcBox.isSelected()){
                JOptionPane.showMessageDialog(this, "Please accept terms & conditions");
                return;
            }

            String info = "Name: " + Name.getText() + "\n";
            info += "Age: " + Age.getSelectedItem() + "\n";
            info += "Mobile: " + Mobile.getText() + "\n";
            info += "About: " + About.getText() + "\n";
            info += "Gender: " + (male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Trans") + "\n";
            info += "Role: " + (student.isSelected() ? "Student" : Teacher.isSelected() ? "Teacher" : "Others") + "\n";
            info += "Subscribed: " + (Subscribed.isSelected() ? "Yes" : "No") + "\n";

            Output.setText(info);
        });

        btnReset.addActionListener(e -> {
            Name.setText("");
            Mobile.setText("");
            About.setText("");
            Age.setSelectedIndex(0);
            male.setSelected(false);
            female.setSelected(false);
            trans.setSelected(false);
            student.setSelected(false);
            Teacher.setSelected(false);
            others.setSelected(false);
            Subscribed.setSelected(false);
            tcBox.setSelected(false);
            Output.setText("");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CollegeForm());
    }
}
