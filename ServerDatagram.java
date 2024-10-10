import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class ServerDatagram {
    private InetAddress diaChiServer;
    private int portServer;

    private InetAddress diaChiClient;
    private int portClient;

    private DatagramSocket serverDatagramSocket;

    public ServerDatagram(InetAddress diaChiServer, int portServer, InetAddress diaChiClient, int portClient) throws SocketException, UnknownHostException{
        this.diaChiServer= diaChiServer;
        this.portServer= portServer;
        
        this.diaChiClient = diaChiClient;
        this.portClient= portClient;
        
        this.serverDatagramSocket= new DatagramSocket(portServer);
    }
    // getter and setter
        public int getPortServer() {
            return portServer;
        }
        public void setPortServer(int portServer) {
            this.portServer = portServer;
        }
        public int getPortClient() {
            return portClient;
        }
        public void setPortClient(int portClient) {
            this.portClient = portClient;
        }
        public DatagramSocket getServerDatagramSocket() {
            return serverDatagramSocket;
        }
        public void setServerDatagramSocket(DatagramSocket serverDatagramSocket) {
            this.serverDatagramSocket = serverDatagramSocket;
        }
        public InetAddress getDiaChiClient() {
            return diaChiClient;
        }
        public void setDiaChiClient(InetAddress diaChiClient) {
            this.diaChiClient = diaChiClient;
        }
    //

    public void guiTinNhan() throws IOException{
        Scanner sc1= new Scanner(System.in);
        String str1= sc1.nextLine();

        byte[] byteGui= str1.getBytes();
        DatagramPacket datagramGui= new DatagramPacket(byteGui, byteGui.length, diaChiClient, portClient);

        serverDatagramSocket.send(datagramGui);
        System.out.println("ban da gui : "+ str1);
        
        //sc1.close();
    }

    public void nhanTinNhan() throws IOException{
        byte[] byteNhan= new byte[1024];
        DatagramPacket datagramNhan = new DatagramPacket(byteNhan, byteNhan.length);

        serverDatagramSocket.receive(datagramNhan);
        String str2= new String(datagramNhan.getData() );

        System.out.println("Client da gui : "+ str2);

        this.diaChiClient= datagramNhan.getAddress();
        this.portClient= datagramNhan.getPort();
    }
}

/*code nguyen khoi

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class ServerDatagram {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverDatagramSocket1= new DatagramSocket(9876);
        while (true) {
            byte[] byteNhan= new byte[1024];
            DatagramPacket goiDatagramNhan1= new DatagramPacket(byteNhan, byteNhan.length);
            serverDatagramSocket1.receive(goiDatagramNhan1);
            String str1= goiDatagramNhan1.getData().toString();
            System.out.println("client da gui : "+ str1);

            InetAddress diaChiNguoiGui1= goiDatagramNhan1.getAddress();
            int portNguoiGui1= goiDatagramNhan1.getPort();

            Scanner sc1= new Scanner(System.in);
            String str2= sc1.nextLine();
            byte[] byteGui= new byte[1024];
            byteGui= str2.getBytes();
            DatagramPacket goiDatagramGui1 = new DatagramPacket(byteGui, byteGui.length, diaChiNguoiGui1, portNguoiGui1);
            serverDatagramSocket1.send(goiDatagramGui1);
        }
    }
}
*/