package clases;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Bola {
    private int x, y;
    private int diametro;
    private Color color;
    private double velocidadX;
    private double velocidadY;

    public Bola(int x, int y, int diametro, Color color) {
        this.x = x;
        this.y = y;
        this.diametro = diametro;
        this.color = color;
        this.velocidadX = 0;
        this.velocidadY = 0;
    }

    public void dibujar(Graphics2D g) {
        g.setColor(color);
        g.fill(new Ellipse2D.Double(x, y, diametro, diametro));
    }

    public void aplicarFuerza(double fuerzaX, double fuerzaY) {
        velocidadX += fuerzaX;
        velocidadY += fuerzaY;
    }

    public void mover() {
        x += velocidadX;
        y += velocidadY;
    }

    public Rectangle getRectangulo() {
        return new Rectangle(x, y, diametro, diametro);
    }
}

