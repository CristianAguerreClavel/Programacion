package entradaysalida3;
import java.io.*;

//LEER DESDE TECALDO

public class EntradaYSalida3 {

    public static void main(String[] args) {
    
        InputStreamReader conversor;
        BufferedReader teclado;
        String linea;
        
        conversor = new InputStreamReader (System.in);
        teclado = new BufferedReader (conversor);
        
        try{
        
        System.out.println("Introduzca un byte; ");
        linea = teclado.readLine();
        byte b = Byte.parseByte(linea);
        System.out.println("El valor leido fue " + b);
        
        System.out.println("Introduzca un int;");
        linea = teclado.readLine();
        int i = Integer.parseInt(linea);
        System.out.println("El valor leido fue : " +i);
        
        System.out.print("introduzca un double");
        linea = teclado.readLine();
        double d = Double.parseDouble(linea);
        System.out.println("Elvaor leido fue;" +d);
        
        } catch (IOException){
            System.out.println("Error al realizar la operacion");
        }
        
        boolean leido;
        do{
            try 
            {
                System.out.println("Introduzca un int; ");
                linea = teclado.readLine();
                i = Integer.parseInt(linea);
                leido = true;
            }catch (NumberFormatException e)
            {
                System.out.println("Numero no valido. Vuleva a intentarlo");
                leido = false;
            }
        }while (!leido);
            System.out.println("El valor leido fue; " +i);
        }
        
    }

