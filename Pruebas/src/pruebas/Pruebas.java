package pruebas;

public class Pruebas {
    
    public static void main(String[] args) {
        
        int contador = 2;
        
        Object[] array = new Object[5];
        
        array[0]=1;
        array[1]=2;
        array[2]=3;
        
        

        System.out.println("Array: " +array[--contador]);
        System.out.println("Contador: " + contador);
        }
}
