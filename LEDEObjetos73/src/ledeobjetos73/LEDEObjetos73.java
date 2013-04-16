
package ledeobjetos73;

import java.io.*;

public class LEDEObjetos73 {

    public static void main(String[] args) {
        byte[] byteArr1 = {0,1,2,3,4,5,6,7,8,9};
        byte[] byteArr2 = {10,20,30,40,50,60,80,80,80,100};
        ByteArrayInputStream flujoArrByte1 = new ByteArrayInputStream(byteArr1);
        ByteArrayInputStream flujoArrByte2 = new ByteArrayInputStream(byteArr2);
        SequenceInputStream flujoSec = new SequenceInputStream(flujoArrByte1,flujoArrByte2);//Anida dos flujos uno a continuacion del otro
        
        try
        {
            byte b=0;
            while ( (b = (byte)flujoSec.read()) != -1)
            {
                System.out.println(b);
            }
            flujoArrByte1.close();
            flujoArrByte2.close();
            flujoSec.close();
        }
        catch(IOException ioE)
        {
            System.out.println(ioE.toString());
        }
            
        
    }
}
