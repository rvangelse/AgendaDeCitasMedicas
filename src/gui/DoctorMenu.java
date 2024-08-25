package gui;

import javax.swing.*;

public class DoctorMenu extends JFrame {
    public DoctorMenu() {
        super("Doctor Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome, Doctor!", SwingConstants.CENTER);
        add(welcomeLabel);

        // Aquí puedes añadir más componentes para las funcionalidades del doctor
    }
}
