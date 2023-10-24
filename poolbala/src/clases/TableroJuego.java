package clases;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TableroJuego extends JPanel implements KeyListener, MouseListener {
    private Bola bola1, bola2;
    private Palo palo;
    private boolean paloActivo = false;

    public TableroJuego() {
        setPreferredSize(new Dimension(800, 600));
        bola1 = new Bola(50, 200, 20, Color.RED);
        bola2 = new Bola(200, 200, 20, Color.BLUE);
        palo = new Palo(400, 300, 100, 10, Color.GREEN);
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        bola1.dibujar(g2);
        bola2.dibujar(g2);
        if (paloActivo) {
            palo.dibujar(g2);
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            paloActivo = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            paloActivo = false;
            aplicarFuerzaABola(bola1);
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void mouseClicked(MouseEvent e) {
        if (palo.getRectangulo().contains(e.getPoint())) {
            paloActivo = true;
        }
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        if (paloActivo) {
            aplicarFuerzaABola(bola1);
            paloActivo = false;
        }
    }

    private void aplicarFuerzaABola(Bola bola) {
        int fuerza = 5; // Ajusta la fuerza según tus necesidades
        int direccionX = palo.getRectangulo().x - bola.getRectangulo().x;
        int direccionY = palo.getRectangulo().y - bola.getRectangulo().y;

        double magnitud = Math.sqrt(direccionX * direccionX + direccionY * direccionY);

        double fuerzaX = (fuerza * direccionX) / magnitud;
        double fuerzaY = (fuerza * direccionY) / magnitud;

        bola.aplicarFuerza(fuerzaX, fuerzaY);
    }

    public void actualizar() {
        bola1.mover();
        bola2.mover();
        // Añade cualquier lógica adicional que necesites (por ejemplo, detección de colisiones)
        repaint();
    }
}
