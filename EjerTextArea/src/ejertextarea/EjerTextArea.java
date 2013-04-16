
package ejertextarea;

import java.awt.*;

public class EjerTextArea {

    public static void main(String[] args) 
    {
        int FILAS = 3;
        int COLUMNAS = 20 ;

        Frame MiMarco = new Frame();
        Panel MiPanel = new Panel();
        TextArea Comentarios = new TextArea("La tarta",FILAS,COLUMNAS,TextArea.SCROLLBARS_VERTICAL_ONLY);

        Comentarios.append(" de chocolate estaba buena");
        Comentarios.insert(" muy", 28);
        MiPanel.add(Comentarios);
        MiMarco.add(MiPanel);
        MiMarco.setSize(200,100);
        MiMarco.setTitle("Ventana con área de texto");
        MiMarco.setVisible(true);

    }
}