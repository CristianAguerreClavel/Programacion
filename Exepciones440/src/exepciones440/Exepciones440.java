package exepciones440;

class Execp1 {
    
    //Este metodo lanza una execpcion al dividir entre cero, la captura ArithmeticExecption
    public void dividirEntreArray (int num, int[] array)
    {
       
        for (int i:array){//Esta manera de recorer el array funciona : i va tomando los valores del contenido del las posiciones del array empezando desde la posicion 0
        try
        {
            System.out.println(i+ "Dividio entre "+num+" es igual a "+ num/i);
            
        }catch (ArithmeticException ex1)
            {
            System.out.println("No se puede dividir entre 0");
            }
        }
    
    
    }
}


public class Exepciones440 {
    
       public static void main(String[] args) {
           int[] array ={-2,-1,0,1,2};
           Execp1 objeto1 = new Execp1();
           objeto1.dividirEntreArray(2, array);
           
    }
}
