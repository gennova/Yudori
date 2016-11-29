/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author legollas
 */
public class PanelBck extends JPanel {

    private Image image;

    public PanelBck(Image image) {
        setOpaque(false);
        image = new ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/Capture.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D gd = (Graphics2D) g.create();

        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        gd.dispose();
    }

}