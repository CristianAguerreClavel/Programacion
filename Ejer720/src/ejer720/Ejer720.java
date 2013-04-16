package ejer720;
import java.io.*;
import java.util.*;

//REALIZADO PROPIO

public class Ejer720 {

    //METODO QUE LEE UN ARHICVO
    public static void LeerDeArchivo (String NombreArchivo) throws IOException
    {
        FileReader archivo = new FileReader(NombreArchivo);
        BufferedReader flujoLectura = new BufferedReader (archivo);
        String lectura = null;
        
        
        while ((lectura = flujoLectura.readLine()) != null)
        {
            System.out.println(lectura);
        }
        flujoLectura.close();
    }
    
    public static void ClasificarPalabrasLongitud (String NombreArchivo, int longitudDeCorte, String NombreArchivoMenor,
                                                   String NombreArchivoMayor) throws IOException
    {
        //CREACION DE TODOS LOS BUFER
        
        //LECTURA
        FileReader archivo = new FileReader(NombreArchivo);
        BufferedReader entrada = new BufferedReader (archivo);
        
        //ESCRITURA
        PrintWriter Salida1 = new PrintWriter (new BufferedWriter(new FileWriter(NombreArchivoMenor)));
        PrintWriter Salida2 = new PrintWriter (new BufferedWriter(new FileWriter(NombreArchivoMayor)));
        
        String lectura = null;
        
        while ((lectura = entrada.readLine()) != null)
        {
           if (lectura.length() > longitudDeCorte)
           {
               Salida2.println(lectura);
           }
           else
           {
               Salida1.println(lectura);
           }
        }
        entrada.close();
        Salida1.close();
        Salida2.close();
    }
    
    public static void main(String[] args) {
        
        try
        {
            LeerDeArchivo("/home/mati/Dropbox/Programacion/Documento.txt");
        }
        catch (IOException e)
        {
            System.out.println("No se pudo leer el archivo");
        }  
        
        try
        {
            ClasificarPalabrasLongitud("/home/mati/Dropbox/Programacion/Documento2.txt");
        }
    }
}

/*//Pruebas de funcionalidad y errores
       ProfesorInterino p1 = new ProfesorInterino(1,"xina","aguerre",23);
       ProfesorTitular p2 = new ProfesorTitular(2,"Nerea","aguerre",23);
        
       ListinProfesor.addProfesor(p1,arraList);
       ListinProfesor.addProfesor(p2,arraList);
       
       float nomina = ListinProfesor.importeTotalNominaProfesorado(arraList);
       System.out.println(nomina);*/