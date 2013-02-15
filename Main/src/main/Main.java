package main;

import java.util.LinkedList;

abstract class Colecciones520 {
    private LinkedList<Object> lista;
    
    public Colecciones520()
    {
        lista = new LinkedList<Object>();
    }
    
    public abstract void añadir(Object o);
    
    public Object extraer()
    {
        return lista.removeFirst();
    }
    
    public boolean estaVacia()
    {
        return lista.isEmpty();
    }
    
    public Object primero()
    {
        return lista.toString();
    }
    
    protected LinkedList<Object> getLista()
    {
        return lista;
    }
    
}


class Pila extends Colecciones520
{
    public Pila()
    {
        
    }
    
    public void añadir(Object o)
    {
        getLista().addFirst(o);
    }
}

class Cola extends Colecciones520
{
    public Cola()
    {
        
    }
    
    public void añadir(Object o)
    {
        getLista().addLast(o);
    }
}


public class Main
{
    public static void rellenar(Colecciones520 c)
    {
        for ( int i = 1; i<=10; i ++)
            c.añadir(i);
    }
    
    public static void imprimirYVaciar(Colecciones520 c)
    {
        while(!c.estaVacia())
        {
            System.out.println(c.extraer());
        }
    }
    
    public static void main(String[] args)
    {
        Pila p = new Pila();
        rellenar(p);
        System.out.println("Datos de la pila");
        imprimirYVaciar(p);
        
        Cola c = new Cola();
        rellenar(c);
        System.out.println("Datos de la cola");
        imprimirYVaciar(c);
        
        p.añadir("Primero");
        p.añadir(new Boolean(true));
        p.añadir(7.5);
        p.añadir(c);
        
        System.out.println("Datos de la pila con objetos de distinto tipo");
        imprimirYVaciar(p);
    }
}