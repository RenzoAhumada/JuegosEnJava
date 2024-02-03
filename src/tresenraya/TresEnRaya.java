
package tresenraya;

import controlador.controlador;
import juego.juego;
import vista.interfaz;


public class TresEnRaya {


    public static void main(String[] args) {
        juego modelo = new juego();
        interfaz vista = new interfaz();
        controlador controlador = new controlador(vista, modelo);
        controlador.iniciarJuego();
        vista.setVisible(true);
        
    }
    
}
