
package ventanarborderlayout;

import java.awt.Frame;
import java.awt.Button;
import java.awt.Panel;
import java.awt.BorderLayout;

public class VentanarBorderLayout 
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
        MiPanel.add(BotonNorte,BorderLayout.NORTH);
        MiPanel.add(BotonSur,BorderLayout.SOUTH);
        MiPanel.add(BotonEste,BorderLayout.EAST);
        MiPanel.add(BotonOeste,BorderLayout.WEST);
        MiPanel.add(BotonCentro,BorderLayout.CENTER);
        
        MiMarco.setSize(300,100);
        MiMarco.setTitle("Ventana con BorderLayout");
        MiMarco.setVisible(true);

    }
}
