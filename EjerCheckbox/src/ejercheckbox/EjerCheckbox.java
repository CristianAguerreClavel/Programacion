
package ejercheckbox;

import java.awt.*;

public class EjerCheckbox {


    public static void main(String[] args) 
    {
        Frame MiMarco = new Frame();
        Panel Sencillo = new Panel(new GridLayout(6,1));

        Checkbox AireAcondicionado = new Checkbox("Aire acondicionado",true);
        Checkbox FarosXenon = new Checkbox("Faros de xenon",false);
        Checkbox PinturaMetalizada = new Checkbox("Pintura metalizada",true);
        Checkbox LlantasAleacion = new Checkbox("Llantas de aleación",false);
        Checkbox TapiceriaCuero = new Checkbox("Tapicería de cuero",false);
        Checkbox FarosAntiniebla = new Checkbox("Faros antiniebla",false);

        Sencillo.add(AireAcondicionado);
        Sencillo.add(FarosXenon);
        Sencillo.add(PinturaMetalizada);
        Sencillo.add(LlantasAleacion);
        Sencillo.add(TapiceriaCuero);
        Sencillo.add(FarosAntiniebla);

        MiMarco.add(Sencillo);
        MiMarco.setSize(200,200);
        MiMarco.setTitle("Ventana con cajas de verificación");
        MiMarco.setVisible(true);

    
    }
}
