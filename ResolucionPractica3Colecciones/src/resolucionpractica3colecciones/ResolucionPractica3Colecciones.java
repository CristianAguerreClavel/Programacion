package resolucionpractica3colecciones;

    import java.util.Iterator;
    import java.util.TreeSet;


abstract class Trama implements Comparable
    {
        // Atributos.
        private int puerto = 0;
        private int prioridad = 0;
        private String contenido = null;

        // Constructor.
        public Trama(int param1, int param2, String param3)
        {
            puerto = param1;
            prioridad = param2;
            contenido = param3;
        }
        // Métodos.
        public int getPuerto()
        {
            return puerto;
        }
        
        public int compareTo(Object otraTrama)
        {
            Trama trama = (Trama)otraTrama;
            if(trama.prioridad > this.prioridad)
            return -1;
            else if(trama.prioridad < this.prioridad)
            return 1;
            else
            return trama.contenido.compareTo(this.contenido);
        }
        
        public String toString()
        {
            return "Trama con prioridad: " + prioridad + " y contenido: " + contenido;
        }
    }

class TramaTCP extends Trama
{
    // Constructor.
    public TramaTCP(int puerto, int prioridad, String contenido)
    {
        super(puerto, prioridad, contenido);
    }
}
    

class TramaUDP extends Trama
{
    // Constructor.
    public TramaUDP(int puerto, int prioridad, String contenido)
    {
        super(puerto, prioridad, contenido);
    }
    
}

class Buffer
{
    // Atributos.
    private TreeSet tramas = null;
    
    // Constructor.
    public Buffer()
    {
        tramas = new TreeSet();
    }
    
    // Métodos.
    public void meter(Trama trama)
    {
        tramas.add(trama);
    }
    
    public Trama sacar()
    {
        Trama trama = (Trama)tramas.first();
        tramas.remove(trama);
        return trama;
    }
    
    public void mostrar()
    {
        if(tramas.isEmpty())
        {
            System.out.println("El buffer está vacío.");
        }
        
        else
        {
            Iterator it = tramas.iterator();
            while(it.hasNext())
            System.out.println(it.next());
        }
        
    }
       
    public int getNumTramas()
    {
        return tramas.size();
    }
    
}
    

class BufferConLimite extends Buffer
{
    
    // Atributos.
    private int limite = 0;
    
    // Constructor.
    public BufferConLimite(int param)
    {
        limite = param;
    }
    
    // Métodos.
    public void meter(Trama trama)
    {
        super.meter(trama);
    }
    
    public boolean isFull()
    {
        if(super.getNumTramas() < limite)
        return false;
        else
        return true;
    }
}


class InterfazRed
{
    // Atributos.
    private BufferConLimite buffer = null;
    private Buffer puerto1, puerto2, puerto3 = null;
    
    // Constructor.
    public InterfazRed()
    {
        buffer = new BufferConLimite(4);
        puerto1 = new Buffer();
        puerto2 = new Buffer();
        puerto3 = new Buffer();
    }
    
    // Métodos.
    public void recepcionar(Trama trama)
    {
        if(buffer.isFull())
        {
            for(int i=0; i<2; i++)
            {
            Trama tmp = buffer.sacar();
                switch(tmp.getPuerto())
                {
                    case 1:
                    puerto1.meter(tmp);
                    break;
                    case 2:
                    puerto2.meter(tmp);
                    break;
                    case 3:
                    puerto3.meter(tmp);
                    break;
                    default:
                    System.out.println("Se recepcionó una trama hacia un puerto erróneo.");
                }
            }
        }
                    buffer.meter(trama);
    }
    
    public void mostrar()
    {
        System.out.println("# Puerto 1:");
        puerto1.mostrar();
        System.out.println("# Puerto 2:");
        puerto2.mostrar();
        System.out.println("# Puerto 3:");
        puerto3.mostrar();
        System.out.println("# Buffer de entrada:");
        buffer.mostrar();
    }
}


class Practica11e
{
    public static void main(String[] args)
    {
        InterfazRed interfaz = new InterfazRed();
        interfaz.recepcionar(new TramaTCP(calcularPuerto(), calcularPrioridad(),
        "Cont. Trama 1"));
        interfaz.recepcionar(new TramaUDP(calcularPuerto(), calcularPrioridad(),
        "Cont. Trama 2"));
        interfaz.recepcionar(new TramaTCP(calcularPuerto(), calcularPrioridad(),
        "Cont. Trama 3"));
        interfaz.recepcionar(new TramaUDP(calcularPuerto(), calcularPrioridad(),
        "Cont. Trama 4"));
        interfaz.recepcionar(new TramaTCP(calcularPuerto(), calcularPrioridad(),
        "Cont. Trama 5"));
        interfaz.mostrar();
        interfaz.recepcionar(new TramaUDP(calcularPuerto(), calcularPrioridad(),
        "Cont. Trama 6"));
    }
    
    public static int calcularPuerto()
    {
        return (int)Math.rint(Math.random() * 2) + 1;
    }
    
    public static int calcularPrioridad()
    {
        return (int)Math.rint(Math.random() * 9) + 1;
    }
}

