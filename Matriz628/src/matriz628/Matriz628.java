package matriz628;

public class Matriz628 {
    
    
    public static int[][] obtenerDiagonales(int [][]a)
    {
        
      int[][] arrayConDiagonales= new int[3][3];  
      for (int i=0;i<a.length;i++)
          for(int j=0;j<a[i].length;j++)
          {
             if(i==j)
             {//No funciona bien comprobar en casa
               for (int r=0;r<arrayConDiagonales.length;r++)
                   for (int y=0; y<arrayConDiagonales[r].length;y++)
                    arrayConDiagonales[r][y]=a[i][j];
               
               
             }
          }
      return arrayConDiagonales;        
        
    }
    
    
    
    public static void main(String[] args) {
        
        int[][] array1 = new int[3][4];
        array1[0][0]=1;
        array1[0][1]=2;
        array1[0][2]=3;
        array1[1][0]=4;
        array1[1][1]=5;
        array1[1][2]=6;
        array1[2][0]=7;
        array1[2][1]=8;
        array1[2][2]=9;
              
        int[][] arrayob = obtenerDiagonales(array1);
        
        for (int z=0; z<arrayob.length;z++)
        {
            System.out.println("");
        
            for (int l= 0 ;l<arrayob[z].length;l++)
                System.out.print(arrayob[z][l]+" ");
        }     
    }
}
