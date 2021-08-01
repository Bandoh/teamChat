package mysock;
import java.net.*;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import threads.ClientHandler;
public class SockServer{
    ServerSocket sock;
    Socket client_list[]  = new Socket[20]; 
    private int count = 0;

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
                System.out.println(client_socket);
                DataInputStream client_inputStream = new DataInputStream(client_socket.getInputStream());
                Thread t1 = new ClientHandler(client_socket,client_inputStream,this.count);
    
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
              client_list[count] = s;
              this.count++;
              this.broadcast(ServerMessage.NEW_CLIENT);
             System.out.println("Accepted Connection "+ count);
             return s;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
            return s;
        }
    }


    private void broadcast(ServerMessage message){
        for(int i=0;i<=this.count;i++){          
            try {
                DataOutputStream client_outputStream = new DataOutputStream(this.client_list[i].getOutputStream());
                client_outputStream.writeUTF(message.name() );
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}



