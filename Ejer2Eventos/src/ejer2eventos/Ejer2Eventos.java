package ejer2eventos;

import java.awt.event.*;
import java.awt.*;


class InterrupcionDeRaton1 implements MouseListener {
    

    public void mouseClicked(MouseEvent EventoQueLlega)
    {
        System.out.println("Click de raton");
    }
    
    public void mousePressed(MouseEvent EventoQueLlega)
    {
        System.out.println("Presion de raton");
    }
    
    public void mouseReleased(MouseEvent EventoQueLlega)
    {
        System.out.println("Se ha levantado el boton delraton");
    }
    
    public void mouseEntered(MouseEvent EventoQueLlega)
    {
        System.out.println("'Focus' de raton");
    }
    
    public void mouseExited(MouseEvent EventoQueLlega)
    {
        System.out.println("'Blur' de raton");
    }
}




public class Ejer2Eventos {


    public static void main(String[] args) {
    
        Frame MiFrame = new Frame("Prueba eventos de raton");
        Panel MiPanel = new Panel();
        Button Hola = new Button("Saludo");
        Button Adios = new Button("Despedida");
        MiPanel.add(Hola); MiPanel.add(Adios);
        MiFrame.add(MiPanel);
        MiFrame.setSize(200,100);
        MiFrame.show();
        
        InterrupcionDeRaton1 i1 = new InterrupcionDeRaton1();
        
        Hola.addMouseListener (new InterrupcionDeRaton1());
        Adios.addMouseListener(i1);

    }
}
