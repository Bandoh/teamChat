import mysock.SockClient;
public class Cl{
    public static void main(String[] args) {
        SockClient s = new SockClient("localhost",23222);
        s.begin();
    }
}