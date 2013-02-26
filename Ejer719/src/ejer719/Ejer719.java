package ejer719;

import java.io.*;
import java.util.*;

public class Ejer719 {

    public static String[] ObtenerLineasDeArchivo(String nombreArchivo) throws IOException
    {
        FileReader archivo = new FileReader(nombreArchivo);
        BufferedReader flujoLectura = new BufferedReader (archivo);
        String lectura = null;
        ArrayList <String> al = new ArrayList <String>();
        
        /*
         *  lectura = flujoLectura.readLine()); 
            while (lectura != null)
            {
                al.add(lectura);
            }
         
         */
        
        while( (lectura = flujoLectura.readLine()) != null)
        {
            al.add(lectura);
        }
        flujoLectura.close();
        return ((String[])al.toArray(new String[al.size()]));
    }
    
    public static void main(String[] args) {
        
        String[] aux = new String[5];
        
        try
        {
            aux =ObtenerLineasDeArchivo("/home/mati/Dropbox/Programacion/Documento.txt");
        }
        catch (IOException e)
        {
            System.out.println("Error");
         
        }
        
        for (String a1 :aux)
        {
            System.out.println(a1);
        }
    }
        
}
