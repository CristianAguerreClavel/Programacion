//Ejercicio interfaces pagina 284,8.1, 8.2, 8.3, 8.4
package interfacespropias;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.ArrayList;

interface ColeccionSimple
{
    boolean estaVacio();
    Object extraer();
    Object primero();
    boolean añadir(Object o);
}

//en fin

class PilaArray implements ColeccionSimple
{
    private Object[] Array;
    int contador = 0;
    
    public PilaArray (int tamaño)
    {
        Array = new Object[tamaño];
    }
    
    
    public boolean estaVacio()
    {
        boolean vacio = true;
        
        if (contador == 0)
            vacio = true;
        else
            vacio = false;
        return vacio;
    }

    
    public Object extraer() 
    {
        if (estaVacio())
        {
            throw new NoSuchElementException();
        }
        else
        {
            return Array[--contador];
        }
    }

    
    public Object primero() {
        if (estaVacio())
        {
            throw new NoSuchElementException();
        }
        else
        {
            return Array[contador -1];
        }
    }

    
    public boolean añadir(Object ob) 
    {
        if (contador == Array.length)
        {
                return false;
        }
        else
        {
                Array[contador]= ob;
                contador ++;
                return true;
        }
    }
    
    public String toString()
    {
        String s = "[";
        
        for(int i = contador-1;i>=0;i--)
        {
            s+=Array[i].toString()+",";
        }
        if(!estaVacio())
            return s.substring(0, s.length()-1)+"]";
        else
            return s+"]";
        
    }
    
}


class PruebaColeccionSimple
{
    public static void rellenar(ColeccionSimple a)
    {
        for (int i = 0; i <10;i++)
        {
            a.añadir(i);
        }
    }
    
    
    public static void ImprimirYVaciar(ColeccionSimple a)
    {
        if (a.estaVacio())
        {
            System.out.println("Esta vacio");
        }
        else
        {
            while(!a.estaVacio())
            {
                a.extraer();
            }
        }
    
    }
    
}  


class Cola implements ColeccionSimple
{
    private LinkedList<Object> lista;
    
    public Cola()
    {
        lista = new LinkedList<Object>();
    }
    
    @Override
    public boolean estaVacio() {
        return lista.isEmpty();
    }

    @Override
    public Object extraer() {
        return lista.removeFirst();
    }

    @Override
    public Object primero() {
        return lista.getFirst();
    }

    @Override
    public boolean añadir(Object o) {
        lista.addLast(o);
        return true;
    }
    
    public String toString()
    {
        return lista.toString();
    }
        
}


class PilaArrayList extends ArrayList<Object> implements ColeccionSimple
{

    public PilaArrayList()
    {
                
    }
    
    @Override
    public boolean estaVacio() {
        return isEmpty();
    }

    @Override
    public Object extraer() {
        return remove(0);
    }

    @Override
    public Object primero() {
        return get(0);
    }

    @Override
    public boolean añadir(Object o) {
        add(0,o);
        return true;
    }
    
}

public class InterfacesPropias 
{
    public static void main(String[] args) 
    {
        PilaArray pila = new PilaArray(20);
        PruebaColeccionSimple.rellenar(pila);
        System.out.println("La pila: "+pila);
        PruebaColeccionSimple.ImprimirYVaciar(pila);
        System.out.println("La pila: "+pila);
        
        System.out.println("Pila Array");
        System.out.println("---------------------------------------------------");
        PilaArrayList pilaArray = new PilaArrayList();
        PruebaColeccionSimple.rellenar(pilaArray);
        System.out.println("Pila Array"+pilaArray);
        System.out.println(pilaArray.primero());
        
        System.out.println("Cola");
        System.out.println("---------------------------------------------------");
        Cola cola = new Cola();
        PruebaColeccionSimple.rellenar(cola);
        System.out.println("La cola: "+ cola);
        PruebaColeccionSimple.ImprimirYVaciar(cola);
        System.out.println(cola);
        
    }
}
