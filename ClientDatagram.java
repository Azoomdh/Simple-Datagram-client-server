
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class ClientDatagram{
    private InetAddress diaChiServer;
    private int portServer;

    private InetAddress diaChiClient;
    private int portClient;

    private DatagramSocket clienDatagramSocket;

    public ClientDatagram(InetAddress diaChiServer, int portServer, InetAddress diaChiClient, int portClient) throws SocketException, UnknownHostException {
        this.diaChiServer= diaChiServer;
        this.portServer = portServer;

        this.diaChiClient= diaChiClient;
        this.portClient = portClient;
        
        this.clienDatagramSocket = new DatagramSocket(portClient);
    }
    // setter and getter
        public DatagramSocket getClienDatagramSocket() {
            return clienDatagramSocket;
        }
        public void setClienDatagramSocket(DatagramSocket clienDatagramSocket) {
            this.clienDatagramSocket = clienDatagramSocket;
        }
        public InetAddress getDiaChiServer() {
            return diaChiServer;
        }
        public void setDiaChiServer(InetAddress diaChiServer) {
            this.diaChiServer = diaChiServer;
        }
        public int getPortServer() {
            return portServer;
        }
        public void setPortServer(int portServer) {
            this.portServer = portServer;
        }
    //
    public void guiTinNhan() throws IOException{
        Scanner sc1= new Scanner(System.in);
        String str1= sc1.nextLine();

        byte[] byteGui = str1.getBytes();
        DatagramPacket datagramGui= new DatagramPacket(byteGui, byteGui.length, diaChiServer, portServer);
        
        clienDatagramSocket.send(datagramGui);
        
        System.out.println("you sent : "+ str1);

        // sc1.close();
    }
    public void nhanTinNhan() throws IOException{
        byte[] byteNhan= new byte[1024];
        DatagramPacket datagramNhan= new DatagramPacket(byteNhan, byteNhan.length);

        clienDatagramSocket.receive(datagramNhan);
        String str2= new String( datagramNhan.getData() );
        
        System.out.println("server said : "+ str2);
        
        this.diaChiServer= datagramNhan.getAddress();
        this.portServer= datagramNhan.getPort();
    }
}
