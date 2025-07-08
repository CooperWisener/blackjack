package Blackjack;
import java.util.*;

public class Player {

    private ArrayList<Card>playersHand;
    private int score;

    /**
     * Alternate constructor for player.
     * @param, an array list of the cards in a persons hand
     */
    public Player(ArrayList<Card>playersHand) {
        this.playersHand = playersHand;
    }

    /**
     * Adds a card to the users hand, will check if score goes above 21 and then checks if there is an ace that it
     * can set its value to 1
     * @param a a card that is added to the hand of the player.
     */
    public void addCard(Card a){
        playersHand.add(a);
        score += a.getValue();
        if (score > 21) {
            // Iterate through the cards in the player's hand
            for (Card card1 : playersHand) {
                // Check if the card is an Ace
                if (card1.getNum().equals("Ace")) {
                    // Check if that ace has already been set to 1
                    if (card1.getValue() != 1) {
                        // Set the value of the Ace card to 1
                        card1.setValue(1);
                        // Update the sum of the card values
                        score = getScore();
                        // Stop iterating through the cards in the player's hand
                        break;
                    }
                }
            }
        }
    }

    /**
     * Calculates the score of the player based of the hand, uses recursion.
     * @return the score of the player
     */
    public int getScore(){
        int sum = 0;
        for (Card card : playersHand) {
            sum += card.getValue();
        }
        if (sum > 21) {
            // Iterate through the cards in the player's hand
            for (Card card : playersHand) {
                // Check if the card is an Ace
                if (card.getNum().equals("Ace")) {
                    // Check if that ace has already been set to 1
                    if (card.getValue() != 1) {
                        // Set the value of the Ace card to 1
                        card.setValue(1);
                        // Update the sum of the card values
                        sum = getScore();
                        // Stop iterating through the cards in the player's hand
                        break;
                    }
                }
            }
        }
        return sum;
    }

    public int getScoreSpecial(){
        int sum = 0;
        for (Card card : playersHand) {
            System.out.println(card.toString());
            sum += card.getValue();
        }
        if (sum > 21) {
            // Iterate through the cards in the player's hand
            for (Card card : playersHand) {
                // Check if the card is an Ace
                if (card.getNum().equals("Ace")) {
                    // Check if that ace has already been set to 1
                    if (card.getValue() != 1) {
                        // Set the value of the Ace card to 1
                        card.setValue(1);
                        // Update the sum of the card values
                        sum = getScore();
                        // Stop iterating through the cards in the player's hand
                        break;
                    }
                }
            }
        }
        return sum;
    }

    public ArrayList<Card> getPlayersHand() {
        return playersHand;
    }

    public String getPlayersHandString(){
        return playersHand.toString();
    }

    public String getPlayersFirstCard() { return playersHand.get(0).toString(); }



}
