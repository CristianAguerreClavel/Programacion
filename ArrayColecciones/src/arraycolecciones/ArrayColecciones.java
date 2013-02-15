package arraycolecciones;

import java.util.*;

class Producto
{
    Producto(String s, int i)
    {
        nombre = s;
        cantidad = i;
    }
        String nombre;
        int cantidad;
}

public class ArrayColecciones
{
    public static void main(String args[])
    {
    // Definir 5 instancias de la Clase Producto
    Producto m = new Producto("Pan", 6);
    Producto n = new Producto("Leche", 2);
    Producto o = new Producto("Manzanas", 5);
    Producto p = new Producto("Brocoli", 2);
    Producto q = new Producto("Carne", 2);
   
    // Defino un ArrayList
    ArrayList mandado = new ArrayList();
    
    // Colocar Instancias de Producto en ArrayList
    mandado.add(m);
    mandado.add(n);
    mandado.add(o);
    mandado.add(p);
    // Indica el indice de inserción
    mandado.add(1, q);
    mandado.add(q);
    
    // Imprimir contenido de ArrayLists
    System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
    
    // Definir Iterator para extraer/imprimir valores
    for( Iterator it = mandado.iterator(); it.hasNext(); )
    {
        Producto x = (Producto)it.next();
        System.out.println(x.nombre + " : " + x.cantidad);
    }
    
    // Eliminar elemento de ArrayList
    mandado.remove(2);
    System.out.println(" - Lista de mandado con " + mandado.size() + " elementos");
    
    // Definir Iterator para extraer/imprimir valores
    for( Iterator it2 = mandado.iterator(); it2.hasNext();)
    {
        Producto x = (Producto)it2.next();
        System.out.println(x.nombre + " : " + x.cantidad);
    }
    
    // Eliminar todos los valores del ArrayList
    mandado.clear();
    System.out.println(" - Lista de mandado final con " + mandado.size() + " elementos");
    }
}
