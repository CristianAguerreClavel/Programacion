package practica.pkg2;


class Asignatura 
{
    private int identificador;
    private double calificacion;
    
    public Asignatura (int identificador)
    {
        this.identificador = identificador;
    }
    
    public int getIdentificador()
    {
        return identificador;
    }
    
    public double getCalificacion()
    {
        return calificacion;
    }
    
    public void setCalificacion(double calificacion)
    {
        this.calificacion=calificacion;
    }
    
}

class Alumno 
{
    private Asignatura as1;
    private Asignatura as2;
    private Asignatura as3;
    
    public Alumno(Asignatura as1,Asignatura as2, Asignatura as3)
    {
        this.as1=as1;
        this.as2=as2;
        this.as3=as3;
    }
    
    public Alumno(int a, int b, int c)
    {
        as1 = new Asignatura(a);
        as2 = new Asignatura(b);
        as3 = new Asignatura(c);
    }
    
    public Asignatura getAs1()
    {
        return as1;
    }
    
    public Asignatura getAs2()
    {
        return as2;
    }
    
    public Asignatura getAs3()
    {
        return as3;
    }
}

class Profesor
{
    public void ponerNotas(Alumno alum)
    {
        alum.getAs1().setCalificacion(Math.random()*10+1);
        alum.getAs2().setCalificacion(Math.random()*10+1);
        alum.getAs3().setCalificacion(Math.random()*10+1);
    }
    
    public double calcularMedia(Alumno alum)
    {
        double as1=alum.getAs1().getCalificacion();
        double as2=alum.getAs2().getCalificacion();
        double as3=alum.getAs3().getCalificacion();
        double media =(as1+as2+as3)/3;
        return media;
    }
}


public class Practica2 {
    
    public static void main(String[] args) {
        
        Asignatura as1 = new Asignatura(1);
        Asignatura as2 = new Asignatura(2);
        Asignatura as3 = new Asignatura(3);
        
        Alumno alum1 = new Alumno(as1,as2,as3);
        
        Profesor prof1 = new Profesor();
        
        prof1.ponerNotas(alum1);
        double media = prof1.calcularMedia(alum1);
        System.out.printf("Media del alumno 1: %.2f\n",media);
        
    }
}
