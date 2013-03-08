package practicaficheros1;

import java.io.*;
import java.util.*;


class Alumno implements Serializable
{
    int numeroMatricula;
    int codigoPostal;
    int telefono;
    String nombre;
    String apellidos;
    String direccion;
    String localidad;
    String provincia;
    
    public Alumno(int matricula, String nom, String ape)
    {
        numeroMatricula = matricula;
        nombre = nom;
        apellidos = ape;
    }
    
    
    
    public String toString ()
    {
        String texto=("Matricula: "+numeroMatricula+" Nombre: "+nombre);
        return texto;
    }
    
}




public class PracticaFicheros1 
{

    public static void escribirAlumnos(String fichero, ArrayList<Alumno> alum) throws IOException 
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        
        for (Alumno a : alum)
        {
            oos.writeObject(a);
        }
        oos.close();
    }
    
    public static ArrayList cargarDatosEnArrayList(String fichero)throws IOException
    {
        boolean fin = false;
        ArrayList array1 = new ArrayList();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        
        try
        {
           Object a = ois.readObject();
           while (a != null && ! fin)
           {
               array1.add(a);
               a = ois.readObject();
           }
           ois.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error de tipo classnotfound");
        }
        catch (EOFException e)//ESTA EXCEPTION SE AÑADE PORQUE SINO SALE UNA EXCEPCION PORQUE LLEGA AL FINAL DEL ARCHIVO
        {
            fin = true;
        }
        return array1;
    }
    
    public static void matricularAlumnoNuevo(ArrayList arrayL)
    {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduzca un numero de matricula:");
        int matricula = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduzca un nombre:");
        String nombre = tec.nextLine();
        System.out.println("Introduza el primer apellido:");
        String apellido = tec.nextLine();
        
        Alumno alum = new Alumno(matricula,nombre,apellido);
        arrayL.add(alum);
    }
    
    public static Alumno buscarAlumnoPorMatricula(ArrayList arrayL, int num) 
    {
        Alumno alum = null;
        //Object aux = null;
        Iterator it = arrayL.iterator();
        while(it.hasNext())
        {
            alum =(Alumno) it.next();
            if (alum.numeroMatricula==num)
                return alum;
        }     
        return alum;
    }
    
    public static Alumno buscarAlumnoPorNombre(ArrayList arrayL, String nombre) 
    {
        boolean encontrado = false;
        Alumno alum = null;
        //Object aux = null;
        Iterator it = arrayL.iterator();//Declaro iterator (es como scanner)
        while(it.hasNext() && ! encontrado)
        {
            alum =(Alumno)it.next();
            if (nombre.equalsIgnoreCase(alum.nombre))
            {
                encontrado = true;
                return alum;
            }    
        } 
        return alum;
    }
    
    public static void modificarDatosAlumno()
    {
        
    }
    
    public static void visualizarArray(ArrayList arrayL)
    {
        Iterator it = arrayL.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
    
    public static void main(String[] args) 
    {
        Scanner tec = new Scanner(System.in);
        Alumno alum1 = new Alumno(1,"Cristian","Aguerre");
        Alumno alum2 = new Alumno(2,"Nerea","Muñoz");
        Alumno alum3 = new Alumno(3,"Gabriel","Aguerre");
        
        ArrayList<Alumno> arrayParaEscribir = new ArrayList();
        arrayParaEscribir.add(alum1);
        arrayParaEscribir.add(alum2);
        arrayParaEscribir.add(alum3);
      
        try
        {
            escribirAlumnos("/home/mati/Ficheros para java/Practica1/alumnos.txt",arrayParaEscribir);
        }
        catch(IOException e)
        {
            System.out.println("Error al escribir el fichero alumno");
        }
        
        //CREO EL ARRAYLIST PARA ALMACENRA EN EL LOS DATOS
        
        ArrayList<Alumno> arrayL = new ArrayList<Alumno>();
        
        try
        {
            arrayL = cargarDatosEnArrayList("/home/mati/Ficheros para java/Practica1/alumnos.txt");
            System.out.println("Datos cargados, ArrayList OK");
            System.out.println();
        }
        catch(IOException e)
        {
            System.out.println("Error de fichero al intentar cargar los datos en le arrayList");
        }
        
        
        
        int opcion=0;
        while (opcion < 10)
        {
            System.out.println();
            System.out.println("Seleccione el numero de la opcion que desea realizar");
            System.out.println("-----------------------------------------------------");
            System.out.println("1 - Añadir nuevo alumno");
            System.out.println("2 - Buscar alumno por matricula");
            System.out.println("3 - Buscar alumno por nombre");
            System.out.println("4 - Modificar cualquier dato de un alumno");
            opcion = tec.nextInt();
            tec.nextLine();
        
        
        switch (opcion)
        {
            case 1://BLOQUE DE CODIGO PARA AÑADIR ALUMNO
                System.out.println("Añadiendo nuevo alumno");
                matricularAlumnoNuevo(arrayL);
                break;
            case 2://BLOQUE DE CODIGO PARA BUSCAR UN ALUMNO POR MATRICULA Y SI HAY RESULTADO MOSTRARLO
                System.out.println("Numero de matricula a buscar:");
                int num = tec.nextInt();
                Alumno aux=null;
                aux = buscarAlumnoPorMatricula(arrayL,num);
                if (aux == null)
                {
                    System.out.println();
                    System.out.println("Sin conincidencias");
                }
                else 
                {
                    System.out.println();
                    System.out.println("Alumno encontrado datos: ");
                    System.out.println(aux);
                }
                break;    
                
            case 3:
                System.out.println("Nombre a buscar:");
                String nombre = tec.nextLine();
                Alumno aux2=null;
                aux2 = buscarAlumnoPorNombre(arrayL,nombre);
                if (aux2 == null)
                {
                    System.out.println();
                    System.out.println("Sin conincidencias");
                }
                else 
                {
                    System.out.println();
                    System.out.println("Alumno encontrado datos: ");
                    System.out.println(aux2);
                }
                break;
                
            case 4:
                //MODIFICAR DATOS DE UN ALUMNO
            default:
                System.out.println("Cerrando programa");
                System.out.println("----------------------------------------------");
                
        }
        
        
        }
    }
    
}
