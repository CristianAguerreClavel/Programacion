package ledeobjestos79;

import java.io.*;

public class LEDEObjestos79 {

    public static void main(String[] args) {
//FLUJO DE ESCRITURA
    try
    {
        FileOutputStream archivoNumeros = new FileOutputStream("/home/mati/numeros.txt");
        for (int i = 0 ;i<100;i++)
        {
            archivoNumeros.write(i);
        }
        archivoNumeros.close();
    }
    catch (IOException ioE)
    {
        System.out.print("Error de escritura "+ ioE.toString());
    }
//LECTRURA
    try
    {
        FileInputStream archivoNumeros2 = new FileInputStream("/home/mati/numeros.txt");
        for (int i = 0 ;i<100;i++)
        {
           System.out.println(archivoNumeros2.read());
        }
        archivoNumeros2.close();
    }
    catch (IOException ioE)
    {
        System.out.println("Error de escritura "+ ioE.toString());
    }
    }
    
}
