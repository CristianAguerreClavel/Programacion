package ejer3eventos;

import java.awt.*;
import java.awt.event.*;

class InterrupcionDeRaton2 extends Object implements MouseListener 
{
    public void mouseClicked(MouseEvent EventoQueLlega)
    {
        System.out.println("Click de raton");
        System.out.println(EventoQueLlega.getY());

    }
    
    public void mousePressed(MouseEvent EventoQueLlega)
    {
        System.out.println("Presion de raton");
        System.out.println(EventoQueLlega.getX());
    }

    public void mouseReleased(MouseEvent EventoQueLlega)
    {
        System.out.println("Se ha levantado el boton delraton");
        System.out.println(EventoQueLlega.getX());
        System.out.println(EventoQueLlega.getY());
    }
    
    public void mouseEntered(MouseEvent EventoQueLlega)
    {
        System.out.println("'Focus' de raton");
        Component Boton = (Component)EventoQueLlega.getSource();
        Boton.setBackground(Color.blue);
    }
    
    
    public void mouseExited(MouseEvent EventoQueLlega)
    {
        System.out.println("'Blur' de raton");
        Component Boton = (Component)EventoQueLlega.getSource();
        Boton.setBackground(Color.gray);
    }
}



/**
 *
 * @author mati
 */
public class Ejer3Eventos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Frame MiFrame = new Frame("Prueba eventos de raton");
        Panel MiPanel = new Panel();
        Button Hola = new Button("Saludo");
        Button Adios = new Button("Despedida");
        MiPanel.add(Hola); MiPanel.add(Adios);
        MiFrame.add(MiPanel);
        MiFrame.setSize(200,100);
        MiFrame.show();
        
        InterrupcionDeRaton2 i1 = new InterrupcionDeRaton2();
        
        Hola.addMouseListener (new InterrupcionDeRaton2());
        Adios.addMouseListener(i1);
    }
}
