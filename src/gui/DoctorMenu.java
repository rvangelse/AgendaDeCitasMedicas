package gui;
import java.awt.*;
import javax.swing.*;

public class DoctorMenu extends JFrame {
    public DoctorMenu() {
        super("Bienvenido, Doctor!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);
        setLocationRelativeTo(null);
        Image backgroundImage = new ImageIcon("/home/rvangelse/Documentos/AgendaDeCitasMedicas/src/fondo.jpg").getImage();

        // Crear el panel de login con la imagen de fondo
        JPanel DoctorPanel = new ImagePanel(backgroundImage);

        JLabel welcomeLabel = new JLabel("Bienvenido, Doctor!", SwingConstants.CENTER);
        add(welcomeLabel);
        this.getContentPane().add(DoctorPanel);

        // Aquí puedes añadir más componentes para las funcionalidades del doctor
    }
}
