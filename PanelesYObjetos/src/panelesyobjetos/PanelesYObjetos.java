
package panelesyobjetos;

import java.awt.Frame;
import java.awt.Button;
import java.awt.Panel;

public class PanelesYObjetos 
{

    public static void main(String[] args) 
    {
        //BOTONES 1
        /*Frame MiMarco = new Frame();
        Panel MiPanel = new Panel();
        Button BotonArea = new Button("Calcular área");
        Button BotonPerimetro = new Button("Calcular perímetro");
        
        MiMarco.add(MiPanel);
        MiPanel.add(BotonArea);
        MiPanel.add(BotonPerimetro);
        MiMarco.setSize(400,200);
        MiMarco.setTitle("Ventana con botones");
        MiMarco.setVisible(true);*/
        
        //BOTONES 2/
        
        Frame MiMarco = new Frame();
        
        Panel PanelPrincipal = new Panel();
        Panel PanelIzq = new Panel();
        Panel PanelDcha = new Panel();
        
        Button BotonCorrer = new Button("Correr");
        Button BotonSaltar = new Button("Saltar");
        Button BotonDescansar = new Button("Descansar");
        
        
        MiMarco.add(PanelPrincipal);
        
        PanelPrincipal.add(PanelIzq);
        PanelPrincipal.add(PanelDcha);
        
        PanelIzq.add(BotonCorrer);
        PanelIzq.add(BotonSaltar);
        
        PanelDcha.add(BotonDescansar);
        
        MiMarco.setSize(400,200);
        MiMarco.setTitle("Ventana con paneles");
        MiMarco.setVisible(true);

    }
}
