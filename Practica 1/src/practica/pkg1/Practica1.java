package practica.pkg1;


class Punto{
    
    private double x,y;
    
    public Punto(double x, double y) 
    {
        this.x=x;
        this.y=y;
    }
    
    public Punto()
    {
        x=2.1;
        y=4.1;
    }
    
    public double getx()
    {
        return x;
    }
    
    public double gety()
    {
        return y;
    }
    
    public double calcularDistancia (Punto a)
    {
       double DiffX = x-a.getx();
       double DiffY = y-a.gety();
       
       return Math.sqrt((DiffX*DiffX) + (DiffY*DiffY));
    }
    
}

class Circulo {
    
    Punto a;
    double b;
    double PI = 3.1416;
    
    Circulo (Punto a, double b)
    {
        this.a=a;
        this.b=b;
    }
    
    Circulo ()
    {
        a = new Punto();
        b = 2.5;
    }
    
    Circulo (double a, double b, double c)
    {
        this.a= new Punto (a,b);
        b=c;
    }
    
    public Punto geta()
    {
        return a;
    }
    
    public double getb()
    {
        return b;
    }
    
    //NO ENTIENDO QUE QUIERE DECIR EL EJERCICIO F
    
    public double calculoArea()
    {
        double Area = PI * (b*b);
        return Area;
    }
    
    public double calcularPerimetro()
    {
        double perimetro = 2 * PI * b;
        return perimetro;
    }
}

class Triangulo{
    
    private Punto a;
    private Punto b;
    private Punto c;
    
    public Triangulo(Punto a, Punto b, Punto c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    public Triangulo()
    {
        a= new Punto (1,2);
        b= new Punto (0,0);
        c= new Punto (3,4);
    }
    
    public Triangulo (double a, double b, double c, double d, double e, double f)
    {
        this.a= new Punto (a,b);
        this.b= new Punto (c,d);
        this.c= new Punto (e,f);
    }
    
    public Punto geta()
    {
        return a;
    }
    
    public Punto getb()
    {
        return b;
    }
    
    public Punto getc()
    {
        return c;
    }
    
    public double calcularDistancia(Punto b)
    {
        double distancia = a.calcularDistancia(b);
        return distancia;
    }
    
    public double calcularArea ()
    {
        double base = a.calcularDistancia(b);
        double basepartido2 = base/2;
        double hipotenusa = a.calcularDistancia(c);
        double altura = Math.sqrt((hipotenusa*hipotenusa)-(basepartido2*basepartido2));
        double Area = (base*altura) /2;
        return Area;
    }
    
    public double calcularPerimetro ()
    {
        double perimetro = (a.calcularDistancia(b)+b.calcularDistancia(c))+c.calcularDistancia(a);
        return perimetro;
    }
    
}

public class Practica1 {
    
    public static void main(String[] args) {
        
        Punto p1 = new Punto(1,10);
        Punto p2 = new Punto(15,10);
        System.out.println("Calculo de la distancia entre 2 puntos");
        System.out.println(p1.calcularDistancia(p2));
        System.out.println("---------------------------------------------------");
        
        Circulo c1 = new Circulo(p2,5);
        System.out.println("Perimetro del criculo");
        System.out.println(c1.calcularPerimetro());
        System.out.println("Distancia a otro punto");
        System.out.println(c1.geta().calcularDistancia(p2));
        System.out.println("---------------------------------------------------");
        
        Triangulo t1 = new Triangulo();
        System.out.println("Area = "+t1.calcularArea());
        System.out.println("Perimetro = "+t1.calcularPerimetro());
        System.out.println(t1.calcularArea());
        Punto p3 = new Punto(5.4,98.5);
        System.out.println("Distancia al nuevo punto: "+ t1.geta().calcularDistancia(p3));
        
    }
}
