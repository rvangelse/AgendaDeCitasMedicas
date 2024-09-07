package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; // Asegúrate de importar esto

public class DoctorMenu extends JFrame {
    public DoctorMenu() {
        super("Bienvenido, Doctor!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        Image backgroundImage = new ImageIcon("/home/rvangelse/Documentos/AgendaDeCitasMedicas/src/fondo.jpg").getImage();

        // Crear el panel del doctor con la imagen de fondo
        JPanel doctorPanel = new ImagePanel(backgroundImage);
        doctorPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margins between components

        // Etiqueta de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido, Doctor!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        doctorPanel.add(welcomeLabel, gbc);

        // Botón para agregar citas disponibles
        JButton addAppointmentButton = new JButton("Agregar Cita Disponible");
        addAppointmentButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        doctorPanel.add(addAppointmentButton, gbc);

        // Botón para ver citas agendadas
        JButton viewAppointmentsButton = new JButton("Ver Citas Agendadas");
        viewAppointmentsButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        doctorPanel.add(viewAppointmentsButton, gbc);

        // Acción para agregar citas
        addAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddAvailableAppointments();
            }
        });

        this.getContentPane().add(doctorPanel);
    }

    private void showAddAvailableAppointments() {
    // Crear un diálogo personalizado con la misma imagen de fondo
    JDialog dialog = new JDialog(this, "Agregar Cita Disponible", true);
    dialog.setSize(600, 800);

    // Usar ImagePanel para el fondo del diálogo
    Image backgroundImage = new ImageIcon("/home/rvangelse/Documentos/AgendaDeCitasMedicas/src/fondo.jpg").getImage();
    ImagePanel dialogPanel = new ImagePanel(backgroundImage);
    dialogPanel.setLayout(new GridBagLayout());  // Usar GridBagLayout como en el panel principal
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);

    // Calendario para seleccionar la fecha
    JDateChooser dateChooser = new JDateChooser();
    gbc.gridx = 0;
    gbc.gridy = 0;
    dialogPanel.add(new JLabel("Seleccione la fecha disponible:"), gbc);
    gbc.gridx = 1;
    dialogPanel.add(dateChooser, gbc);

    // Campo de texto para ingresar la hora
    JTextField timeField = new JTextField(10);
    gbc.gridx = 0;
    gbc.gridy = 1;
    dialogPanel.add(new JLabel("Ingrese la hora disponible [hh:mm]:"), gbc);
    gbc.gridx = 1;
    dialogPanel.add(timeField, gbc);

    // Botón para confirmar la cita
    JButton confirmButton = new JButton("Confirmar");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    dialogPanel.add(confirmButton, gbc);

    confirmButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener la fecha y hora seleccionada
            java.util.Date selectedDate = dateChooser.getDate();
            String time = timeField.getText();

            if (selectedDate != null && !time.isEmpty()) {
                // Formatear la fecha en el formato deseado
                java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = dateFormat.format(selectedDate);

                // Agregar la cita al doctor logueado (UIMenu.doctorLogged)
                UIMenu.doctorLogged.addAvailableAppointment(formattedDate, time);
                JOptionPane.showMessageDialog(dialog, "Cita agregada para: " + formattedDate + " a las " + time);
                dialog.dispose(); // Cierra el diálogo
            } else {
                JOptionPane.showMessageDialog(dialog, "Por favor, seleccione una fecha y hora válida.");
            }
        }
    });

    // Agregar el panel con el fondo al diálogo
    dialog.getContentPane().add(dialogPanel);

    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
}

// Clase interna para crear un JPanel con imagen de fondo
class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
}