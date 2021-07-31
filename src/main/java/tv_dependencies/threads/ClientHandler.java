package threads;
import java.net.*;
import java.io.*;
public class ClientHandler extends Thread{
    Socket s;
    DataInputStream dis;
    private int id;

    public ClientHandler(Socket s, DataInputStream dis,int count){
        this.s = s;
        this.dis = dis;
        this.id = count;
    }


    public void run(){
        String str = "";
        while(true){
            try {  
            str= this.dis.readUTF(); 
            System.out.println(this.id+" says: "+str); 
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