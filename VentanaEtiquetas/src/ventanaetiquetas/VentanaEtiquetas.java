package ventanaetiquetas;

import java.awt.*;

public class VentanaEtiquetas 
{

    public static void main(String[] args) 
    {
        Frame MiMarco = new Frame();
        Panel PanelGeneral = new Panel(new GridLayout(1,2));
        Panel PanelIzquierdo = new Panel(new GridLayout(3,1));
        Panel PanelDerecho = new Panel(new FlowLayout());

        PanelGeneral.add(PanelIzquierdo);   
        PanelGeneral.add(PanelDerecho);
        PanelIzquierdo.add(new Label("Ford",Label.CENTER));
        PanelIzquierdo.add(new Label("Opel",Label.CENTER));
        PanelIzquierdo.add(new Label("Audi",Label.CENTER));
        PanelDerecho.add(new Label("Coupe"));
        PanelDerecho.add(new Label("Cabrio"));

        MiMarco.add(PanelGeneral);
        MiMarco.setSize(250,100);
        MiMarco.setTitle("Ventana con etiqueta");
        MiMarco.setVisible(true);


    }
}
