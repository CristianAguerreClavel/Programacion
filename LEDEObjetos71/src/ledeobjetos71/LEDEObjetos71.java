
package ledeobjetos71;

import java.io.*;

public class LEDEObjetos71 {

    public static void main(String[] args) {
        byte[] byteArr1 = {0,1,2,3,4,5,6,7,8,9};
        ByteArrayInputStream flujoArrByte1 = new ByteArrayInputStream(byteArr1);
        
        try
        {
            while (flujoArrByte1.available() !=0)
            {
                byte leido = (byte) flujoArrByte1.read();
                System.out.print(leido+", ");
                flujoArrByte1.skip(1);//Ejercicio siguiente
            }
            flujoArrByte1.close();
        } catch(IOException e)
        {
            System.out.println("Error al realizar la operacion");
        }
    }
}
