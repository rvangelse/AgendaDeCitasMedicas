package gui;
import model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AgendaDeCitasMedicasAppGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AgendaDeCitasMedicasAppGUI() {
        super("Agenda de Citas Medicas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);
        setLocationRelativeTo(null);

        // Cargar la imagen de fondo
        Image backgroundImage = new ImageIcon("/home/rvangelse/Documentos/AgendaDeCitasMedicas/src/fondo.jpg").getImage();

        // Crear el panel de login con la imagen de fondo
        JPanel loginPanel = new ImagePanel(backgroundImage);
        loginPanel.setLayout(new GridBagLayout());

        addGUIComponents(loginPanel);

        this.getContentPane().add(loginPanel);
    }

    public void addGUIComponents(JPanel loginPanel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(25, 7, 25, 2); // Margins between components

        // Username Label
        JLabel usernameLabel = new JLabel("Usuario :");
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(usernameLabel, gbc);

        // Username Field
        usernameField = new JTextField(15);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(usernameField, gbc);

        // Password Label
        JLabel passwordLabel = new JLabel("Contraseña :");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(passwordLabel, gbc);

        // Password Field
        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(passwordField, gbc);

        // Login Button
        JButton loginButton = new JButton("Ingresar");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        loginPanel.add(loginButton, gbc);

        // Set the loginButton as the default button to press when Enter is hit
        this.getRootPane().setDefaultButton(loginButton);
    }

    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        Doctor doctor = new Doctor("rvangelse", "2601");

        if (doctor.getUsername().equals(username) && doctor.checkPassword(password)) {
            DoctorMenu doctorMenu = new DoctorMenu();
            doctorMenu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Datos Incorrectos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AgendaDeCitasMedicasAppGUI().setVisible(true);
            }
        });
    }
}