import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

/*use a function as a thread
 * https://www.codejava.net/java-core/the-java-language/java-8-lambda-runnable-example 
*/

public class RunServerDatagram {
    public static void main(String[] args) throws IOException {
        InetAddress diachiServer= InetAddress.getByName("localhost");
        int portServer= 1234;

        InetAddress diachiClient= InetAddress.getByName("localhost");
        int portClient= 5678;
        ServerDatagram serverDatagram1= new ServerDatagram(diachiServer, portServer, diachiClient, portClient);



        while(true){
            serverDatagram1.nhanTinNhan();
            serverDatagram1.guiTinNhan();
        }
    }
}
