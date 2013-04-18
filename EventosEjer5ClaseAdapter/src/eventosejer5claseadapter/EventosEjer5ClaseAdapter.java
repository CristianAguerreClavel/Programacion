package eventosejer5claseadapter;

import java.awt.event.*;
import java.awt.*;


class InterrupcionDeRaton4 extends MouseAdapter
{
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



public class EventosEjer5ClaseAdapter {

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
        
        InterrupcionDeRaton4 i1 = new InterrupcionDeRaton4();
        
        Hola.addMouseListener (new InterrupcionDeRaton4());
        Adios.addMouseListener(i1);
    }
}
