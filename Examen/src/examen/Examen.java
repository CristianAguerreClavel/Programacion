package examen;

import java.io.*;
import java.util.*;

class Persona 
{
    String nombre;
    String apellidos;
    int edad;
    
    public void setNombre(String nom)
    {
        nombre = nom;
    }
    
    public void setApellidos(String ape)
    {
        apellidos = ape;
    }
    
    public void setEdad (int edad)
    {
        this.edad = edad;
    }
    
    public String toString()
    {
        String texto = ("Nombre: "+nombre);
        return texto;
    }
}


class comparadorAlfabeticoPorNombre implements Comparator
{
    public int compare(Object o1, Object o2) {
        Persona a1 = (Persona)o1;
        Persona a2 = (Persona)o2;
        return a1.nombre.compareToIgnoreCase(a2.nombre);
    }
    
}

abstract class Profesor extends Persona implements Serializable
{
    int idProfesor;
    
    public Profesor(int id, String nombre, String ape, int edad)
    {
        idProfesor = id;
        setNombre(nombre);//Utiliza el metodo de su clase mayor para poner nombre
        setApellidos(ape);
        setEdad(edad);
    }
    
    public void setId(int a)
    {
        idProfesor = a;
    }
    
    abstract public float importeNomina();
    
    
}


class ProfesorTitular extends Profesor 
{
    public ProfesorTitular(int id,String nom, String ape, int edad)
    {
       super(id,nom,ape,edad);//Llamada al metodo de su superclase
    }
    
    public float importeNomina() 
    {
        float nomina;
        nomina = 1525;
        return nomina;
    }
    
    public String toSting()
    {
        String texto = ("IdProfesor"+idProfesor);
        return texto;
    }
}


class ProfesorInterino extends Profesor
{
    
    public ProfesorInterino(int id,String nom, String ape, int edad)
    {
        super(id,nom,ape,edad);//Llamada al metodo de su superclase
    }
    
    public float importeNomina() 
    {
        float nomina;
        nomina = 1600;
        return nomina;
    }
    
}


class ListinProfesor
{
    public static void addProfesor(Profesor profesor, ArrayList arraList)
    {
        arraList.add(profesor);
    }
    
    public static void imprimirListin(ArrayList arraList)
    {
        Iterator it = arraList.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
    
    public static float importeTotalNominaProfesorado(ArrayList arraList)
    {
        float totalNominas=0;
        Iterator it = arraList.iterator();
        Object aux = null;
        
        while (it.hasNext())
        {
            aux = it.next();
            
            if (aux instanceof ProfesorTitular)//Si el objeto en el arrayList es de tipo ProfesorTitular acedo al metodo nomina de ProfesorTitular
            {
                ProfesorTitular aux2 =(ProfesorTitular) aux;
                totalNominas += aux2.importeNomina();
            }
            else //en caso contrario es de tipo ProfesorInterino por lo tanto accedo al metodo nomina de la clase profesorInterino
            {
                ProfesorInterino aux2 = (ProfesorInterino) aux;
                totalNominas += aux2.importeNomina();
            }
        }
        return totalNominas;
    }
    
}


class Test 
{
    
