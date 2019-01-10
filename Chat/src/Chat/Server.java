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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class Server extends Application
{
    //Text area for displaying contents
    private TextArea ta = new TextArea();
    private TextField tf = new TextField();
    //Array List to store sockets
    ArrayList<Socket> sockets = new ArrayList<>();
    // Number a client
    private int clientNo = 0;

    @Override
    public void start(Stage primaryStage) {
        //Text Area for displaying contents
        //Panel paneForTextField to hold the label and text field
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setStyle("-fx-border-color: blue");
        paneForTextField.setLeft(new Label("Send Message: " ));
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        //text area to display output from server
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        //Create our scene
        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Multi Thread Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        tf.setOnAction(e -> {

            try
            {
                for(Socket socket : sockets)
                {
                    // Data output stream that gets the output stream from socket
                    DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
                    System.out.println("Send message to client");

                    toClient.writeUTF(tf.getText() + '\n');
                    toClient.flush();


                }
                //get the text from the text field
                String chat = tf.getText();

                //display text
                ta.appendText(new Date() + "\nMessage: " + chat + '\n');

            }
            catch(IOException ex)
            {
                System.err.println(ex);
            }
        });

        new Thread(() ->{
            try
            {
                //Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("MultiThreadServer started at " + new Date() + '\n');

                while(true)
                {
                    Socket socket = serverSocket.accept();

                    // Increment clientNo
                    clientNo++;

                    Platform.runLater(()->{
                        // Display the client number
                        ta.appendText("Starting thread for client " + clientNo + " at " + new Date() + '\n');

                        // Find the client's host name and IP address
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "'s host name is " + inetAddress.getHostName() + '\n');

                        ta.appendText("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + '\n');

                        sockets.add(socket);
                    });// end of runlater

                    //Create and start a new thread for the connection
                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch(IOException ex)
            {
                System.err.println(ex);
            }
        }).start();
    }

    class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Create data input and output stream
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                //Continuously serve the client
                while (true) {
                    //Receive chat from client
                    String chat = inputFromClient.readUTF();

                    Platform.runLater(() -> {
                        ta.appendText("Chat received from client: " + chat + '\n');
                    });

                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
