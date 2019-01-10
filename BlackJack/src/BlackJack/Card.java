package BlackJack;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Card extends Parent
{
    // Create enum suit constants
    enum Suit
    {
        CLUBS, HEARTS, SPADES, DIAMONDS
    }

    // Create enum rank constants
    enum Rank
    {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), KING(10), QUEEN(10), ACE(11);

        final int value;

        Rank(int value)
        {
            this.value = value;
        }
    }

    public final Suit suit;
    public final Rank rank;
    public final int value;

    // constructor that has a suit and a rank
    public Card(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;
        // set correct picture to the corresponding card based off rank/suit
        imageCard(suit, rank);
    }

    // Sets images to the specified suit & rank
    public Rectangle imageCard(Suit suit, Rank rank)
    {
        // create the actual card rectangle, card.setFill() puts the image into the rectangle
        Rectangle card = new Rectangle(80,100);

        // Sets club cards pictures
        if(suit == Suit.CLUBS && rank == Rank.ACE)
        {
            Image c1 = new Image("/images/c1.png");
            card.setFill(new ImagePattern(c1));
        }
        if(suit == Suit.CLUBS && rank == Rank.TWO)
        {
            Image c2 = new Image("/images/c2.png");
            card.setFill(new ImagePattern(c2));
        }
        if(suit == Suit.CLUBS && rank == Rank.THREE)
        {
            Image c3 = new Image("/images/c3.png");
            card.setFill(new ImagePattern(c3));
        }
        if(suit == Suit.CLUBS && rank == Rank.FOUR)
        {
            Image c4 = new Image("/images/c4.png");
            card.setFill(new ImagePattern(c4));
        }
        if(suit == Suit.CLUBS && rank == Rank.FIVE)
        {
            Image c5 = new Image("/images/c5.png");
            card.setFill(new ImagePattern(c5));
        }
        if(suit == Suit.CLUBS && rank == Rank.SIX)
        {
            Image c6= new Image("/images/c6.png");
            card.setFill(new ImagePattern(c6));
        }
        if(suit == Suit.CLUBS && rank == Rank.SEVEN)
        {
            Image c7 = new Image("/images/c7.png");
            card.setFill(new ImagePattern(c7));
        }
        if(suit == Suit.CLUBS && rank == Rank.EIGHT)
        {
            Image c8 = new Image("/images/c8.png");
            card.setFill(new ImagePattern(c8));
        }
        if(suit == Suit.CLUBS && rank == Rank.NINE)
        {
            Image c9 = new Image("/images/c9.png");
            card.setFill(new ImagePattern(c9));
        }
        if(suit == Suit.CLUBS && rank == Rank.TEN)
        {
            Image c10 = new Image("/images/c10.png");
            card.setFill(new ImagePattern(c10));
        }
        if(suit == Suit.CLUBS && rank == Rank.JACK)
        {
            Image cj = new Image("/images/cj.png");
            card.setFill(new ImagePattern(cj));
        }
        if(suit == Suit.CLUBS && rank == Rank.KING)
        {
            Image ck = new Image("/images/ck.png");
            card.setFill(new ImagePattern(ck));
        }
        if(suit == Suit.CLUBS && rank == Rank.QUEEN)
        {
            Image cq = new Image("/images/cq.png");
            card.setFill(new ImagePattern(cq));
        }

        //Sets Heart Pictures

        if(suit == Suit.HEARTS && rank == Rank.ACE)
        {
            Image h1 = new Image("/images/h1.png");
            card.setFill(new ImagePattern(h1));
        }
        if(suit == Suit.HEARTS && rank == Rank.TWO)
        {
            Image h2 = new Image("/images/h2.png");
            card.setFill(new ImagePattern(h2));
        }
        if(suit == Suit.HEARTS && rank == Rank.THREE)
        {
            Image h3 = new Image("/images/h3.png");
            card.setFill(new ImagePattern(h3));
        }
        if(suit == Suit.HEARTS && rank == Rank.FOUR)
        {
            Image h4 = new Image("/images/h4.png");
            card.setFill(new ImagePattern(h4));
        }
        if(suit == Suit.HEARTS && rank == Rank.FIVE)
        {
            Image h5 = new Image("/images/h5.png");
            card.setFill(new ImagePattern(h5));
        }
        if(suit == Suit.HEARTS && rank == Rank.SIX)
        {
            Image h6= new Image("/images/h6.png");
            card.setFill(new ImagePattern(h6));
        }
        if(suit == Suit.HEARTS && rank == Rank.SEVEN)
        {
            Image h7 = new Image("/images/h7.png");
            card.setFill(new ImagePattern(h7));
        }
        if(suit == Suit.HEARTS && rank == Rank.EIGHT)
        {
            Image h8 = new Image("/images/h8.png");
            card.setFill(new ImagePattern(h8));
        }
        if(suit == Suit.HEARTS && rank == Rank.NINE)
        {
            Image h9 = new Image("/images/h9.png");
            card.setFill(new ImagePattern(h9));
        }
        if(suit == Suit.HEARTS && rank == Rank.TEN)
        {
            Image h10 = new Image("/images/h10.png");
            card.setFill(new ImagePattern(h10));
        }
        if(suit == Suit.HEARTS && rank == Rank.JACK)
        {
            Image hj = new Image("/images/hj.png");
            card.setFill(new ImagePattern(hj));
        }
        if(suit == Suit.HEARTS && rank == Rank.KING)
        {
            Image hk = new Image("/images/hk.png");
            card.setFill(new ImagePattern(hk));
        }
        if(suit == Suit.HEARTS && rank == Rank.QUEEN)
        {
            Image hq = new Image("/images/hq.png");
            card.setFill(new ImagePattern(hq));
        }

        // Set spade card pictures
        if(suit == Suit.SPADES && rank == Rank.ACE)
        {
            Image s1 = new Image("/images/s1.png");
            card.setFill(new ImagePattern(s1));
        }
        if(suit == Suit.SPADES && rank == Rank.TWO)
        {
            Image s2 = new Image("/images/s2.png");
            card.setFill(new ImagePattern(s2));
        }
        if(suit == Suit.SPADES && rank == Rank.THREE)
        {
            Image s3 = new Image("/images/s3.png");
            card.setFill(new ImagePattern(s3));
        }
        if(suit == Suit.SPADES && rank == Rank.FOUR)
        {
            Image s4 = new Image("/images/s4.png");
            card.setFill(new ImagePattern(s4));
        }
        if(suit == Suit.SPADES && rank == Rank.FIVE)
        {
            Image s5 = new Image("/images/s5.png");
            card.setFill(new ImagePattern(s5));
        }
        if(suit == Suit.SPADES && rank == Rank.SIX)
        {
            Image s6= new Image("/images/s6.png");
            card.setFill(new ImagePattern(s6));
        }
        if(suit == Suit.SPADES && rank == Rank.SEVEN)
        {
            Image s7 = new Image("/images/s7.png");
            card.setFill(new ImagePattern(s7));
        }
        if(suit == Suit.SPADES && rank == Rank.EIGHT)
        {
            Image s8 = new Image("/images/s8.png");
            card.setFill(new ImagePattern(s8));
        }
        if(suit == Suit.SPADES && rank == Rank.NINE)
        {
            Image s9 = new Image("/images/s9.png");
            card.setFill(new ImagePattern(s9));
        }
        if(suit == Suit.SPADES && rank == Rank.TEN)
        {
            Image s10 = new Image("/images/s10.png");
            card.setFill(new ImagePattern(s10));
        }
        if(suit == Suit.SPADES && rank == Rank.JACK)
        {
            Image sj = new Image("/images/sj.png");
            card.setFill(new ImagePattern(sj));
        }
        if(suit == Suit.SPADES && rank == Rank.KING)
        {
            Image sk = new Image("/images/sk.png");
            card.setFill(new ImagePattern(sk));
        }
        if(suit == Suit.SPADES && rank == Rank.QUEEN)
        {
            Image sq = new Image("/images/sq.png");
            card.setFill(new ImagePattern(sq));
        }

        // Set Diamond pictures for cards

        if(suit == Suit.DIAMONDS && rank == Rank.ACE)
        {
            Image d1 = new Image("/images/d1.png");
            card.setFill(new ImagePattern(d1));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.TWO)
        {
            Image d2 = new Image("/images/d2.png");
            card.setFill(new ImagePattern(d2));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.THREE)
        {
            Image d3 = new Image("/images/d3.png");
            card.setFill(new ImagePattern(d3));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.FOUR)
        {
            Image d4 = new Image("/images/d4.png");
            card.setFill(new ImagePattern(d4));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.FIVE)
        {
            Image d5 = new Image("/images/d5.png");
            card.setFill(new ImagePattern(d5));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.SIX)
        {
            Image d6= new Image("/images/d6.png");
            card.setFill(new ImagePattern(d6));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.SEVEN)
        {
            Image d7 = new Image("/images/d7.png");
            card.setFill(new ImagePattern(d7));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.EIGHT)
        {
            Image d8 = new Image("/images/d8.png");
            card.setFill(new ImagePattern(d8));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.NINE)
        {
            Image d9 = new Image("/images/d9.png");
            card.setFill(new ImagePattern(d9));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.TEN)
        {
            Image d10 = new Image("/images/d10.png");
            card.setFill(new ImagePattern(d10));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.JACK)
        {
            Image dj = new Image("/images/dj.png");
            card.setFill(new ImagePattern(dj));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.KING)
        {
            Image dk = new Image("/images/dk.png");
            card.setFill(new ImagePattern(dk));
        }
        if(suit == Suit.DIAMONDS && rank == Rank.QUEEN)
        {
            Image dq = new Image("/images/dq.png");
            card.setFill(new ImagePattern(dq));
        }
        getChildren().add(new StackPane(card));

        return card;
    }
}
