package vehiculo518;

public class Vehiculo518 
{
    private String matricula;
    private int velocidad;
    
    
    public Vehiculo518(String matricula)
    {
        this.matricula=matricula;
        velocidad = 0;
    }
    
    public String getMatricula()
    {
        return matricula;
    }
    
    public int getVelocidad()
    {
        return velocidad;
    }
    public void acelerar (int cuanto)
    {
        velocidad +=cuanto;
    }
    
    public String toString()
    {
        return "El vehiculo con matricula "+matricula+" circula a "+velocidad+"km/h";
    }
    
    public static void main(String[] args) 
    {
        
    }
}

class coche extends Vehiculo518
{
    int numPuertas = 0;
    
    public coche(String matricula, int numPuertas)
    {
        super(matricula);
        this.numPuertas=numPuertas;
    }
    
    public int getNumPuertas()
    {
        return numPuertas;
    }
    
    
}

class remolque 
{
    int peso;
    
    public remolque(int peso)
    {
        this.peso=peso;
    }
    
    public int getPeso()
    {
        return peso;
    }
    
    public String toString()
    {
        return "Remolque con un peso de "+peso;
    }
}

class camion extends Vehiculo518
{
    remolque remolque;
    
    public camion (String matricula, String remolque)
    {
        super(matricula);
        remolque = null;
    }
    
    public void ponerRemolque(remolque rem)
    {
        this.remolque = rem;
    }
    
    public void quitarRemolque()
    {
        remolque = null;
    }
    
    public String toString()
    {
        if (remolque != null)
        {
            return super.toString()+". Lleva "+remolque.toString();
        }
        else
            return super.toString();
    }
}



