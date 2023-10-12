import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CollegeMessRegisterApp {
    private List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CollegeMessRegisterApp().run();
        });
    }

    private void run() {
        JFrame frame = new JFrame("College Mess Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("College Mess Register");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel rollLabel = new JLabel("Roll Number:");
        JTextField rollField = new JTextField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String rollNumber = rollField.getText();

                if (!name.isEmpty() && !rollNumber.isEmpty()) {
                    students.add(new Student(name, rollNumber));
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                    nameField.setText("");
                    rollField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                }
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(rollLabel);
        inputPanel.add(rollField);
        inputPanel.add(registerButton);

        panel.add(inputPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class Student {
        private String name;
        private String rollNumber;

        public Student(String name, String rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
        }

        public String getName() {
            return name;
        }

        public String getRollNumber() {
            return rollNumber;
        }
    }
}

