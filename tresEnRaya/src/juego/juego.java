
package juego;


public class juego {
    
    private byte turno = 1; // se genera turno para poder empezar el juego
    private byte ganadorDelJuego=0; // se marca el ganador en 0 para que no ocurra error
    private String marca_X="X";
    private String marca_O="O";
    private boolean error = false;
    private String tablero[][]={{"","",""},//Se crea el tablero del juego
                                 {"","",""},
                                 {"","",""}
    };


    public String setMovimiento(int posicion) {
        String out="";
        //Se imprimi el movimiento y se verifica si el ganador gana con la ultima jugada
        if (turno==1) {
            out = marcar(posicion, this.marca_X);
            turno=2;
            //si el jugador gana se llama paa terminar el juego
            if ( gano(this.tablero, this.marca_X) )
                this.ganadorDelJuego=1;
            else if ( empate() )
                this.ganadorDelJuego=3;                       
            }
        else{
            out =  marcar(posicion , this.marca_O);
            turno = 1;
            if ( gano(this.tablero, this.marca_O) )
                this.ganadorDelJuego=2;
            else if ( empate() )
                this.ganadorDelJuego=3;
            }
        
        //si todavia no hay ganador entonces el juego retorna solamente la jugada 
        //ya sea de x o sea o
        return out;
    }

    //Solo devuelve el error
    public boolean getError() {
       return this.error;
    }
    
    //Verifica el turno y cambia consigna
    public String getTurno(){
        return (this.turno==1)?"Turno de X ": "Turno de O";
    }
    
    public byte ganador(){  
        return this.ganadorDelJuego;
    }
    
    //Se reinicia todo el tablero de vuelta
    //y se vuelve a rellenar vacío 
    public void JugarOtraVez() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero [i][j]="";
            }
        }
        this.error = false;
        this.turno=1;
        this.ganadorDelJuego=0;
    }
    
    
    //se marca la casilla del jugador en el momento de su turno
    private String marcar(int posicion, String value) {
        String marcar = "";
        switch(posicion){
            
            case 1: 
                marcar = sub_marcar(0,0,value);break;
            case 2:
                marcar = sub_marcar(0,1,value);break;
            case 3:
                marcar = sub_marcar(0,2,value); break;
            case 4:
                marcar = sub_marcar(1,0,value); break;
            case 5:
                marcar = sub_marcar(1,1, value); break;
            case 6:
                marcar = sub_marcar(1,2,value); break;
            case 7:
                marcar = sub_marcar(2,0, value); break;
            case 8:
                marcar = sub_marcar(2,1, value); break;
            case 9:
                marcar = sub_marcar(2,2, value); break;
        }
        
        
        return marcar;
    }

    
    //Busca el ganador
    private boolean gano(String matriz [] [], String marca) {
       
        //busqueda de ganador por filas
        for ( int i = 0 ; i < matriz.length ; i++ )
        {
            byte count=0;
            for ( int j = 0 ; j < matriz.length ; j++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        //busqueda de ganador por columnas
        for ( int j = 0 ; j < matriz.length ; j++ )
        {
            byte count=0;
            for ( int i = 0 ; i < matriz.length ; i++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        //diagonales
        if(  matriz[0][0].equals(marca) && matriz[1][1].equals(marca) && matriz[2][2].equals(marca) )
            return true;

        if(  matriz[0][2].equals(marca) && matriz[1][1].equals(marca) && matriz[2][0].equals(marca) )
            return true;

        return false;

    }

    
    // Se verifica que la casilla este vacia
    private String sub_marcar(int x, int y, String value)
    {
        String marca="";
        this.error=false;
        if( this.tablero[x][y].equals("") ) //se puede marcar
        {
            this.tablero[x][y] = value;
            marca = value;
        }        
        else//ya esta marcado
        {
            marca = this.tablero[x][y];
            this.error=true;//Error=>se trata de marcar casilla ya marcada
        }
        return marca;
    }
    
    //Verifica si se puede seguir jugando
    private boolean empate(){
                for ( int i = 0 ; i < tablero.length ; i++ )
           for ( int j = 0 ; j < tablero.length ; j++)
                if( tablero[i][j].equals(""))
                    return false;
        return true;
    }
}
