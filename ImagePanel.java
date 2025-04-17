package myproject.tijada_oop;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    final private Image image;

    // Constructor that accepts an image path
    public ImagePanel(String imagePath) {
        // Load the image
        image = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw the image, scaling it to fit the panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
        // No overlay effect, so we don't draw anything else on the panel
    }
}
