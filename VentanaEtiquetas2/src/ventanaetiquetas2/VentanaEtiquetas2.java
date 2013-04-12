package ventanaetiquetas2;
import java.awt.*;

public class VentanaEtiquetas2 
{

    public static void main(String[] args) 
    {
        Frame MiMarco = new Frame();
        Panel Tabla = new Panel(new GridLayout(11,11));
        Label[] CabeceraFila = new Label[11];
        Label[] CabeceraColumna = new Label[11];

        
        Tabla.add(new Label(""));
        for (int i=1;i<=10;i++) 
        {
            CabeceraFila[i] = new Label(""+i);
            CabeceraFila[i].setBackground(Color.red);
            Tabla.add(CabeceraFila[i]);
        }
        
        for (int i=1;i<=10;i++) {
            CabeceraColumna[i] = new Label(""+i);
            CabeceraColumna[i].setBackground(Color.red);
            Tabla.add(CabeceraColumna[i]);
            for (int j=1;j<=10;j++)
                Tabla.add(new Label(""+i*j));

        }
        
        MiMarco.add(Tabla);
        MiMarco.setSize(400,400);
        MiMarco.setTitle("Tabla de multiplicar");
        MiMarco.setVisible(true);

    }
}
