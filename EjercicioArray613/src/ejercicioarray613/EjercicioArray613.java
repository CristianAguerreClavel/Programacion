package ejercicioarray613;
public class EjercicioArray613 {
    
    public static int [] obtenerLongdeCadenas (String[] arrayCadena) throws Exception
    {
        if (arrayCadena == null)
            throw new IllegalArgumentException("Argumento no valido");
        int[] vectorDeLongitudes = new int[arrayCadena.length];
        
        for (int i = 0; i< arrayCadena.length;i++)
        {
           System.out.println(vectorDeLongitudes[i]=arrayCadena[i].length());
        }
        
        return vectorDeLongitudes;
    }
    
    
    
    public static void main(String[] args) {
         
        String[] arraycadenas = {"Hola","casa","adios","pelicula"};
        EjercicioArray613 a= new EjercicioArray613();
        
        try
        {
            EjercicioArray613.obtenerLongdeCadenas(arraycadenas);
        }    
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
             
        }
        
    
       
        
       
    }

