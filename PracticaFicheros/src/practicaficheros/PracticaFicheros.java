package practicaficheros;

import java.io.*;
import java.util.*;

class Alumno implements Serializable, Comparable<Alumno>
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
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setApe ( String ape)
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

class OrdenarPorNombre implements Comparator<Alumno>
{
    public int compare(Alumno t, Alumno t1) 
    {
        return t.nombre.compareTo(t1.nombre);
    }
}



public class PracticaFicheros 
{

    public static void GuardarArrayEnFichero(String fichero, ArrayList<Alumno> alum) throws IOException 
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        
        for (Alumno a : alum)
        {
            oos.writeObject(a);
        }
        oos.close();
    }
    
    
    //Metodo para cargar los datos del fichero en el arrayList
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
        catch (EOFException e)//ESTA EXCEPTION SE AÃ‘ADE PORQUE SINO SALE UNA EXCEPCION PORQUE LLEGA AL FINAL DEL ARCHIVO
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
        Scanner tec1 = new Scanner(System.in);
        System.out.println("Introduzca el numero de matricula del alumno a modificar");
        int mat = tec1.nextInt();
        Alumno alumAux = null;
        alumAux = buscarAlumnoPorMatricula(arrayL, mat);
        
        if ( alumAux != null)
        {
            System.out.println("Eliga una opcion a realizar");
            System.out.println("---------------------------------------------");
            System.out.println("1 - Modificar Matricula");
            System.out.println("2 - Modificar nombre");
            System.out.println("3 - Modificar Apellidos");
            System.out.println("4 - Salir sin realizar cambios");
            int opcion = tec1.nextInt();
            tec1.nextLine();
            
            switch (opcion)
            {
                case 1:
                    int matricula;
                    System.out.println("Introduzca el numero de la nueva matricula");
                    matricula = tec1.nextInt();
                    tec1.nextLine();
                    alumAux.setMatricula(matricula);
                    System.out.println("Numero de matricula modificado correctamente");
                    break;
                case 2:
                    String nombre;
                    System.out.println("Introduzca el nuevo nombre");
                    nombre = tec1.nextLine();
                    alumAux.setNombre(nombre);
                    System.out.println("Nombre modificado correctamente");
                    break;
                case 3:
                    String ape;
                    System.out.println("Introduzca el nuevo apellido");
                    ape = tec1.nextLine();
                    alumAux.setApe(ape);
                    System.out.println("Apellido modificado correctamente");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error al seleccionar numero");
            }
        }
        else
            System.out.println("Sin coincidencias, volviendo al menu principal");
    }
    
    public static void visualizarArray(ArrayList arrayL)
    {
        Iterator it = arrayL.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
    
    public static void borrarAlumnoPorMatricula(ArrayList ArrayL)
    {
        Scanner tec = new Scanner(System.in);
        int matricula = 0;
        
        System.out.println("Introduzca el numero de matricula del alumno a eliminar:");
        matricula = tec.nextInt();
        tec.nextLine();
        
        ArrayL.remove(buscarAlumnoPorMatricula(ArrayL, matricula));
    }
    
    //Metodo que sirve para cargar el array con datos del fichero nada mas iniciarse el programa
    public static ArrayList CargaDeArray()
    {
        ArrayList arrayL = new ArrayList();
        try
        {
            arrayL = cargarDatosEnArrayList("alumnos.txt");
            System.out.println("Datos cargados, ArrayList OK");
            System.out.println();
        }
        catch(IOException e)
        {
            System.out.println("Error, no se encontro el archivo alumnos.txt");
        }
        return arrayL;
    }
    
    public static void main(String[] args) 
    {
        Scanner tec = new Scanner(System.in);
        //CREO EL ARRAYLIST Y CARGO EL FICHERO PARA TRABAJAR CON EL 
        ArrayList<Alumno> arrayL = CargaDeArray();
        int opcion=0;
        boolean salir = false;
        
        while (!salir)
        {
            System.out.println();
            System.out.println("Seleccione el numero de la opcion que desea realizar");
            System.out.println("-----------------------------------------------------");
            System.out.println("1 - AÃ±adir nuevo alumno");
            System.out.println("2 - Buscar alumno por matricula");
            System.out.println("3 - Buscar alumno por nombre");
            System.out.println("4 - Modificar cualquier dato de un alumno");
            System.out.println("5 - Ordenar por numero de matricula");
            System.out.println("6 - Oredenar por nombre");
            System.out.println("7 - Visualizar por pantalla");
            System.out.println("8 - Borrar un alumno");
            System.out.println("9 - Guardar en fichero");
            System.out.println("10 - Salir del programa");
            opcion = tec.nextInt();
            tec.nextLine();
        
        
        switch (opcion)
        {
            case 1://BLOQUE DE CODIGO PARA AÃ‘ADIR ALUMNO
                System.out.println("AÃ±adiendo nuevo alumno");
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
                break;
                
            case 5:
                Collections.sort(arrayL);
                System.out.println("Array Ordenado por matricula");
                break;
                
            case 6:
                Collections.sort(arrayL, new OrdenarPorNombre());
                System.out.println("Array Ordenado por nombre");
                break;
                
            case 7:
                visualizarArray(arrayL);
                break;
                
            case 8:
                borrarAlumnoPorMatricula(arrayL);
                break;
             
            case 9:
                try
                {
                GuardarArrayEnFichero("alumnos.txt", arrayL);
                }
                catch(IOException e)
                {
                    System.out.println("Error al intentar guardar en el fichero alumnos.txt");
                }
                break;
                
            case 10:
                salir = true;
                System.out.println("Cerrando programa");
                break;
                
            default:
                System.out.println("Opcion no reconocida");
                System.out.println("----------------------------------------------");
                
        }
        
        
        }
    }
    
}
