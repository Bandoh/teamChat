import mysock.*;
public class BootServer {
  public static void main(String[] args) {
    SockServer serv = new SockServer(23222);
    serv.begin();
  }
}
