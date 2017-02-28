import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/*
 * Klasa z przesloniętą metodą paintComponent umożliwiająca ustawienie tła
 */
public class JPanelWithBackground extends JPanel{

	private Image image;
    public JPanelWithBackground(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
