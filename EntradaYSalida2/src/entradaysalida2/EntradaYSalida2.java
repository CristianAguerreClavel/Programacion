package entradaysalida2;
import java.io.*;

//LEER Y ESCRIBIR DESDE ARCHIVO LINEAS

public class EntradaYSalida2 {
    
    public static void main(String[] args) {
        String nombreArchivo="LeerArchivo.java";
        
        FileReader archivo;
        BufferedReader filtro;
        String linea;
        try
        {
            archivo = new FileReader(nombreArchivo);
            filtro = new BufferedReader(archivo);
            linea = filtro.readLine();
            while (linea != null)
            {
                System.out.println(linea);
                linea = filtro.readLine();
            }
            filtro.close();
        }catch (IOException e)
        {
            System.out.println("Imposible abrir el archivo para leer");
        }
    }
}
