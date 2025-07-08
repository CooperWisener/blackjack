package Blackjack;
import java.util.*;

public class Card {
    /**
     * 1 will be an ace, 11 will be jack, 12 will be queen, 13 will be king.
     */
    private int num;
    /**
     * 1 will be diamonds, 2 will be hearts, 3 will be spades, 4 will be clubs.
     */
    private int suit;
    private int value;

    /**
     * Default Constructor, makes an ace of diamonds.
     */
    public Card() {
        num = 2;
        suit = 1;
        value = 11;
    }
    /**
     * Alternate Constructor
     * @param num, a number 1-13 representing the number of the card, see variables for what 1, 11, 12, and 13 represent.
     * @param suit, a number 1-4 representing the suit. See variables for what each number represents.
     */
    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
        if (num > 1 && num < 11) {
            value = num;
        }
        else if (num == 1) {
            value = 11;
        }
        else {
            value = 10;
        }
    }


    /**
     * Will get value of the card.
     * @return the value of the card, face cards being 10 and aces giving the user the option for 1 or 11.
     */
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets a string of the card number, will return king, queen etc.
     * @return a string of the card number
     */
    public String getNum() {
        if (num == 1) {
            return "Ace";
        }
        else if (num == 11){
            return "Jack";
        }
        else if (num == 12) {
            return "Queen";
        }
        else if (num == 13) {
            return "King";
        }
        return Integer.toString(num);

    }

    /**
     * gets the suit of the card
     * @return a string of the suit.
     */
    public String getSuit(){
        if (suit == 1) {
            return "Diamond";
        }
        else if (suit == 2) {
            return "Heart";
        }
        else if (suit == 3){
            return "Spade";
        }
        else {
            return "Club";
        }
    }


    public String toString() {
        Card card = new Card(num, suit);
        return "Number: " + card.getNum() + "\tSuit: " + card.getSuit() + "\n";
    }

}
