
package trabajandoconcomparableycomparator;

import java.util.*;

class Persona implements Comparable<Persona>
{
    int idPersona;
    String Nombre;
    
    public Persona()
    {
        
    }
    
    public Persona (int a)
    {
        idPersona = a;
    }
    
    public Persona(int a, String b)
    {
        idPersona = a;
        Nombre = b;
    }
    
    public void setIdPersona ( int a)
    {
        idPersona = a;
    }
    
    public int getIdPersona ()
    {
        return idPersona;
    }
    
    public int compareTo(Persona per)
    {
        
        if (idPersona == per.idPersona)
            return 0;
        if (idPersona < per.idPersona)
            return -1;
        else 
            return 1;
    }
    
    public String toString()
    {
        String Texto = ("idPersona: "+idPersona+"nombre"+Nombre);
        return Texto;
    }
}






class compararPorNombre implements Comparator<Persona>
{
    @Override
    public int compare(Persona t, Persona t1) 
    {
        return t.Nombre.compareTo(t1.Nombre);
    }
}


public class TrabajandoConComparableYComparator {

    

    public static void main(String[] args) {
    
        Persona p1 = new Persona (2,"Sergio");
        Persona p2 = new Persona (1,"Nerea");
        Persona p3 = new Persona (3,"Cristian");
        
        Persona[] persona = new Persona[3];
        persona[0]=p1;
        persona[1]=p2;
        persona[2]=p3;
        
        Arrays.sort(persona);
        
        for ( int i = 0; i<persona.length;i++)
            System.out.println(persona[i]);
        
        System.out.println("--------------------------");
        
        Arrays.sort(persona,new compararPorNombre());
        
        for ( int i = 0; i<persona.length;i++)
            System.out.println(persona[i]);
        System.out.println("--------------------------");
        
        ArrayList per1 = new ArrayList();
        per1.add(p3);
        per1.add(p2);
        per1.add(p1);
        
        Collections.sort(per1, new compararPorNombre());
        
        Iterator it = per1.iterator();
        
        while (it.hasNext())
            System.out.println(it.next());
        
    }
}
