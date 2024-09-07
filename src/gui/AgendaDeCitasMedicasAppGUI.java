package gui;

import model.Doctor;
import gui.DoctorMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AgendaDeCitasMedicasAppGUI extends JFrame {

    private JTextField usernameField; // Campo para escribir el username
    private JPasswordField passwordField; //Campo para escribir el password

    public AgendaDeCitasMedicasAppGUI() {
        super("Agenda de Citas Medicas"); //Titulo de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Opcion para cerrar la ventana
        setSize(600, 800); //Tamaño de la ventana
        setLocationRelativeTo(null); //Ubicacion de la venta (En este caso el centro)

        // Cargar la imagen de fondo
        Image backgroundImage = new ImageIcon("/home/rvangelse/Documentos/AgendaDeCitasMedicas/src/fondo.jpg").getImage();

        // Crear el panel de login (menu) con la imagen de fondo dentro de la ventana
        JPanel loginPanel = new ImagePanel(backgroundImage);
        loginPanel.setLayout(new GridBagLayout()); //Ubicacion de los componentes del panel
        addGUIComponents(loginPanel); //Agrega los componentes al panel 

        this.getContentPane().add(loginPanel); //Arma el menu y el panel
    }

    //Construccion de los componentes del panel para el login 
    public void addGUIComponents(JPanel loginPanel) {
        GridBagConstraints gbc = new GridBagConstraints(); //Manipula la ubicacion de los componentes
        gbc.insets = new Insets(25, 7, 25, 2); // Margenes entre componentes

        // Etiqueta "Usuario : "
        JLabel usernameLabel = new JLabel("Usuario :"); //Etiqueta para el nombre
        usernameLabel.setFont(new Font("STFangsong", Font.BOLD, 20)); //Personalizacion de la etiqueta
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(usernameLabel, gbc);

        // Campo para escribir el usuario
        usernameField = new JTextField(18);
        usernameField.setFont(new Font("STFangsong", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(usernameField, gbc);

        // Etiqueta "Contraseña : "
        JLabel passwordLabel = new JLabel("Contraseña :");
        passwordLabel.setFont(new Font("STFangsong", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(passwordLabel, gbc);

        // Campo para escribir la contraseña
        passwordField = new JPasswordField(18);
        passwordField.setFont(new Font("STFangsong", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(passwordField, gbc);

        // Boton "Ingresar"
        JButton loginButton = new JButton("Ingresar");
        loginButton.setFont(new Font("STFangsong", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        //Agrega una accion al boton "Ingresar", en este caso la autentificacion de usuario
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        loginPanel.add(loginButton, gbc);

        // Botón "Registrar"
        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("STFangsong", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        // Acción al hacer clic en "Registrar"
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisterDialog();
            }
        });
        loginPanel.add(registerButton, gbc);

        //Setea que al presionar "Enter" se presionara el boton "Ingresar" por default 
        this.getRootPane().setDefaultButton(loginButton);
    }

    //Metodo de Autentificacion
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

    // Mostrar diálogo para registrar nuevo usuario
    private void showRegisterDialog() {
        // Crear diálogo para registrar usuario y contraseña
        JDialog registerDialog = new JDialog(this, "Nuevo Registro", true);
        registerDialog.setSize(400, 300);
        registerDialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Campo de texto para username
        JTextField registerUsernameField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        registerDialog.add(new JLabel("Nuevo Usuario:"), gbc);
        gbc.gridx = 1;
        registerDialog.add(registerUsernameField, gbc);

        // Campo de texto para password
        JPasswordField registerPasswordField = new JPasswordField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        registerDialog.add(new JLabel("Nueva Contraseña:"), gbc);
        gbc.gridx = 1;
        registerDialog.add(registerPasswordField, gbc);

        // Botón para confirmar registro
        JButton registerConfirmButton = new JButton("Registrar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        registerDialog.add(registerConfirmButton, gbc);

        registerConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = registerUsernameField.getText();
                String newPassword = new String(registerPasswordField.getPassword());

                // Aquí conectarás con la base de datos para guardar el nuevo usuario y contraseña
                JOptionPane.showMessageDialog(registerDialog, "Usuario registrado: " + newUsername);
                registerDialog.dispose(); // Cierra el diálogo
            }
        });

        registerDialog.setLocationRelativeTo(this);
        registerDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AgendaDeCitasMedicasAppGUI().setVisible(true);
            }
        });
    }
}