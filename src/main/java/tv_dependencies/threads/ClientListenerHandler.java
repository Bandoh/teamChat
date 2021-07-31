package threads;
import java.io.DataInputStream;

public class ClientListenerHandler extends Thread{
    private DataInputStream inp;

    public ClientListenerHandler(DataInputStream inp){
        this.inp = inp;
    }


    public void run(){
        String str = "";
        while(true){
            try {  
            str= this.inp.readUTF(); 
            System.out.println("Server: "+str); 
            } catch (Exception e) {
                //TODO: handle exception
                try {
                    // this.s.close();
                } catch (Exception er) {
                    //TODO: handle exception
                    System.out.println(er);
                }
                System.out.println(e);
            }
        }
    }
}