package ejerlistas;

import java.awt.*;
import java.awt.event.*;

public class EjerListas {

    
    public static void main(String[] args) 
    {
        /* Lista normal
        Frame MiMarco = new Frame();
        Panel MiPanel = new Panel();
        List Islas = new List(5,false);

        Islas.add("Tenerife");
        Islas.add("Lanzarote");
        Islas.add("Gran Canaria");
        Islas.add("Hierro");
        Islas.add("La Gomera");
        Islas.add("Fuerteventura");
        Islas.add("La Palma");

        MiPanel.add(Islas);
        MiMarco.add(MiPanel);
        MiMarco.setSize(200,200);
        MiMarco.setTitle("Ventana con lista");
        MiMarco.setVisible(true);
        */
        
        /*Lista desplegable*/
        
        Frame MiMarco = new Frame();
        Panel MiPanel = new Panel();
        Choice Ciudades = new Choice();

        Ciudades.add("Alicante");
        Ciudades.add("Avila");
        Ciudades.add("Granada");
        Ciudades.add("Segovia");
        Ciudades.add("Sevilla");
        Ciudades.add("Toledo");

        MiPanel.add(Ciudades);
        MiMarco.add(MiPanel);
        MiMarco.setSize(200,200);
        MiMarco.setTitle("Ventana con lista desplegable");
        MiMarco.setVisible(true);

    }
}
