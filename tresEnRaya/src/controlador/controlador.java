
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import juego.juego;
import vista.interfaz;

public class controlador implements ActionListener {
    private interfaz vista;
    private juego juego;
    private String titulo = "Tres en raya";
    
    
    /*Se crea el constructor por defecto*/
    public controlador(interfaz vista, juego juego){
        this.vista = vista;
        this.juego=juego;
    }
    
    //Iniciamos las vistas del juego
    public void iniciarJuego(){
        vista.setTitle(this.titulo);
        vista.setLocationRelativeTo(null);
        this.vista.casilla1.addActionListener(this);
        this.vista.casilla2.addActionListener(this);
        this.vista.casilla3.addActionListener(this);
        this.vista.casilla4.addActionListener(this);
        this.vista.casilla5.addActionListener(this);
        this.vista.casilla6.addActionListener(this);
        this.vista.casilla7.addActionListener(this);
        this.vista.casilla8.addActionListener(this);
        this.vista.casilla9.addActionListener(this);
    }
    
    
    
    // Se capturan las acciones de las imagenes de los botones a partir de esta sintaxis
    //dependiendo del boton pulsado
     public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        
        
        if( this.juego.ganador()== 0 )
        {
        if( boton == this.vista.casilla1 )
            this.vista.casilla1.setText( this.juego.setMovimiento(1) );
        else if(boton == this.vista.casilla2)
            this.vista.casilla2.setText( this.juego.setMovimiento(2) );
        else if(boton == this.vista.casilla3)
            this.vista.casilla3.setText( this.juego.setMovimiento(3) );
        else if(boton == this.vista.casilla4)
            this.vista.casilla4.setText( this.juego.setMovimiento(4) );        
        else if(boton == this.vista.casilla5)
            this.vista.casilla5.setText( this.juego.setMovimiento(5) );
        else if(boton == this.vista.casilla6)
            this.vista.casilla6.setText( this.juego.setMovimiento(6) );
        else if(boton == this.vista.casilla7)
            this.vista.casilla7.setText( this.juego.setMovimiento(7) );
        else if(boton == this.vista.casilla8)
            this.vista.casilla8.setText( this.juego.setMovimiento(8) );
        else if(boton == this.vista.casilla9)
            this.vista.casilla9.setText( this.juego.setMovimiento(9) );
        if (this.juego.getError())
            JOptionPane.showMessageDialog(null, "Error en la jugada");
        }
        if(this.juego.ganador()==1)
            mensaje(" 'X' ");
        else if (this.juego.ganador()==2)
            mensaje(" 'O' ");
        else if(this.juego.ganador()==3)
            mensaje("Es un empate");
    }
    
     
     //Imprimimos el ganador y si desea jugar otra vez
     private void mensaje(String s)
    {
           int seleccion = JOptionPane.showOptionDialog(null,"Gano el jugador " + s + "\n ¿Que desea hacer?", "Fin del juego",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,    // null para icono por defecto.
                       new Object[] { "   Jugar otra vez   ", "   Salir de Programa   " },
                       "Jugar otra vez");

            if (seleccion != -1)
                if( (seleccion+1)==1 )
                {
                    this.juego.JugarOtraVez();
                    this.vista.setTitle(titulo);
                    this.vista.casilla1.setText( "" );
                    this.vista.casilla2.setText( "" );
                    this.vista.casilla3.setText( "" );
                    this.vista.casilla4.setText( "" );
                    this.vista.casilla5.setText( "" );
                    this.vista.casilla6.setText( "" );
                    this.vista.casilla7.setText( "" );
                    this.vista.casilla8.setText( "" );
                    this.vista.casilla9.setText( "" );
                }
                else
                    System.exit(0);
    }

    
}
