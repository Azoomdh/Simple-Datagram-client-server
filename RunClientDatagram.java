import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class RunClientDatagram {
    public static void main(String[] args) throws IOException {
        InetAddress diachiServer= InetAddress.getByName("localhost");
        int portServer= 1234;

        InetAddress diaChiClient= InetAddress.getByName("localhost");
        int portClient= 5678;
        
        ClientDatagram clientDatagram1= new ClientDatagram(diachiServer, portServer, diaChiClient, portClient);

        while(true){
            clientDatagram1.guiTinNhan();
            clientDatagram1.nhanTinNhan();
        }
    }
}
