package BlackJack;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application
{
    // Global variables for deck, dealer, player and a message to display winner
    private Deck deck = new Deck();
    private Hand dealer, player;
    private Text message = new Text();

    // boolean play set to false default
    private SimpleBooleanProperty play = new SimpleBooleanProperty(false);

    // create hbox that holds the player and dealer cards
    private HBox playerCards = new HBox(15);
    private HBox dealerCards = new HBox(15);



    private Parent createGame() {

        dealer = new Hand(dealerCards.getChildren());
        player = new Hand(playerCards.getChildren());

        message.setText("Welcome to the Black Jack table!");
        // create pane and set the size
        Pane pane = new Pane();
        pane.setPrefSize(800, 600);


        // Create an HBox
        HBox layout = new HBox(5);
        layout.setPadding(new Insets(5, 5, 5, 5));

        Rectangle leftBG = new Rectangle(550, 560);
        leftBG.setArcWidth(50);
        leftBG.setArcHeight(50);
        leftBG.setFill(Color.DARKGREEN);


        Rectangle rightBG = new Rectangle(230, 560);
        rightBG.setArcWidth(50);
        rightBG.setArcHeight(50);
        rightBG.setFill(Color.DARKSLATEGREY);


        // top vbox to display game
        VBox topVBox = new VBox(50);
        topVBox.setAlignment(Pos.TOP_CENTER);

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Player: ");

        topVBox.getChildren().addAll(dealerScore, dealerCards, message, playerCards, playerScore);

        // Create a vbox for the bottom to store buttons
        VBox buttonVBox = new VBox(20);
        buttonVBox.setAlignment(Pos.CENTER);

        // create buttons
        Button btnPlay = new Button("PLAY");
        Button btnShuffle = new Button("SHUFFLE");
        Button btnHit = new Button("HIT");
        Button btnStand = new Button("STAND");


        // Create hbox for the buttons
        HBox buttonsHBox = new HBox(15, btnHit, btnStand);
        buttonsHBox.setAlignment(Pos.CENTER);


        buttonVBox.getChildren().addAll(btnShuffle, btnPlay,  buttonsHBox);



        layout.getChildren().addAll(new StackPane(leftBG, topVBox), new StackPane(rightBG, buttonVBox));
        pane.getChildren().addAll(layout);


        btnPlay.disableProperty().bind(play);
        btnHit.disableProperty().bind(play.not());
        btnStand.disableProperty().bind(play.not());


        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
        dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.valueProperty().asString()));


        // Listener that sees if the init value of the hand is greater than or equal to 21
        player.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                getWinner();
            }
        });


        // Listener that sees if the init value of the hand is greater than or equal to 21
        dealer.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                getWinner();
            }
        });


        // Shuffles deck and starts a new game
        btnShuffle.setOnAction(event -> {
            deck.shuffleDeck();
            startNewGame();
            message.setText("Shuffled! Good Luck!");
        });


        // Starts a new game
        btnPlay.setOnAction(event -> {
            startNewGame();
        });


        // draws another card
        btnHit.setOnAction(event -> {
            player.takeCard(deck.drawCard());
        });


        // stands on your hand
        btnStand.setOnAction(event -> {
            while (dealer.valueProperty().get() < 17) {
                dealer.takeCard(deck.drawCard());
            }

            //checks to see if winner each time it's pressed
            getWinner();
        });


        return pane;
    }

    //Starts a new game
    private void startNewGame()
    {
        play.set(true);
        message.setText("Good Luck!");


        // Refills deck
        deck.refillDeck();


        // resets the cards
        dealer.resetCards();
        player.resetCards();


        // takes 2 each at the start of the game
        dealer.takeCard(deck.drawCard());
        dealer.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
    }

    // Gets the winner of the game
    private void getWinner() {

        play.set(false);

        int dealerValue = dealer.valueProperty().get();
        int playerValue = player.valueProperty().get();
        String winner = "Exceptional case: d: " + dealerValue + " p: " + playerValue;

        // Checks to see if dealer won hand
        if (dealerValue == 21 || playerValue > 21 || dealerValue == playerValue
                || (dealerValue < 21 && dealerValue > playerValue))
        {
            winner = "DEALER WON!";
        }


        // If dealer didn't win player wins
        else if (playerValue == 21 || dealerValue > 21 || playerValue > dealerValue)
        {
            winner = "PLAYER WON!";
        }


        // displays text of the winner
        message.setText(winner);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Set the scene and show
        Scene scene = new Scene(createGame());
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Black-Jack Game");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
