package clientactions;
import mysock.GlobalValues;
import java.net.Socket;

public class NewClient implements ClientAction{
    private Socket s ;

    public NewClient(Socket s){
        this.s = s;
    }


    public void performAction(){
        GlobalValues.setServerMessage("NewClient");
        GlobalValues.setSocket(this.s);
        System.out.println("In New Client");
    }
}