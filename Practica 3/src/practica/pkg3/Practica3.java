package practica.pkg3;


class Motor 
{
    private int litrosAceite;
    private int cv;
    
    public Motor (int cv)
    {
        this.cv=cv;
        litrosAceite=0;
    }
    
    public int getLitros()
    {
        return litrosAceite;
    }
    
    public int getCv()
    {
        return cv;
    }
    
    public void setLitros(int litros)//En el ejercicio no especifica que aya que pasarle ningun valor
    {
        litrosAceite += litros;
    }
    
}

class Coche 
{
    private Motor motor;
    private String marca, modelo;
    private double precioAcumulado;
    
    public Coche(String marca, String modelo)
    {
        this.marca= marca;
        this.modelo=modelo;
    }
    
    public Motor getMotor()
    {
        return motor;
    }
    
    public String getMarca()
    {
        return marca;
    }
    
    public String getModelo()
    {
        return modelo;
    }
    
    public double getPrecio()
    {
        return precioAcumulado;
    }
    
    public void setMotor(Motor motor)
    {
        this.motor=motor;
    }
    
    public void acumularAverias (double preAveria)
    {
        precioAcumulado += preAveria;
    }
    
    public String toString(){
        return "Motor: "+getMotor().getCv()+" Cv "+" Marca: "+getMarca()+ " Modelo: "+getModelo()+" Precio acumulado: "+getPrecio();
    }
}

class Garaje
{
    Coche coche;
    String averia;
    int numeroCoches;
    boolean libre=true;
    
    public void aceptarCoche(Coche coche, String averia)
    {
        if (libre==true)
        {
             System.out.println("Coche aceptado");
             libre = false;
                if (averia=="Aceite")
                {
                   coche.getMotor().setLitros(10);
                }
             coche.acumularAverias(Math.random()*1000+50);
        }
        else
            System.out.println("Coche no aceptado");
    }
    
    public void devolverCoche()
    {
        libre=true;
        System.out.println("Garaje libre");
    }
}


public class Practica3 {

    public static void main(String[] args) {
        
        Garaje gar1 = new Garaje();
        Coche coche1 = new Coche("SEAT","IBIZA");
        Coche coche2 = new Coche("FORD","FOCUS");
        Motor motor1 = new Motor(25);
        coche1.setMotor(motor1);
        coche2.setMotor(motor1);
        gar1.aceptarCoche(coche1,"PilotoTrasero");
        gar1.devolverCoche();
        gar1.aceptarCoche(coche2,"Aceite");
        gar1.devolverCoche();
        gar1.aceptarCoche(coche1,"RuedaDerecha");
        gar1.devolverCoche();
        gar1.aceptarCoche(coche2,"Retrovisor");
        
        System.out.println(coche1.toString());
        System.out.println(coche2.toString());
    }
}
