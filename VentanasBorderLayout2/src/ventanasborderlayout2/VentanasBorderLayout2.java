
package ventanasborderlayout2;

import java.awt.*;

public class VentanasBorderLayout2 
{

    public static void main(String[] args) 
    {
        Frame MiMarco = new Frame();
        
        Panel PanelMenuNorte = new Panel();
        Panel PanelGeneral = new Panel();
       
        BorderLayout PuntosCardinales = new BorderLayout();
        
        FlowLayout OpcionesMenu = new FlowLayout();
        
        //ESTOS BOTONES ESTARAN DENTRO DEL FlowLayout
        Button BotonOpcion1 = new Button("Opción 1");
        Button BotonOpcion2 = new Button("Opción 2");
        Button BotonOpcion3 = new Button("Opción 3");
        //ESTOS BOTONES ESTARAN DENTRO DEL BorderLayout
        Button BotonSur = new Button("Sur");
        Button BotonEste = new Button("Este");
        Button BotonOeste = new Button("Oeste");
        Button BotonCentro = new Button("Centro");
        
        PanelGeneral.setLayout(PuntosCardinales);
        PanelMenuNorte.setLayout(OpcionesMenu);
        
        MiMarco.add(PanelGeneral);
        PanelGeneral.add(PanelMenuNorte, BorderLayout.NORTH);
        PanelMenuNorte.add(BotonOpcion1);
        PanelMenuNorte.add(BotonOpcion2);
        PanelMenuNorte.add(BotonOpcion3);
        PanelGeneral.add(BotonSur,BorderLayout.SOUTH);
        PanelGeneral.add(BotonEste,BorderLayout.EAST);
        PanelGeneral.add(BotonOeste, BorderLayout.WEST);
        PanelGeneral.add(BotonCentro, BorderLayout.CENTER);

        MiMarco.setSize(400,150);
        MiMarco.setTitle("Ventana con BorderLayout");
        MiMarco.setVisible(true);
    }
}
