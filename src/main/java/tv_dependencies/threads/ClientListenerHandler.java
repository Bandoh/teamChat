package threads;
import java.io.DataInputStream;
import mysock.ServerMessage;
import clientactions.*;
import java.net.Socket;

public class ClientListenerHandler extends Thread{
    private DataInputStream inp;
    private Socket s;

    public ClientListenerHandler(Socket s,DataInputStream inp){
        this.s = s;
        this.inp = inp;
    }


    public void run(){
        String str = "";
        while(true){
            try {  
            str= this.inp.readUTF(); 
            ServerMessage s = this.getEnumByString(str);

            switch (s) {
                case NEW_CLIENT:
                    new NewClient(this.s).performAction();
                    break;           
                default:
                    break;
            }



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



    private ServerMessage getEnumByString(String s){
        for(ServerMessage e : ServerMessage.values()){
            if(e.name().equals(s)) return e;
        }       
        return null;
    }
}