package colecciones.pkg636;
import java.util.*;


public class Colecciones636 {
    
    LinkedList<String> linkList;
    
    public Colecciones636()
    {
        linkList = new LinkedList<String>();
    }
    
    public void apilarPalabras(String palabra)
    {
        linkList.add(palabra);
    }
    
    public String obtenerPalabraCima()
    {
        return(linkList.getLast());
    }
    
    public String desApilarPalabra()
    {
        return linkList.removeLast();
    }
    
    public boolean pilaPalabrasVacia()
    {
        return linkList.isEmpty();
    }
    
    public static void main(String[] args) {
        
        String palabra = "Hola";
        String palabra2 = "Adios";
        String palabra3 = "Cristian";
        
        Colecciones636 Lista1 = new Colecciones636();
        
        Lista1.apilarPalabras(palabra);
        Lista1.apilarPalabras(palabra2);
        Lista1.apilarPalabras(palabra3);
        
        while (!Lista1.pilaPalabrasVacia())//(Lista1.pilaPalabrasVacia() == false)
        {
        System.out.println("Palabra : "+Lista1.desApilarPalabra());
        }
    }
}
