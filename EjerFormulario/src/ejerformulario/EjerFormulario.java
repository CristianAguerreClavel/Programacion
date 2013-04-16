package ejerformulario;

import java.awt.*;


public class EjerFormulario 
{
     private static Frame MiMarco = new Frame();
        private static Panel Formulario = new Panel(new BorderLayout());
        private static Panel PanelDatosPersonales =new Panel(new GridLayout(3,1));
        private static Panel PanelEstadoCivil = new Panel(new GridLayout(5,1));
        private static Panel PanelProvincia = new Panel();

    private static void PreparaDatosPersonales()
    {
        Panel PanelNombre = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel PanelApellidos = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel PanelDireccion = new Panel(new FlowLayout(FlowLayout.LEFT));
        
        TextField CampoNombre = new TextField(12);
        TextField CampoApellidos = new TextField(50);
        TextField CampoDireccion = new TextField(12);
        Label EtiquetaNombre = new Label("Nombre",Label.LEFT);
        Label EtiquetaApellidos = new Label("Apellidos",Label.LEFT);
        Label EtiquetaDireccion = new Label("Direccion",Label.LEFT);

        PanelDatosPersonales.add(PanelNombre);
        PanelDatosPersonales.add(PanelApellidos);
        PanelDatosPersonales.add(PanelDireccion);
        PanelNombre.add(EtiquetaNombre);
        PanelNombre.add(CampoNombre);
        PanelApellidos.add(EtiquetaApellidos);
        PanelApellidos.add(CampoApellidos);
        PanelDireccion.add(EtiquetaDireccion);
        PanelDireccion.add(CampoDireccion);
    }
    
    
    private static void PreparaEstadoCivil() 
    {
        CheckboxGroup EstadoCivil = new CheckboxGroup();
        Checkbox Soltero = new Checkbox("Soltero",false,EstadoCivil);
        Checkbox Casado = new Checkbox("Casado",false,EstadoCivil);
        Checkbox Separado = new Checkbox("Separado",false,EstadoCivil);
        Checkbox Divorciado = new Checkbox("Divorciado",false,EstadoCivil);
        Checkbox Otros = new Checkbox("Otros",false,EstadoCivil);
        
        PanelEstadoCivil.add(Soltero);
        PanelEstadoCivil.add(Casado);
        PanelEstadoCivil.add(Separado);
        PanelEstadoCivil.add(Divorciado);
        PanelEstadoCivil.add(Otros);
    }
    
    private static void PreparaProvincia() 
    {
        Choice Ciudades = new Choice();
        Ciudades.add("Alicante");
        Ciudades.add("Avila");
        Ciudades.add("Granada");
        Ciudades.add("Madrid");
        Ciudades.add("Segovia");
        Ciudades.add("Sevilla");
        Ciudades.add("Toledo");
        PanelProvincia.add(Ciudades);
    }

    
    public static void main(String[] args) 
    {
       PreparaDatosPersonales();
        PreparaEstadoCivil();
        PreparaProvincia();
        PanelDatosPersonales.setBackground(Color.orange);
        PanelEstadoCivil.setBackground(Color.yellow);
        PanelProvincia.setBackground(Color.green);
        Formulario.add(PanelDatosPersonales,
        BorderLayout.NORTH);
        Formulario.add(PanelEstadoCivil,BorderLayout.WEST);
        Formulario.add(PanelProvincia,BorderLayout.EAST);
        Formulario.add(new
        Button("Enviar"),BorderLayout.SOUTH);
        MiMarco.add(Formulario);
        MiMarco.setSize(600,250);
        MiMarco.setTitle("Formulario");
        MiMarco.setVisible(true);

    }
    
}
