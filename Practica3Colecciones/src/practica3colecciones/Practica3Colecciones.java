
package practica3colecciones;

interface Trama 
{
    //metodos
    public abstract void setPuerto(int a);
    public abstract void setPrioridad(int a);
    
}


class Tcp implements Trama
{
    int puerto, prioridad;
    
    Tcp (){
        
    }
    
    public void setPuerto(int a)
    {
        puerto= a;
    }
    
    public void setPrioridad(int a)
    {
        prioridad = a;
    }
}

class Udp implements Trama
{
    int puerto, prioridad;
    
    Udp(){
        
    }
    
    public void setPuerto(int a)
    {
        puerto=a;
    }
    
    public void setPrioridad(int a )
    {
        prioridad= a;
    }
}


public class Practica3Colecciones {

    public static void main(String[] args) {
        
    }
}
