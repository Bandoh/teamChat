package mysock;
import java.net.Socket;

public class GlobalValues{


    private static String serverMessage  = "";
    private static Socket sockId = null;

    private static String oldServerMessage = serverMessage;
    private static Socket oldSockId = sockId;



    public static String getServerMessage(){return serverMessage;}
    public static void setServerMessage(String s ){oldServerMessage = serverMessage;serverMessage = s;}

    public static Socket getSocket(){return sockId;}
    public static void setSocket(Socket s){oldSockId = sockId;sockId = s;}


    public static Boolean onServerMessageChange(){
        Boolean isChanged = false;
        while(true){
            if((oldServerMessage!=serverMessage)&& (oldSockId!=sockId)){
                isChanged = true;
            }
            else isChanged = false;
        }
    }
}