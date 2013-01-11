package adivina_430;
import java.util.*;

public class Adivina_430 {
    
    
    public static void main(String[] args) {
    
        int numeroAleatorio;
        int numIntentos=0;
        int numero=0;
        Scanner teclado = new Scanner(System.in);
        
        numeroAleatorio = (int) (Math.random()*100);
        numeroAleatorio++;//Esto es porque tiene que ser entre 1 y 100
        
        do
        {
            boolean leido;
            do 
            {
                System.out.println("Introduzca un numero entre 0 y 100");
                try 
                {
                    numIntentos ++;
                    numero= teclado.nextInt();
                    System.out.println("El numero introducido es "+numero);
                    leido = true;
                }
                catch (InputMismatchException e)
                {
                    System.out.println("No ha introducido un numero entero valido");
                    teclado.next();
                    leido = false;
                }
            }while(leido == false);
            
            if (numero < numeroAleatorio)
                System.out.println("El numero aleatorio es mayor");
            if (numero > numeroAleatorio)
                System.out.println("El numero aleatorio es menor");
            
        }while(numero != numeroAleatorio);
        
        System.out.println("Enhorabuena has acertado en "+numIntentos+ " intentos");
    }
}
