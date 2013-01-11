package excepciones.pkg431;
import java.lang.*;

public class Excepciones431 {
    

    public static void main(String[] args) {
        
        /* Ejercicio 4.31
        try
        {
            System.out.println("Mensaje mostrado por pantalla");
            Exception e = new Exception ("Esto es un objeto Excepcion");
            throw e;
        }
        catch(Exception e1) 
        {
            System.out.println("Excepcion capturada con el mensaje: " +e1.getMessage());
        }
        System.out.println("Programa terminado");*/
        
        
        
        //EJERCICIO 4.32
      
        try
        {
            System.out.println("Generando numero aleatorio");
            int numAleatorio = (int)(Math.random()*100);
            if (numAleatorio %2 ==0)
                throw new Exception ("Se genero el numero par: " +numAleatorio);
            else 
                throw new Exception ("Se genero el numero impar: " +numAleatorio);
        }
        
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
            
        
        
        
        
        
        
        
    }
        
}
