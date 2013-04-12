package creandoventana;

import java.awt.Frame;
import java.awt.Point;



class Marco2 extends Frame
{
    Marco2(String Titulo)
    {
        this.setTitle(Titulo);
        this.setVisible(false);
    }
    
    Marco2(String Titulo, int Ancho, int Alto)
    {
        this(Titulo);
        this.setSize(Ancho, Alto);
        this.setVisible(true);
    }
    
    Marco2()
    {
        this("Mi primera ventana",400,200);
    }
}

class Marco4 extends Frame
{
    Marco4(String Titulo)
    {
        this.setTitle(Titulo);
        this.setVisible(true);
    }
    
    Marco4(String Titulo, int Ancho, int Alto)
    {
        this(Titulo);
        this.setSize(Ancho, Alto);
    }
    
    Marco4(String Titulo, int Ancho, int Alto, int PosX, int PosY)
    {
        this(Titulo,Ancho,Alto);
        this.setLocale(new Point(PosX,PosY));
    }
    
    Marco4()
    {
        this("Mi primera ventana",400,200,100,100);
    }
}


public class CreandoVentana 
{

    public static void main(String[] args) 
    {
        /*VENTANAS 1
         * Frame MiMarco = new Frame();
        MiMarco.setSize(400,200);
        MiMarco.setTitle("Mi primera Ventana");
        MiMarco.setVisible(true);*/
        
        /*VENTANAS 2
        /*Marco2 MiVentana1 = new Marco2();
        Marco2 MiVentana2 = new Marco2("Ventana2",300,50);
        Marco2 MiVentana3 = new Marco2("Ventana3");*/
        
        //VENTANAS 3
        /*Frame MiMarco = new Frame();
        MiMarco.setSize(400,200);
        MiMarco.setTitle("Mi primera Ventana");
        MiMarco.setLocation(new Point(100,220));
        MiMarco.setVisible(true);*/
        
        
        
    }
}
