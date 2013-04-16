package ejercicio86;

interface Prestable
{
    public void prestar();
    public void devolver();
    public boolean prestado();
}

class Publicaciones
{
    int codigo;
    int año;
    String titulo;
    
    public Publicaciones(int codigo, int año, String titulo)
    {
        this.codigo = codigo;
        this.año = año;
        this.titulo = titulo;
    }
    
    public int getAño()
    {
        return año;
    }
    
    public int getCodigo()
    {
        return codigo;
    }
    
    public String toString()
    {
        String texto= ("Año: "+año+" Codigo: "+ codigo + " Titulo: "+ titulo);
        return texto;
    }
}


class Libro extends Publicaciones implements Prestable
{
    boolean prestado;
    
    public Libro(int codigo, int año, String titulo)
    {
        super(codigo, año, titulo);
        prestado = false;
    }
    
    public String toString()
    {
        return super.toString() + " Prestado: "+prestado;
    }

    @Override
    public void prestar() {
        prestado = true;
    }

    @Override
    public void devolver() {
        prestado = false;
    }

    @Override
    public boolean prestado() {
        return prestado;
    }
}

class Revistas extends Publicaciones
{
    int numero;
    
    public Revistas (int codigo, int año, String titulo, int numero)
    {
        super(codigo, año,titulo);
        this.numero = numero;
    }
    
    public String toString()
    {
        return super.toString() + " Numero: "+numero;
    }
}


public class Ejercicio86 
{
    
    public static int cuentaPrestados(Object[] array)
    {
        int contador = 0;
        for (Object a: array)
        {
            if (a instanceof Prestable && ((Prestable)a).prestado())
            {
                contador++;
            }
        }
        return contador;
    }
    
    public static int publicacionesAnterioresA(Publicaciones[] array,int año)
    {
        int contador = 0;
        
        for (Publicaciones a : array)
        {
            if (a.getAño()<año)
            {
                contador++;
            }
        }
        return contador;
    }
    
    public static void main(String[] args) 
    {
        Publicaciones[] array=
                        {
                        new Libro(1,1980,"linki"),
                        new Libro(2,1880,"Nereida"),
                        new Revistas(1,1200,"odisea",2),
                        new Revistas(2,2345,"lima",3)
                        };
        
        Libro libro1 = (Libro)array[0];
        libro1.prestar();

        for ( Publicaciones a: array)
        {
            System.out.println(a);
        }
        System.out.println("titulo de los libros");
        for ( Publicaciones a: array)
        {
            
            if (a instanceof Libro)
                System.out.println(a);
        }
        System.out.println("titulo de las revistas");
        for ( Publicaciones a: array)
        {
            
            if (a instanceof Revistas)
                System.out.println(a);
        }
        System.out.println("Prestados");
        System.out.println(Ejercicio86.cuentaPrestados(array));
        
        System.out.println("Publicaciones anteriores a 1980");
        System.out.println(publicacionesAnterioresA(array,1980));
        
        
    }
}
