package ejercicioherencia59;

enum Formato {wav,mp3,midi,avi,mov,mpg,cdAudio,dvd}

class Multimedia {

    private String titulo;
    private String autor;
    private Formato formato;
    private double duracion;
    
    public Multimedia(String titulo, String autor, Formato formato, double duracion){
        this.titulo = titulo;
        this.autor=autor;
        this.formato=formato;
        this.duracion=duracion;
        
    }
    
    
    
}





public class EjercicioHerencia59 {
    
    public static void main(String[] args) {
        
    }
}
