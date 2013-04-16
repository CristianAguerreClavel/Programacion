package practica2colecciones;
import java.util.LinkedList;

    interface Pila
    {
    //Métodos.
        public abstract void meter(Object o);
        public abstract Object sacar();
        public abstract int tamano();
    }
    
    
    class PilaLIFO implements Pila //PILA
    {
        // Atributos.
            private LinkedList pila = null;
        // Constructor.
        public PilaLIFO()
        {
            pila = new LinkedList();
        }
        
        // Métodos.
        public void meter(Object o)
        {
            pila.add(0,o); //addFrist
        }
        
        public Object sacar()
        {
            return pila.remove(0);
        }
        
        public int tamano()
        {
            return pila.size();
        }
    }
    
    class PilaFIFO implements Pila //COLA
    {
    // Atributos.
        private LinkedList pila = null;
        
        // Constructor.
        public PilaFIFO()
        {
            pila = new LinkedList();
        }
        
        // Métodos.
        public void meter(Object o) 
        {
            pila.add(o); //addLast
        }
        
        public Object sacar()
        {
            return pila.remove(0);
        }
        
        public int tamano()
        {
            return pila.size();
        }
    }
   
    public class Practica2Colecciones
    {
        public static void main(String[] args)
        {
            // Uso de la pila FIFO.
            Pila pila = new PilaFIFO();
            
            pila.meter(new String("uno"));
            pila.meter(new String("dos"));
            pila.meter(new String("tres"));
            pila.meter(new String("cuatro"));
            
            System.out.println("Los elementos de la pila FIFO son:");
            int aux = pila.tamano();
            for(int i=0; i<aux; i++)
            System.out.print(pila.sacar() + ",");
            
            // Uso de la pila LIFO.
            pila = new PilaLIFO();
            
            pila.meter(new String("uno"));
            pila.meter(new String("dos"));
            pila.meter(new String("tres"));
            pila.meter(new String("cuatro"));
            
            System.out.println("");
            System.out.println("Los elementos de la pila LIFO son:");
            aux = pila.tamano();
            for(int i=0; i<aux; i++)
            System.out.print(pila.sacar() + ",");
        }
    }
