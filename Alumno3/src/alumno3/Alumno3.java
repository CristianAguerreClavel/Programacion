package alumno3;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.*;

class Alumno implements Comparable<Alumno>,Comparator<Alumno> 
{
    public String nombre;
    public String apellidos;
    public int año;
    public int nota;
    
    public Alumno(String nombre, String apellidos, int año, int nota){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.año=año;
        this.nota=nota;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public int getAño(){
        return this.año;
    }
    public int getNota(){
        return this.nota;
    }
    
    public String toString(){
        String aux="";
        aux=this.nombre+" "+this.apellidos+"//Año de nacimiento "+this.año+" Nota: "+this.nota;
        return aux;
    }
    
    public int compareTo(Alumno alum){
      //  return nota.compareTo(alum.getNota());
      if(nota>alum.getNota()) return 1;
       if(nota<alum.getNota()) return -1;
        return 0;
    }
    public int compare (Alumno a, Alumno b) {
            return a.apellidos.compareTo(b.apellidos);
    }
    
    public void asignarNotas(int[] matriz)
    {
        
    }

}


public class Alumno3 {

    public static void main(String[] args) {
        
        Alumno[] array1 = new Alumno[5];
        
        Alumno alum1 = new Alumno("Juan","muñoz",1991,5);
        array1[0] = alum1;
        Alumno alum2 = new Alumno("Carlos","suzrez",1981,8);
        array1[1] = alum2;
        Alumno alum3 = new Alumno("Carla","peña",1971,9);
        array1[2] = alum3;
        Alumno alum4 = new Alumno("Jose","lusa",1991,9);
        array1[3] = alum4;
        Alumno alum5 = new Alumno("Julian","comenero",1991,3);
        array1[4] = alum5;
        
        int[][] arrayNotas = new int[2][2];
        
        arrayNotas[0][0] = 6;
        arrayNotas[0][1] = 7;
        arrayNotas[1][0] = 3;
        arrayNotas[1][1] = 6;
        
        
        for (int i = 0;i<array1.length;i++)
        {
            System.out.println("Nombre del alumno: "+array1[i].nombre);
            System.out.println("Nota del alumno: "+array1[i].nota);
            System.out.println("-----------------------------------------------");
        }
        
        System.out.println("Ordenado por notas");
        Arrays.sort(array1);//Llamada al metodo
        //Visualizacion
        for(int i=0;i<5;i++){
           System.out.println(array1[i]);
           //System.out.println();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Ordenado por apellidos");
       
       Arrays.sort(array1,array1[0]);//Llamada al metodo
       //Visualizacion
       for(int i=0;i<5;i++){
           System.out.println(array1[i]);
           //System.out.println();
       }
    }
}
