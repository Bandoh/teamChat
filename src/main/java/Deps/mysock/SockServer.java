package mysock;
import java.net.*;
import java.io.*;
public class SockServer{
    ServerSocket sock;

    public SockServer(int port){
        try{
            this.sock = new ServerSocket(port);
        }
        catch(Exception e){
            System.out.println(e);

        }

    }
    public void begin(){
        while (true){
            try {
                System.out.println("Server Starting");      
                Socket client_socket = acceptConn();
                DataInputStream client_inputStream = new DataInputStream(client_socket.getInputStream());
                Thread t1 = new ClientHandler(client_socket,client_inputStream);
    
                t1.start();
            } catch (Exception e) {
        //TODO: handle exception
                }
        }
    
    }
    private Socket acceptConn(){
        Socket s = new Socket();
        System.out.println("Awaiting Connection");
        try {
              s = this.sock.accept();
             System.out.println("Accepted Connection");
             return s;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
            return s;
        }
    }

}



