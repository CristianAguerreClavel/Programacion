package ejerciciosconficheros1;

import java.io.*;
import java.util.*;

class Alumno implements Serializable
{
    String nombre;
    int carnet;
    //String apellido;
    int nota1,nota2,nota3;
    
    public Alumno(int carnet, String nombre,int a, int b,int c)
    {
        this.carnet=carnet;
        this.nombre=nombre;
        nota1=a;
        nota2=b;
        nota3=c;
    }
    
    public String toString ()
    {
        String texto=("Nombre: "+nombre+" Carnet: "+carnet+" Notas: "+nota1+" "+nota2+" "+nota3);
        return texto;
    }
}



public class EjerciciosConFicheros1{
    
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

    
    //METODO PARA ESCRIBIR OBJETOS
    public static void escribirObjeto(String fichero, ArrayList<Alumno> array1  ) throws IOException
    {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
      
      for (Object a: array1)
      {
          oos.writeObject(a);
      }
      
      
      oos.close();
    }
    
    //METODO PARA LEER OBJETOS
    public static void leerObjeto(String fichero) throws IOException
    {
        boolean fin=false;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        
        try
        {
            Object aux = ois.readObject();//Le asigno un primer objeto a la variable aux
            
            while ( aux != null && ! fin)//Mientras la variable aux no este vacia ejecuta Y FIN SEA FALSE
            {
                if (aux instanceof Alumno)
                
                    System.out.println(aux);  // Se escribe en pantalla el objeto
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
    }
    
    
    
   /* 
    //MAIN PARA LA CREACION DEL FICHERO QUE CONTENDRA LOS ALUMNOS
    public static void main(String[] args) 
    {
        Alumno alum1 = new Alumno(1,"Cristian",9,10,5);
        Alumno alum2 = new Alumno(2,"Nerea",1,2,3);
        Alumno alum3 = new Alumno(3,"Jorge",4,5,6);
        
        ArrayList<Alumno> array1 = new ArrayList<Alumno>();
        array1.add(alum1);
        array1.add(alum2);
        array1.add(alum3);
        
        try
        {
        escribirObjeto("/home/mati/Ficheros para java/Ejercicio 1/alumnos.txt",array1);
        }
        catch (IOException e)
        {
            System.out.println("Error al intentar abrir el archivo para escribir");
        }
        
        try
        {
        leerObjeto("/home/mati/Ficheros para java/Ejercicio 1/alumnos.txt");
        }
        catch (IOException e)
        {
            System.out.print("Error al intentar abrir el archivo para leer");
        }
    }*/
    
    
    //MAIN PARA LA PARTE B DEL EJERCICIO
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
            System.out.println(it.next());
    }
}
