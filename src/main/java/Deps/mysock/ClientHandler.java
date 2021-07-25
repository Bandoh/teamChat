package mysock;
import java.net.*;
import java.io.*;
public class ClientHandler extends Thread{
    Socket s;
    DataInputStream dis;

    public ClientHandler(Socket s, DataInputStream dis){
        this.s = s;
        this.dis = dis;
    }


    public void run(){
        String str = "";
        while(true){
            try {  
            str= this.dis.readUTF(); 
            System.out.println("message = "+str); 
            } catch (Exception e) {
                //TODO: handle exception
                try {
                    this.s.close();
                } catch (Exception er) {
                    //TODO: handle exception
                    System.out.println(er);
                }
                System.out.println(e);
            }
        }
    }

}