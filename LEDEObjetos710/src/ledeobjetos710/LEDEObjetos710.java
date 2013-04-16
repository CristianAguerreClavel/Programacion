
package ledeobjetos710;
import java .io.*;

public class LEDEObjetos710 {
    
    public static int obtenerSumaNumerosArchivo(String nombreArchivo) throws IOException
    {
        FileInputStream archivoNum = new FileInputStream(nombreArchivo);
        int numero, suma = 0 ;
        while ((numero= archivoNum.read())!= -1)
        {
            suma += numero;
        }
        archivoNum.close();
        return suma;
    }
    
    
    public static void main(String[] args) {
        
    }
    
 }

