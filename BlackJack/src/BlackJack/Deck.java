package BlackJack;

import BlackJack.Card.Rank;
import BlackJack.Card.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    // Create a new card object that holds the cards in an array
    private Card[] cards = new Card[52];
    ArrayList deck = new ArrayList<>();

    // default deck constructor

    public Deck()
    {
        refillDeck();
    }

    // Refills the array using a an embedded foreach loop inside a foreach loop.
    public void refillDeck()
    {
        int i = 0;

        for (Suit suit : Suit.values())
        {
            for (Rank rank : Rank.values())
            {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    // A Function to shuffle array
    public void shuffleDeck()
    {
        deck.add(cards);
        Collections.shuffle(deck);
    }

    public Card drawCard()
    {
        Card card = null;
        // While loop that will execute until there are no more cards
        while (card == null)
        {
            // random number that is the length of the cards
            int i = (int)(Math.random()*cards.length);
            // load int i into cards
            card = cards[i];
            cards[i] = null;
        }
        // return card
        return card;
    }
}
