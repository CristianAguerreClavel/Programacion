
package ledeobjetos74;
import java.io.*;

public class LEDEObjetos74 {

    public byte[][] obtenerMatrizIdentirdad (int dimension)
    {
        if (dimension <= 0)
        {
            throw new IllegalArgumentException("Argumento incorrecto");
        }
        byte[][] matriz = new byte[dimension][];
        for (int i = 0; i < matriz.length;i++)
        {
            ByteArrayOutputStream fila = new ByteArrayOutputStream(dimension);
            for ( int j = 0; j< dimension;j++)
            {
                fila.write(i==j?1:0);
            }
            try
            {
                fila.close();
            }
            catch(IOException ioE){}
            matriz[i] = fila.toByteArray();
        }
        return matriz;
    }
    
    public static void main(String[] args) {
    
       
        
    }
}
