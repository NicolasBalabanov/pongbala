package principal;

import javax.swing.*;

import clases.TableroJuego;

public class JuegoPrincipal {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Juego de Pool");
        TableroJuego tablero = new TableroJuego();
        ventana.add(tablero);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        // Inicia el bucle de juego aquí (maneja el tiempo, actualiza la lógica del juego, etc.)
        while (true) {
            tablero.actualizar();
            try {
                Thread.sleep(10); // Controla la velocidad del juego
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

