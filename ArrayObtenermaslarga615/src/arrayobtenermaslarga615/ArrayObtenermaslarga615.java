package arrayobtenermaslarga615;

public class ArrayObtenermaslarga615 {
    
    /*public String cadenasMasLarga (String [] cadena) EJEMPLO EN CLASE
    {
        int longcadena=0;
        String cadenaLarga=cadena[0];
        for (int i = 0; i <cadena.length;i++)
        {
            if (cadena[i].length()< longcadena)
            {
                cadenaLarga=cadena[i];
                longcadena = cadena[i].length();
            }
        }
        return cadenaLarga;
    }*/
    public static String cadenasMasLarga (String [] cadena)
    {
        String cadenaLarga=cadena[0];
        for (int i = 0; i <cadena.length;i++)
        {
            if (cadena[i].length()>cadenaLarga.length())
            {
                cadenaLarga=cadena[i];
            }
        }
        return cadenaLarga;
    }
    
    public static int obtenerNumVecesCar (String [] array1, char a)
    {
        int numDeVeces = 0;
        for (String cad: array1)
        {
            for (int i = 0; i <cad.length();i++)
            {
                if ( cad.charAt(i)== a)
                    numDeVeces ++;
            }
        }
        return numDeVeces;
    }
    
    
    
    public static void main(String[] args) {
        String[] arraycadenas = {"Hola","casa","adios","pelicula"};
        
        String cadena = ArrayObtenermaslarga615.cadenasMasLarga(arraycadenas);
        System.out.println(cadena);
        
        int Veces = obtenerNumVecesCar(arraycadenas, 'a');
        System.out.println(Veces);
    }
}
