package ejer1eventos;

import java.awt.Button;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;


/**
 *
 * @author mati
 */


class EsquemaRaton implements MouseListener 
{
        public void mouseClicked(MouseEvent EventoQueLlega)
        {
        // aqui se implementa la accion deseada
        }

        public void mousePressed(MouseEvent EventoQueLlega)
        {

        }

        public void mouseReleased(MouseEvent EventoQueLlega)
        {

        }

        public void mouseEntered(MouseEvent EventoQueLlega){
        EventoQueLlega.getComponent().setBackground(Color.red);
        }

        public void mouseExited(MouseEvent EventoQueLlega){
        EventoQueLlega.getComponent().
        setBackground(Color.gray);
        }
}






public class Ejer1Eventos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Frame MiFrame = new Frame("Esquema de eventos");
        Panel MiPanel = new Panel();

        Button Hola = new Button("Saludo");
        Button Adios = new Button("Despedida");
        MiPanel.add(Hola); MiPanel.add(Adios);
        MiFrame.add(MiPanel);
        MiFrame.setSize(200,100);
        MiFrame.show();

        Hola.addMouseListener (new EsquemaRaton());
        Adios.addMouseListener(new EsquemaRaton());

    }
}
