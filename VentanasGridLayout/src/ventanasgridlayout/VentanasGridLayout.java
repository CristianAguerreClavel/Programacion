package ventanasgridlayout;

import java.awt.*;
public class VentanasGridLayout 
{


    public static void main(String[] args) 
    {
        Frame MiMarco = new Frame();
        Panel MiPanel = new Panel();
        GridLayout Matriz = new GridLayout(2,3);
        
        Button[] Botones = new Button[6];
        for (int i=0;i<6;i++)
            Botones[i] = new Button("Botón "+i);
        
        MiPanel.setLayout(Matriz);
        for (int i=0;i<6;i++)
            MiPanel.add(Botones[i]);

        MiMarco.add(MiPanel);
        MiMarco.setSize(300,100);
        MiMarco.setTitle("Ventana con GridLayout");
        MiMarco.setVisible(true);

    }
}