    public static void PedirProfesores(ArrayList<Profesor> array1)
    {
        Scanner tec = new Scanner (System.in);
        int id = 0;
        String nombre,ape = null;
        int edad = 0;
        System.out.println("A continuacion introduzca el id y nombre de 3 profesores interinos: ");
        System.out.println("------------------------------------------");
        System.out.println("1º Profesor Interino");
        System.out.println("------------------------------------------");
        System.out.println("Introduzca el idProfesor:");
        id = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduzca el nombre:");
        nombre = tec.nextLine();
        System.out.println("Introduce los apellidos: ");
        ape = tec.nextLine();
        System.out.println("Introduce la edad:");
        edad = tec.nextInt();
        ProfesorInterino pInterino1 = new ProfesorInterino(id,nombre,ape,edad);
        array1.add(pInterino1);
        
        //SEGUNDO PROFESRO INTERINO
        System.out.println("------------------------------------------");
        System.out.println("2º Profesor Interino");
        System.out.println("------------------------------------------");
        System.out.println("Introduzca el idProfesor:");
        id = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduzca el nombre:");
        nombre = tec.nextLine();
        System.out.println("Introduce los apellidos: ");
        ape = tec.nextLine();
        System.out.println("Introduce la edad:");
        edad = tec.nextInt();
        ProfesorInterino pInterino2 = new ProfesorInterino(id,nombre,ape,edad);
        array1.add(pInterino2);
        
        //TERCER PROFESRO INTERINO
        System.out.println("------------------------------------------");
        System.out.println("3º Profesor Interino");
        System.out.println("------------------------------------------");
        System.out.println("Introduzca el idProfesor:");
        id = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduzca el nombre:");
        nombre = tec.nextLine();
        System.out.println("Introduce los apellidos: ");
        ape = tec.nextLine();
        System.out.println("Introduce la edad:");
        edad = tec.nextInt();
        ProfesorInterino pInterino3 = new ProfesorInterino(id,nombre,ape,edad);
        array1.add(pInterino3);
        
        System.out.println("A continuacion introduzca el id y nombre de 2 profesores titulares: ");
        //PRIMER PROFESRO TITULAR
        System.out.println("------------------------------------------");
        System.out.println("1º Profesor Titular");
        System.out.println("------------------------------------------");
        System.out.println("Introduzca el idProfesor:");
        id = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduzca el nombre:");
        nombre = tec.nextLine();
        System.out.println("Introduce los apellidos: ");
        ape = tec.nextLine();
        System.out.println("Introduce la edad:");
        edad = tec.nextInt();
        ProfesorTitular pTitular1 = new ProfesorTitular(id,nombre,ape,edad);
        array1.add(pTitular1);
        
        //SEGUNDO PROFESRO TITULAR
        System.out.println("------------------------------------------");
        System.out.println("2º Profesor Titular");
        System.out.println("------------------------------------------");
        System.out.println("Introduzca el idProfesor:");
        id = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduzca el nombre:");
        nombre = tec.nextLine();
        System.out.println("Introduce los apellidos: ");
        ape = tec.nextLine();
        System.out.println("Introduce la edad:");
        edad = tec.nextInt();
        ProfesorTitular pTitular2 = new ProfesorTitular(id,nombre,ape,edad);
        array1.add(pTitular2);
    }
    
    //COMO EL EJERCICIO DICE QUE EN LA CLASE TEST DEVE HACERSE EL QUE VISULALIZE, 
    //CREO UN METODO CON UNA LLAMADA AL METODO QUE ESTA EN LA CLASE LISTIN (DONDE DICE EL EJERCICIO QUE CREARA EL METODO
    //llamare desde el main a todo lo que pide en la clase test
    public static void visualizarImporteNominas(ArrayList array)
    {
        float total = ListinProfesor.importeTotalNominaProfesorado(array);
        System.out.println("Total de las nominas es: "+total);
    }
    
    
    public static void visualizarProfesoresOrdenados(ArrayList array)
    {
        Collections.sort(array, new comparadorAlfabeticoPorNombre());
        ListinProfesor.imprimirListin(array);
    }
    
    public static void guardarEnArchivoPorTipo(ArrayList<Profesor> array, String ficheroTitular,
                                                String ficheroInterino)throws IOException 
    { 
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroTitular));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(ficheroInterino));
       
        for (Profesor a : array)
        {
            if (a instanceof ProfesorTitular)
                oos.writeObject(a);
            else 
                oos2.writeObject(a);
        }
        oos.close();
        oos2.close();
    }
}

public class Examen {
    
    public static void main(String[] args) {
        
       ArrayList<Profesor> arraList = new ArrayList(); 
       
       //Realizao las llamadas a la clase test para que realize las acciones que pide el examen
       Test.PedirProfesores(arraList);
       Test.visualizarImporteNominas(arraList);
       Test.visualizarProfesoresOrdenados(arraList);
       try
       {
           Test.guardarEnArchivoPorTipo(arraList, "ProfesoresInterinos.txt","ProfesoresTitulares.txt");
       }
       catch (EOFException e)
       {
           System.out.println("Error EOF");
       }
       catch (FileNotFoundException e)
       {
           System.out.println("Error filenotfound");
       }
       catch (IOException e)
       {
           System.out.println("Error ioexeption");
       }
       
    }
}
