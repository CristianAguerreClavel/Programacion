package arraybidimensional619;

public class ArrayBidimensional619 {
    
    public static void rellenarMatrizSecuencial1 (int [][] a)
    {
        //Estas sentencias for rellenan la matriz
        for (int i = 0, k = 0 ; i<a.length;i++)
            for (int x = 0; x <a[i].length;x++)
                a[i][x]= k++;
        //Estas sentencias for muestran el contenido de la matriz ya construida
        for (int z=0; z<a.length;z++)
        {
            System.out.println("");
        
            for (int l= 0 ;l<a[z].length;l++)
                System.out.print(a[z][l]+" ");
        }
            
    }
    
    public static void rellenarMatrizSecuencial2(int[][] a)
    {    
        //Estas sentencias for rellenan la matriz
        for (int i = 0, k = 0 ; i<a.length;i++)
            for (int x = 0; x <a[i].length;x++)
                a[x][i]= k++; //La primera manera de conseguirla es invertir los indices al seleccionar la posicion a escribir
        //Estas sentencias for muestran el contenido de la matriz ya construida
        for (int z=0; z<a.length;z++)
        {
            System.out.println("");
        
            for (int l= 0 ;l<a[z].length;l++)
                System.out.print(a[z][l]+" ");
        }     
    }
    
    public static void obtenerMatrizIdentidad(int [][] a)
    {
        for (int i = 0; i<a.length;i ++)
            for (int x = 0; x<a[i].length;x++)
                if(i==x)
                    a[i][x]=1;
        
        for (int z=0; z<a.length;z++)
        {
            System.out.println("");
        
            for (int l= 0 ;l<a[z].length;l++)
                System.out.print(a[z][l]+" ");
        }     
    }
    
    public static String matrizCharComoString ( char [][] a)//SIN TERMINAR, FALTA INICIALIZAR MATRIZ CON VALORES
    {
        String cadena = "";
        
        for (int i = 0; i < a.length;i++)
            for (char car: a[i])
                cadena += car;
            
        return cadena;
    }
    
    
    
    public static void main(String[] args) {
    
        int [][] arrayBidimensional = new int[5][5];
        int [][] arrayBidimensional2 = new int[5][5];
        int [][] arrayBidimensional3 = new int[5][5];
        char[][] array1 = new char[5][5];
        array1[0][0]='A';
        array1[0][1]='b';
        array1[0][2]='e';
        array1[0][3]='e';
        array1[0][4]='e';
        array1[1][0]='Y';
        
        rellenarMatrizSecuencial1(arrayBidimensional);
        System.out.println();
        System.out.println("------------------------------------------------");
        rellenarMatrizSecuencial2(arrayBidimensional2);
        System.out.println();
        System.out.println("------------------------------------------------");
        obtenerMatrizIdentidad(arrayBidimensional3);
        System.out.println();
        System.out.println("------------------------------------------------");
        String arraycadena = matrizCharComoString(array1);
        System.out.println(arraycadena);
    }
}
