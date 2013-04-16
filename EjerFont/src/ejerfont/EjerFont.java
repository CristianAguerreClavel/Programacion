
package ejerfont;

import java.awt.*;

public class EjerFont {

    public static void main(String[] args) {
        Frame MiMarco = new Frame();
        Font UnaFuente = new Font("SansSerif",Font.BOLD,20);
        Font OtraFuente = new Font("Serif",Font.ITALIC,40);

        Panel Sencillo = new Panel();
        Label HolaAmigo1 = new Label("Hola amigo");
        Label HolaAmigo2 = new Label("Hola amigo");

        HolaAmigo1.setFont(UnaFuente);

        HolaAmigo1.setForeground(Color.red);

        HolaAmigo2.setFont(OtraFuente);
        HolaAmigo2.setForeground(Color.orange);

        Sencillo.add(HolaAmigo1);
        Sencillo.add(HolaAmigo2);

        MiMarco.add(Sencillo);
        MiMarco.setSize(500,130);
        MiMarco.setTitle("Ventana con etiquetas y fuentes");
        MiMarco.setVisible(true);

    }
}
