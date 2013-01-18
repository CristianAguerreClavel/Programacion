
package p173;
enum Formato{wav,mp3,midi,avi,mov,mpg,cdAudio,dvd}
enum Genero{rock,pop,soul,funky,tecno,bso,flamenco}
class Multimedia{
    private String titulo;
    private String autor;
    private Formato formato;
    private double duracion;
    
    public Multimedia(String titulo,String autor,Formato formato, double duracion){
        this.autor=autor;
        this.duracion=duracion;
        this.formato=formato;
        this.titulo=titulo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public Formato getFormato(){
        return formato;
    }
    
    public double getDuracion(){
        return duracion;
    }
    
    public String toString(){
        return "Titulo: "+titulo+" de "+autor+"\n"+"Formato: "+formato+" Duracion:" +duracion;
    }
    
    public boolean equals(Multimedia m){
        return titulo.equals(m.titulo)&& autor.equals(m.autor);
    }
}
class Pelicula extends Multimedia{
    private String actorPrincipal;
    private String actrizPrincipal;
    public Pelicula(String titulo,String autor,Formato formato, double duracion,String actor,String actriz){
        super(titulo,autor,formato,duracion);
        if(actor==null&&actriz==null)
            throw new IllegalArgumentException("Debe haber al menos un protagonista");   
        actorPrincipal=actor;
        actrizPrincipal=actriz;
    }
    
    public String getActor(){
        return actorPrincipal;
    }
    
    public String getActriz(){
        return actrizPrincipal;
    }
    
    public String toString(){
        String s="Protagonizado por: ";
        if(actrizPrincipal!=null){
            s+=actrizPrincipal;
            if(actorPrincipal!=null)
                s+=" y "+actorPrincipal;
        }
        else{
            assert actorPrincipal!=null;
            s+=actorPrincipal;
        }
        return super.toString()+"\n"+s;
            
    }
    
    
}

class ListaMultimedia{
    private Multimedia[] lista;
    private int contador;
    
    ListaMultimedia(int tamaño){
        lista=new Multimedia[tamaño];
        contador=0;
    }
    
    public int size(){
        return contador;
    }
    
    private boolean llena(){
        return contador==lista.length;
    }
    
    public boolean add(Multimedia m){
        if(llena())
            return false;
        else{
            lista[contador]=m;
            contador++;
            return true;
        }
    }
    
    public Multimedia get(int posicion){
        if(posicion<0||posicion>contador)
            throw new IndexOutOfBoundsException();
        return lista[posicion];
    }
    
    public int IndexOf(Multimedia m){
        for(int i=0;i<contador;i++)
            if(m.equals(lista[i]))
                return i;
        return -1;
    }
    public String toString(){
        String s="";
        for(int i=0;i<contador;i++)
            s+=lista[i].toString()+"\n\n";
        return s;
    }
}

class Disco extends Multimedia{
    private Genero genero;
    public Disco(String titulo,String autor,Formato formato, double duracion,Genero genero){
        super(titulo,autor,formato,duracion);
        this.genero=genero;
    }
    
    public Genero getGenero(){
        return genero;
    }
    
    public String toString(){
        String s;
        s="Genero: "+genero;
        return super.toString()+"\n"+s;
    }
}
public class P173 {

    public static void main(String[] args) {
        ListaMultimedia lista=new ListaMultimedia(10);
        int posicion;
        lista.add(new Pelicula("Milion Dolar Baby","Clint Eastwood",Formato.dvd,137
                ,"Clint Eastwood","Hillary Swank"));
        lista.add(new Pelicula("El aviador","Martin Scorsese",Formato.dvd,168
                ,"Leonardo Di Caprio",null));
        lista.add(new Pelicula("Mar adentro","Alejandro Amenabar",Formato.avi,125
                ,"Javier Bardem","Belen Rueda"));
        
        System.out.println(lista.toString());
        Pelicula peli=new Pelicula("Mar adentro","Alejandro Amenabar",null,0,"","");
        posicion=lista.IndexOf(peli);
        System.out.println("Posicion "+posicion+"\n"+lista.get(posicion));
        
        lista.add(new Disco("Hopes and Fears","Keane",Formato.mp3,45,Genero.pop));
        lista.add(new Disco("How to dismantle an atomic bomb","u2",Formato.cdAudio,49,Genero.rock));
        lista.add(new Disco("Soy gitano","Camaron",Formato.cdAudio,32,Genero.flamenco));
        System.out.println(lista.toString());
        Disco disco=new Disco("Soy gitano","Camaron",null,0,null);
        posicion=lista.IndexOf(disco);
        System.out.println("Posicion "+posicion+"\n"+lista.get(posicion));
    }
}
