package gui;
import java.awt.*;
import javax.swing.*;


public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
         // Verifica si la imagen se cargó correctamente
         if (this.backgroundImage == null) {
            System.out.println("Error: Imagen no cargada.");
        }


        

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen en todo el panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}