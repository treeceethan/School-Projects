package BlackJack;

import BlackJack.Card.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Hand {
    // global variables to the hand class
    private ObservableList<Node> cards;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    private int aces = 0;

    // set cards equal to cards
    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public void takeCard(Card card) {
        cards.add(card);

        // increment aces if rank is ace
        if (card.rank == Rank.ACE) {
            aces++;
        }

        if (value.get() + card.value > 21 && aces > 0) {
            // count ace value as 1 not 11
            value.set(value.get() + card.value - 10);
            aces--;
        }
        else{
            value.set(value.get() + card.value);
        }
    }
    // resets the cards back to default
    public void resetCards()
    {
        cards.clear();
        value.set(0);
        aces = 0;
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}