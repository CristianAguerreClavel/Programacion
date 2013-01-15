package execpciones442;

import sun.reflect.generics.tree.CharSignature;

public class Execpciones442 {
    
    public static void mostrarCadenarArray(String[] array)
    {
        int cont=0;
        for (String letra: array)
        {
            
            System.out.println("La cadena " +cont+ " contiene la 1º letra: ");
            System.out.println(letra.charAt(0));
            cont++;
        }
    }
    
    public static void main(String[] args) {
        String[] array = new String[3];
        
        array[0]="Hola";
        array[1]="Adios";
        array[2]="Buenos dias";
        
        Execpciones442.mostrarCadenarArray(array);
        
    }
}
