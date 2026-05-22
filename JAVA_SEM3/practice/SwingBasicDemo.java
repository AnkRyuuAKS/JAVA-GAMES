import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SwingBasicDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingBasicDemo().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Swing Basics Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout(5,8));
        frame.setContentPane(main);

        // Top: label + textfield + button
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(12);
        JButton greetBtn = new JButton("Greet");
        top.add(nameLabel); top.add(nameField); top.add(greetBtn);
        main.add(top, BorderLayout.NORTH);

        // Center: text area with scroll
        JTextArea area = new JTextArea(8, 30);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane areaScroll = new JScrollPane(area);
        main.add(areaScroll, BorderLayout.CENTER);

        // Left: choices (checkbox, radio, combo, list)
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JCheckBox cb = new JCheckBox("Subscribe");
        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup(); bg.add(r1); bg.add(r2);
        JComboBox<String> combo = new JComboBox<>(new String[]{"Student","Teacher","Other"});
        JList<String> list = new JList<>(new String[]{"Java","Python","C++"});
        list.setVisibleRowCount(3);
        //will only provide 3 rows to it:the above
        left.add(cb); left.add(Box.createVerticalStrut(4));
        left.add(r1); left.add(r2); left.add(Box.createVerticalStrut(4));
        left.add(new JLabel("Role:")); left.add(combo);
        left.add(Box.createVerticalStrut(8));
        left.add(new JLabel("Languages:")); left.add(new JScrollPane(list));
        main.add(left, BorderLayout.WEST);

        // Bottom: table
        String[] cols = {"Name","Age"};
        Object[][] data = { {"Alice", 23}, {"Bob", 29} };
        DefaultTableModel model = new DefaultTableModel(data, cols);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(300,70));
        main.add(new JScrollPane(table), BorderLayout.SOUTH);

        // Button action
        greetBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String role = (String) combo.getSelectedItem();
            boolean sub = cb.isSelected();
            String languages = String.join(", ", list.getSelectedValuesList());
            area.append("Hello " + name + " (" + role + ")" + 
                        (sub ? " [Subscribed]" : "") + "\nLanguages: " + languages + "\n\n");
        });

        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
