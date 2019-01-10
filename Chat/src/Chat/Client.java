package Chat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class Client extends Application
{
    Date date = new Date();
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    // Text area to display from server
    TextArea ta = new TextArea();

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        //Panel paneForTextField to hold the label and text field
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setStyle("-fx-border-color: blue");
        paneForTextField.setLeft(new Label("Send Message: " ));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        // Set scene and show
        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Event handler for text field
        tf.setOnAction(e -> {
            try
            {
                //get the text from the text field
                String chat = tf.getText();
                // send the text to the server
                toServer.writeUTF(chat);
                toServer.flush();

                //display to text
                ta.appendText(date + "\nMessage: " + chat + '\n');
            }
            catch(IOException ex)
            {
                System.err.println(ex);
            }
        });

        try
        {
            //create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            //New socket("130.254.204.36",8000) IP ADDRESS; New Socket("drake.armstrong.edu", 8000) actual domain;

            //Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            //create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
//            new Thread(new Client.HandleAClient(socket)).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try
                    {
                        while(true)
                        {
                            String chat = fromServer.readUTF();

                            Platform.runLater(() ->{
                                ta.appendText("Message received from server: " + chat);
                            });
                        }
                    }
                    catch(IOException ex)
                    {
                        ex.printStackTrace();
                    }

                }
            }).start();

//
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}