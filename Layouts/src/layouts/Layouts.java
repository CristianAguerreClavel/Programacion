package layouts;

import java.awt.Frame;
import java.awt.Button;
import java.awt.Panel;
import java.awt.FlowLayout;

public class Layouts {


    public static void main(String[] args) 
    {
        Frame MiMarco = new Frame();
        Panel MiPanel = new Panel();
        FlowLayout PosicionamientoSecuencial = new FlowLayout();
        //FlowLayout PosicionamientoSecuencial = new FlowLayout(FlowLayout.LEFT); DE ESTA FORMA PODRIA ALINEARSE IZQ, DER, CENT, CON LEFT RIGHT CENTER
        Button BotonA = new Button("Primer botón");
        Button BotonB = new Button("Segundo botón");
        Button BotonC = new Button("Tercer botón");
        Button BotonD = new Button("Cuarto botón");

        MiPanel.setLayout(PosicionamientoSecuencial);
        MiMarco.add(MiPanel);
        MiPanel.add(BotonA);
        MiPanel.add(BotonB);
        MiPanel.add(BotonC);
        MiPanel.add(BotonD);
        MiMarco.setSize(300,100);
        MiMarco.setTitle("Ventana con flow layout");
        MiMarco.setVisible(true);

    }
}
