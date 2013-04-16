package entradaysalida4;

import java.io.*;

public class EntradaYSalida4 {

    public static void main(String[] args) {
    char c;
    boolean finArchivo=false;
    RandomAccessFile archivo = null;
    
    try{
        archivo = new RandomAccessFile("prueba.txt", "rw");
        System.out.println("El tamaño es ; "  +archivo.length());
        do{
            try{
                c=(char)archivo.readByte();
                if ( c=='b'){
                    archivo.seek(archivo.getFilePointer()-1);
                    archivo.writeByte(Character.toUpperCase(c));
                }
            }catch (EOFException e){
                    finArchivo = true;
                    archivo.close();
                    System.out.println("Convertidas las b en mayusculas");
            }
        }while (!finArchivo);
        
    }catch ( FileNotFoundException e){
        System.out.println("No se encontro el archivo.");
    }catch (IOException e){
        System.out.println("Problemas con el archivo");
    }
    }
}
