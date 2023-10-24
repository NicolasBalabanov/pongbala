package clases;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Palo {
    private int x, y;
    private int ancho, alto;
    private Color color;

    public Palo(int x, int y, int ancho, int alto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    public void dibujar(Graphics2D g) {
        g.setColor(color);
        g.fill(new Rectangle2D.Double(x, y, ancho, alto));
    }

    public Rectangle getRectangulo() {
        return new Rectangle(x, y, ancho, alto);
    }
}

