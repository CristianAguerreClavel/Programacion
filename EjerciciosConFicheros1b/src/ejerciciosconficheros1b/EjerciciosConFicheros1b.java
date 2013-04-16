package ejerciciosconficheros1b;

import java.io.*;
import java.util.*;

public class EjerciciosConFicheros1b {

    public static ArrayList leerYGuardarArchivo(String fichero) throws IOException
    {
        ArrayList ar1 = new ArrayList();
        boolean fin=false;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        
        try
        {
            Object aux = ois.readObject();//Le asigno un primer objeto a la variable aux
            
            while ( aux != null && ! fin)//Mientras la variable aux no este vacia ejecuta Y FIN SEA FALSE
            {
                ar1.add(aux);
                aux = ois.readObject();
            }
            ois.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.print("Error al leer");
        }
        
        catch (EOFException e)//ESTA EXCEPTION SE AÑADE PORQUE SINO SALE UNA EXCEPCION PORQUE LLEGA AL FINAL DEL ARCHIVO
        {
            fin = true;
        }
        return ar1;
    }
    
    
    public static void main(String[] args) {
        
        ArrayList array1 = new ArrayList();
        
        try
        {
        array1 = leerYGuardarArchivo("/home/mati/Ficheros para java/Ejercicio 1/alumnos.txt");
        }
        catch(IOException e)
        {
            System.out.print("Error al intentar abrir el fichero");
        }
        
        Iterator it = array1.iterator();
        while(it.hasNext())
            System.out.print(it.next());
        
        
    }
}
