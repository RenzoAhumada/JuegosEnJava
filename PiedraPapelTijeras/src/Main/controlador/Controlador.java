package Main.controlador;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Controlador {

    private final Random RD = new Random();
    private int ganaJugador = 0;
    private int ganaComputadora=0;
    

    public int turnoMaquina() {
        return RD.nextInt(2);
    }

   
    public String versus(int valorUsuario, int valorMaquina) {

        if (valorMaquina == valorUsuario) {

            return "- Empate -";
        } else {

            switch (valorMaquina) {
                case 0: {
                    if (valorUsuario == 1) {
                        return "Gana jugador";
                    }
                }
                break;
                case 1: {
                    if (valorUsuario == 2) {
                        return "Gana jugador";
                    }
                }
                break;
                case 2: {
                    if (valorUsuario == 0) {
                        return "Gana jugador";
                    }
                }
                break;
            }
        }

        return "Gana computadora";
    }

    public ImageIcon traductorTurnero(int val) {
        String resImg = "";
        switch(val){
            case 0:{ resImg = "/Image/piedra.png"; }break;
            case 1:{ resImg = "/Image/papel.png"; }break;
            case 2:{ resImg = "/Image/tijera.png"; }break;
        }
        ImageIcon imgCon = new ImageIcon(getClass().getResource(resImg));
        ImageIcon imgJlb = new ImageIcon(imgCon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        return imgJlb;
    }
    
public void contadorDeVictorias(String valor) {
    switch (valor) {
        case "Gana jugador": {
            ganaJugador++;
            break;
        }
        case "Gana computadora": {
            ganaComputadora++;
            break;
        }
    }
}

    public int getGanaPlayer() {
        return ganaJugador;
    }

    public int getGanaComputer() {
        return ganaComputadora;
    }
    
    

}
