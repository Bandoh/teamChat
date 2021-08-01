import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import mysock.SockClient;

public class TeamVoice extends Application {
    private int port = 23222;
    private String host = "localhost";
    @Override
    public void start(Stage stage) throws java.io.IOException {
    
        String prin = "#1f0424";
        String sec = "#61ffb3";
        Parent root = FXMLLoader.load(getClass().getResource("TeamVoice.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("TeamVoice");
        stage.setScene(scene);
        stage.show();
        SockClient s = new SockClient(this.host,this.port);
        Runnable r = ()->{
            
            s.begin();
        };
        Thread t1  =new Thread(r);
        t1.start();
    }

    public static void main(String[] args) {
        launch();
    }

}