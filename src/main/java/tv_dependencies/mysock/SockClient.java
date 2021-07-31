package mysock;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.*;
import java.util.*;
import threads.ClientListenerHandler;

public class SockClient{
    Socket sock;
    public SockClient(String host, int port){
        try {
            this.sock = new Socket(host,port);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void begin(){
        String c ="start";
        Scanner ip = new Scanner(System.in);
        
        try {
            DataOutputStream dout=new DataOutputStream(this.sock.getOutputStream());  
            Thread listenerThread = new ClientListenerHandler(new DataInputStream(this.sock.getInputStream()));

            listenerThread.start();


            System.out.println("Client Starting");
            while(!(c.equals("end"))){       
                c = ip.nextLine();   
                dout.writeUTF(c);  
                dout.flush(); 
            }                 
            dout.close();  
            this.sock.close();  
        } catch (Exception e) {
            System.out.println(e);  
            //TODO: handle exception
        }
    }
}