package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Doctor;

public class AgendaDeCitasMedicasAppGUI extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Doctor doctor; 

    public AgendaDeCitasMedicasAppGUI(){

       

        super("Agenda de Citas Medicas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize( 450, 650);
        setLocationRelativeTo(null);
    
        AddGUIComponents();

    }
    public void AddGUIComponents(){
        SpringLayout springLayout = new SpringLayout();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(springLayout);

        //username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        usernameField = new JTextField(15);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 18));
        springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 125, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, usernameField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usernameField, 125, SpringLayout.NORTH, loginPanel);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        
        //password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 180, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 180, SpringLayout.NORTH, loginPanel);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        //login button
        JButton LoginButton = new JButton("Login");
        LoginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        springLayout.putConstraint(SpringLayout.WEST, LoginButton, 185, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, LoginButton, 260, SpringLayout.NORTH, loginPanel);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();

            }
        });


        loginPanel.add(LoginButton);
        this.getRootPane().setDefaultButton(LoginButton);
        this.getContentPane().add(loginPanel);

    }

    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

         // Aquí creas un objeto Doctor (puedes obtener estos datos de una base de datos más adelante)
         Doctor doctor = new Doctor("rvangelse", "2601");

        // Verificas el usuario y contraseña
        if (doctor.getUsername().equals(username) && doctor.checkPassword(password)) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed");
        }
    }
    
}
