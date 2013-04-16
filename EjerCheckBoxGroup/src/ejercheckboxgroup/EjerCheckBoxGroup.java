package ejercheckboxgroup;

import java.awt.*;

public class EjerCheckBoxGroup {

    private static void EstableceVisualizacion(Checkbox Elemento, Color ColorSeleccionado,Font FuenteSeleccionada)
    {
        Elemento.setFont(FuenteSeleccionada);
        Elemento.setForeground(ColorSeleccionado);
    }

        
    public static void main(String[] args) 
    {
        /*EJEMPLO BASICO DE CHECKBOXGROUP
        Frame MiMarco = new Frame();
        Panel Sencillo = new Panel(new GridLayout(6,1));
        CheckboxGroup Colores = new CheckboxGroup();

        Sencillo.add(new Checkbox("Rojo",false,Colores));
        Sencillo.add(new Checkbox("Azul",false,Colores));
        Sencillo.add(new Checkbox("Verde",false,Colores));
        Sencillo.add(new Checkbox("Amarillo",false,Colores));
        Sencillo.add(new Checkbox("Negro",false,Colores));
        Sencillo.add(new Checkbox("Gris",false,Colores));

        MiMarco.add(Sencillo);
        MiMarco.setSize(200,200);
        MiMarco.setTitle("Ventana con botones de radio");

        MiMarco.setVisible(true);*/
        
        /*Ejercicio combinando estilos y checkboxgroup*/
        Frame MiMarco = new Frame();
        Panel Sencillo = new Panel(new GridLayout(6,1));
        CheckboxGroup Colores = new CheckboxGroup();

        Checkbox Rojo = new Checkbox("Rojo",false,Colores);
        Checkbox Azul = new Checkbox("Azul",false,Colores);
        Checkbox Verde = new Checkbox("Verde",false,Colores);
        Checkbox Amarillo = new Checkbox("Amarillo",false,Colores);
        Checkbox Negro = new Checkbox("Negro",false,Colores);
        Checkbox Gris = new Checkbox("Gris",false,Colores);
        Font MiFuente = new Font("SansSerif",Font.PLAIN,25);
        
        EstableceVisualizacion(Rojo,Color.red,MiFuente);
        EstableceVisualizacion(Azul,Color.blue,MiFuente);
        EstableceVisualizacion(Verde,Color.green,MiFuente);
        EstableceVisualizacion(Amarillo,Color.yellow,MiFuente);
        EstableceVisualizacion(Negro,Color.black,MiFuente);
        EstableceVisualizacion(Gris,Color.gray,MiFuente);

        Sencillo.add(Rojo);
        Sencillo.add(Azul);
        Sencillo.add(Verde);
        Sencillo.add(Amarillo);
        Sencillo.add(Negro);
        Sencillo.add(Gris);
        MiMarco.add(Sencillo);
        MiMarco.setSize(200,200);
        MiMarco.setTitle("Ventana con botones de radio");
        MiMarco.setVisible(true);



    }
}
