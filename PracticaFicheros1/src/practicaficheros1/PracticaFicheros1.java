package practicaficheros1;

import java.io.*;
import java.util.*;

class FicheroVacio extends Exception
{
    public FicheroVacio(String msg)
    {
        super(msg);
    }
}

class Alumno implements Comparable<Alumno>, Serializable
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
    
    public void setMatricula(int matricula)
    {
        numeroMatricula = matricula;
    }
    
    public void setCodigoPostal(int codigo)
    {
        codigoPostal = codigo;
    }
    
    public void setTelefono(int tele)
    {
        telefono = tele;
    }
    
    public void setNombre ( String nom)
    {
        nombre = nom;
    }
    
    public void setApe(String ape)
    {
        apellidos = ape;
    }
    
    public int compareTo(Alumno alum)
    {
        
        if (numeroMatricula == alum.numeroMatricula)
            return 0;
        if (numeroMatricula < alum.numeroMatricula)
            return -1;
        else 
            return 1;
    }
    
    
    public String toString ()
    {
        String texto=("Matricula: "+numeroMatricula+" Nombre: "+nombre);
        return texto;
    }
    
}

class OrdenarAlumnoPorNombre implements Comparator
{
 
    public int compare(Object o1, Object o2) 
    {
        Alumno alum1 = (Alumno)o1;
        Alumno alum2 = (Alumno)o2;
        return alum1.nombre.compareToIgnoreCase(alum2.nombre);
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
    
    public static void guardar(String fichero, ArrayList<Alumno> alum) throws IOException 
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
    
    public static void modificarDatosAlumno(ArrayList arrayL)
    {
        int matricula=0;
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduzca la matricula del alumno a modificar: ");
        matricula = tec.nextInt();
        tec.nextLine();
        Alumno alum1;
        
        alum1 = buscarAlumnoPorMatricula(arrayL, matricula);
        
        if (alum1 != null)
        {
            System.out.println("Alumno encontrado que desea modificar: ");
            int opcion1 = 0;
            
            while (opcion1 < 10)
            {
                System.out.println("1- Modificar Numero de matricula");
                System.out.println("2- Modificar Nombre");
                System.out.println("3- Modificar telefono");
                System.out.println("4- Modificar apellido");
                System.out.println("10- salir");
                opcion1 = tec.nextInt();
                tec.nextLine();
                
                switch (opcion1)
                {
                    case 1:
                        int mat = 0;
                        System.out.println("Introduzca el nuevo numero de matricula");
                        alum1.setMatricula(matricula);
                        break;
                }
            }
            
        }
        else 
            System.out.println("Esta matricula no corresponde a ningun alumno");
    }
    
    public static void eliminarAlumnoPorMatricula(ArrayList ArrayL)
    {
        int matricula = 0;
        Scanner tec = new Scanner(System.in);
        
        System.out.println("Introduzca el numero de matricula del alumno a eliminar: ");
        matricula = tec.nextInt();
        tec.nextLine();
        
        Alumno alum1 = buscarAlumnoPorMatricula(ArrayL,matricula);
        ArrayL.remove(alum1);
    }
    
    public static void inicioPrograma()//Relleno un fichero para pruebas
    {
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
        //inicioPrograma();
        
        //CREO EL ARRAYLIST PARA ALMACENRA EN EL LOS DATOS
        ArrayList<Alumno> arrayL = new ArrayList<Alumno>();
        
        try
        {
            arrayL = cargarDatosEnArrayList("alumnos.txt");
            System.out.println("Datos cargados, ArrayList OK");
            System.out.println();
        }
        catch(IOException e)
        {
            System.out.println("Error de fichero al intentar cargar los datos en le arrayList");
        }
        
        //MENU
        int opcion=0;
        while (opcion != 100)
        {
            System.out.println();
            System.out.println("Seleccione el numero de la opcion que desea realizar");
            System.out.println("-----------------------------------------------------");
            System.out.println("1 - Añadir nuevo alumno");
            System.out.println("2 - Buscar alumno por matricula");
            System.out.println("3 - Buscar alumno por nombre");
            System.out.println("4 - Modificar cualquier dato de un alumno");//falta implementear el metodo
            System.out.println("5 - Ordenar por numero de matricula");
            System.out.println("6 - Ordenar por nombre");
            System.out.println("7 - Visualizar en pantalla");
            System.out.println("8 - Borrar un alumno");
            System.out.println("9 - Guardar");
            System.out.println("10 - Salir");
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
                 modificarDatosAlumno(arrayL);
                
            case 5:
               Collections.sort(arrayL);
               break;
                
            case 6:
                Collections.sort(arrayL, new OrdenarAlumnoPorNombre()); 
                break;
                
            case 7:
                visualizarArray(arrayL);
                break;
                
            case 8:
                eliminarAlumnoPorMatricula(arrayL);
                break;
                
            case 9:
                try
                {
                guardar("alumnos.txt",arrayL);
                }
                catch (IOException e)
                {
                    System.out.println("No se pude guardar");
                }
                break;
                
            case 10:
                opcion = 100;
                System.out.println("Cerrando programa");
                break;
            
            default:
                System.out.println("Opcion no esperada");
                System.out.println("----------------------------------------------");
        }
        
        
        }
    }
    
}
