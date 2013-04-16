
package borderlayout;

import java.awt.Frame;
import java.awt.Button;
import java.awt.Panel;
import java.awt.BorderLayout;

public class BorderLayout 
{

    public static void main(String[] args) 
    {
        Frame MiMarco = new Frame();
        Panel MiPanel = new Panel();
        BorderLayout PuntosCardinales = new BorderLayout();
        Button BotonNorte = new Button("Norte");
        Button BotonSur = new Button("Sur");
        Button BotonEste = new Button("Este");
        Button BotonOeste = new Button("Oeste");
        Button BotonCentro = new Button("Centro");
        MiPanel.setLayout(PuntosCardinales);

        MiMarco.add(MiPanel);
        MiPanel.add(BotonNorte,
        MiPanel.add(BotonSur,
        MiPanel.add(BotonEste,
        MiPanel.add(BotonOeste,
        MiPanel.add(BotonCentro,
        © JESÚS BOBADILLA SANCHO (JBOBI@EUI.UPM.ES)
        BorderLayout.NORTH);
        BorderLayout.SOUTH);
        BorderLayout.EAST);
        BorderLayout.WEST);
        BorderLayout.CENTER);
        MiMarco.setSize(300,100);
        MiMarco.setTitle("Ventana con BorderLayout");
        MiMarco.setVisible(true);

    
    }
}
