package campodetexto;

import java.awt.*;

public class CampoDeTexto 

{
    public static void main(String[] args) 
    {
        /*EJERCICIO 1
        Frame MiMarco = new Frame();
        Panel EntradaDeDatos = new Panel(new FlowLayout());
        TextField Nombre = new TextField(15);
        TextField Apellidos = new TextField(60);
        TextField Nacionalidad = new TextField("Española",15);

        EntradaDeDatos.add(Nombre);
        EntradaDeDatos.add(Apellidos);
        EntradaDeDatos.add(Nacionalidad);
        
        MiMarco.add(EntradaDeDatos);
        MiMarco.setSize(500,130);
        MiMarco.setTitle("Ventana con campos de texto");
        MiMarco.setVisible(true);*/
        
        /*EJERCICIO 2 ETIQUETAS CAMPOS DE TEXTO CON ALINEACION
        Frame MiMarco = new Frame();
        Panel EntradaDeDatos = new Panel(new GridLayout(3,1));
        Panel PanelNombre = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel PanelApellidos = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel PanelNacionalidad = new Panel(new FlowLayout(FlowLayout.LEFT));
        TextField CampoNombre = new TextField(12);
        TextField CampoApellidos = new TextField(50);
        TextField CampoNacionalidad = new TextField("Española",12);
        
        Label EtiquetaNombre = new Label("Nombre",Label.LEFT);
        Label EtiquetaApellidos = new Label("Apellidos",Label.LEFT);
        Label EtiquetaNacionalidad = new Label("Nacionalidad",Label.LEFT);

        EntradaDeDatos.add(PanelNombre);
        EntradaDeDatos.add(PanelApellidos);
        EntradaDeDatos.add(PanelNacionalidad);
        PanelNombre.add(EtiquetaNombre);
        PanelNombre.add(CampoNombre);
        PanelApellidos.add(EtiquetaApellidos);
        PanelApellidos.add(CampoApellidos);
        PanelNacionalidad.add(EtiquetaNacionalidad);
        PanelNacionalidad.add(CampoNacionalidad);

        MiMarco.add(EntradaDeDatos);
        MiMarco.setSize(500,130);
        MiMarco.setTitle("Ventana con campos de texto y etiquetas");
        MiMarco.setVisible(true);*/
        
    }
}
