package trabajandoCerebro;

import java.io.*;
import java.util.*;

class ExcepcionArrayListNull extends Exception 
{
    public ExcepcionArrayListNull(String msg)
    {
        super("ArrayList vacio");
    
    }
}

//CLASE ALUMNO IMPLEMENTA SERIALIZABLE
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


public class TrabajandoCerebro 
{

    //METODO - RECIBE ARRAYLIST CON ALUMNOS Y LOS GUARDA EN UN ARCHIVO
    public static void escribirAlumnos(String fichero, ArrayList<Alumno> alum) throws IOException 
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        
        for (Alumno a : alum)
        {
            oos.writeObject(a);
        }
        oos.close();
        System.out.println("Datos del array escriros en el fichero");
    }
    
    //METODO - REBICE UN FICHERO LEE SU CONTENIDO (OBJETOS) LO ALMACENA EN UN ARRAY Y DEVUELVE DICHO ARRAY (UTILIZA DE FLUJOS - ObjectInputStream)
    public static ArrayList cargarDatosEnArrayList(String fichero)throws IOException
    {
        boolean fin = false;
        ArrayList array1 = new ArrayList();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        
        try
        {
           Object a = ois.readObject();// Hay que volver a leer para evitar un bucle infinito
           while (a != null && ! fin)
           {
               array1.add(a);
               a = ois.readObject();//aqui vuelvo a leer
           }
           ois.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error de tipo classnotfound");
        }
        catch (EOFException e)//ESTA EXCEPTION SE AÃ‘ADE PORQUE SINO SALE UNA EXCEPCION PORQUE LLEGA AL FINAL DEL ARCHIVO
        {
            fin = true;
        }
        return array1;
    }
    
    //METODO -  RELLENA UNA ARCHIVO CON DATOS PREDEFINIDOS EN UNA RUTA PREDEFINIDA
    public static void rellenarArchivoPorDefecto()
    {
        Alumno alum1 = new Alumno(1,"Cristian","Aguerre");
        Alumno alum2 = new Alumno(2,"Nerea","MuÃ±oz");
        Alumno alum3 = new Alumno(3,"Gabriel","Aguerre");
        
        ArrayList<Alumno> arrayParaEscribir = new ArrayList();
        arrayParaEscribir.add(alum1);
        arrayParaEscribir.add(alum2);
        arrayParaEscribir.add(alum3);
        System.out.println("Objetos creados y añadidos al arrayParaEscribir");
        
        try
        {
            escribirAlumnos("C:/Users/Christian/Ficheros para java/documento.txt",arrayParaEscribir);
        }
        catch(IOException e)
        {
            System.out.println("Error al escribir el fichero alumno");
        }
    }
    
    //METODO - RECIBE UN ARRAY Y EN EL AÑADE UN NUEVO ALUMNO DE TIPO ALUMNO (LINKA LA NUEVA INSTANCIA AL ARRAY)
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
    
    
    //METODO - RECIBE UN ARRRY Y UN NUMERO Y BUSCA DICHO NUMERO EN EL ARRAY (UTILIZA ITERATOR)
    public static Alumno buscarAlumnoPorMatricula(ArrayList arrayL, int num) 
    {
        try
        {   
           if(arrayL==null)
           {
               throw new ExcepcionArrayListNull("Error");
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
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
    
    
    //METODO - RECIBE UN ARRAY Y UN NOMBRE Y BUSCA DICHO NOMBRE EN EL ARRAY (UTILIZA ITERATOR)
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
    
    //METODO - DEVUELVE UN ARRAYLIST CON LOS DATOS DE UN FICHERO CARGADOS
    public static ArrayList crearArrayListConDatos()
    {
        ArrayList<Alumno> arrayL = new ArrayList<Alumno>();
        
        try
        {
            arrayL = cargarDatosEnArrayList("/home/mati/Ficheros para java/Practica1/alumnos.txt");
            System.out.println("Datos cargados, ArrayList OK");
            System.out.println();
            return arrayL;
        }
        catch(IOException e)
        {
            System.out.println("Error de fichero al intentar cargar los datos en le arrayList, metodo crearArrayListConDatos");
        }
        return null;
    }
    
    
    //METODO PARA VISUALIZAR UN ARRAY PASADO POR PARAMETRO
    public static void visualizarArray(ArrayList arrayL)
    {
        Iterator it = arrayL.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
    
    
    //MAIN
    public static void main(String[] args) 
    {
        Scanner tec = new Scanner(System.in);
        ArrayList<Alumno> arrayL = null;
        int opcion=0;
        while (opcion < 10)
        {
            System.out.println();
            System.out.println("Seleccione el numero de la opcion que desea realizar");
            System.out.println("-----------------------------------------------------");
            System.out.println("0 - Cargar alumnos por defecto en el fichero");
            System.out.println("1 - Crear arrayList y cargarle los datos"); 
            System.out.println("2 - Añadir nuevo alumno");
            System.out.println("3 - Buscar alumno por matricula");
            System.out.println("4 - Buscar alumno por nombre");
            System.out.println("5 - Modificar cualquier dato de un alumno");
            System.out.println("9 - Visualizar el contenido del array actual");
            opcion = tec.nextInt();
            tec.nextLine();
        
        
        switch (opcion)
        {
            case 0://BLOQUE DE CODIGO PARA CARGAR ALUMNOS EN EL FICHERO
                  rellenarArchivoPorDefecto();
                  break;
            case 1://BLOQUE DE CODIGO PARA CREAR EL ARRAYLIST
                try
                {
                  arrayL = cargarDatosEnArrayList("C:/Users/Christian/Ficheros para java/documento.txt");
                }
                catch (IOException e)
                {
                    System.out.println("Error no se encuentra el archivo para cargar");
                }
                break;
             
            case 2://BLOQUE DE CODIGO PARA AÃ‘ADIR ALUMNO
                System.out.println("AÃ±adiendo nuevo alumno");
                matricularAlumnoNuevo(arrayL);
                break;
            case 3://BLOQUE DE CODIGO PARA BUSCAR UN ALUMNO POR MATRICULA Y SI HAY RESULTADO MOSTRARLO
                
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
                
            case 4://BLOQUE DE CODIGO PARA BUSCAR A UN ALUMNO POR NOMBRE
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
            case 5:
                //MODIFICAR DATOS DE UN ALUMNO
                
            case 9://COGIDO DE BLOQUQ PARA VISUALIZAR UN ARRAY
                visualizarArray(arrayL);
                break;
            default:
                System.out.println("Cerrando programa");
                System.out.println("----------------------------------------------");
                
        }
        
        
        }
    }
    
}
