package Blackjack;
import java.util.*;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        int cash = 10;
        // Create the empty deck
        ArrayList<Card> deck = new ArrayList<Card>();


        int[] suits = {1, 2, 3, 4};

        // Create the ranks
        int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        // Loop through each suit
        for (int suit : suits) {
            // Loop through each rank
            for (int rank : ranks) {
                // Create a new card with the current suit and rank
                Card card = new Card(rank, suit);

                // Add the card to the deck
                deck.add(card);
            }
        }
        //shuffle deck
        Collections.shuffle(deck);

        int j = 0;
        //Playing Blackjack
        while (j == 0) {
            ArrayList<Card> userHand = new ArrayList<Card>();
            ArrayList<Card> houseHand = new ArrayList<Card>();
            Player user = new Player(userHand);
            Player house = new Player(houseHand);
            for (int i = 0; i < 2; i++) {
                user.addCard(deck.get(0));
                deck.remove(0);
                house.addCard(deck.get(0));
                deck.remove(0);
            }

            System.out.println("What is your bet? \nYour Cash as of this moment: " + cash);
            int bet = scan1.nextInt();
            cash -= bet;
            System.out.println("Your bet: " + bet + "\tYour Cash(post bet): " + cash + "\n\n");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            int k = 0;
            int count = 0;
            int userPoints = user.getScore();

            while (k == 0) {
                System.out.println("Your hand: " + user.getPlayersHandString());
                System.out.println("House's First Card: " + house.getPlayersFirstCard());

                System.out.println("Would you like to hit(h) or stay(s)?");
                String choice = scan.nextLine();
                if (choice.equals("h")) {
                    count++;
                    System.out.println("You have hit.");
                    user.addCard(deck.get(0));
                    deck.remove(0);
                    System.out.println("This is your new card: " + userHand.get(1 + count).toString());
                    userPoints = user.getScore();
                    if (userPoints > 21) {
                        userPoints = 0;
                        System.out.println("You busted!");
                        break;
                    }
                }
                if (choice.equals("s")) {
                    break;
                }
            }


            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            int q = 0;
            int housePoints = house.getScore();
            while (q == 0) {
                if (housePoints < 17) {
                    house.addCard(deck.get(0));
                    deck.remove(0);
                    housePoints = house.getScore();
                    System.out.println(housePoints);
                    if (housePoints > 21) {
                        housePoints = 1;
                        break;
                    }
                } else {
                    break;
                }
            }

            if (userPoints == 21 && housePoints != 21) {
                System.out.println("Houses Hand: ");
                for (Card card : house.getPlayersHand()) {
                    System.out.println(card);
                }
                System.out.println("Blackjack!!!");
                cash += (int) (2.5 * bet);
            } else if (userPoints > housePoints) {
                System.out.println("Houses Hand: ");
                for (Card card : house.getPlayersHand()) {
                    System.out.println(card);
                }
                System.out.println("You won!!!");
                cash += 2 * bet;
            } else if (userPoints == housePoints) {
                System.out.println("Houses Hand: ");
                for (Card card : house.getPlayersHand()) {
                    System.out.println(card);
                }
                System.out.println("You tied.");
                cash += bet;
            } else {
                System.out.println("Houses Hand: ");
                for (Card card : house.getPlayersHand()) {
                    System.out.println(card);
                }
                System.out.println("You lost.");
            }

            if (userPoints == 0 && housePoints == 1) {
                System.out.println("User Busted, House Wins.");
            } else if (housePoints == 1) {
                System.out.println("House Busted, User Wins!");
            } else if (userPoints == 0) {
                System.out.println("User Busted, House Wins.");
            } else {
                System.out.println("User Points: " + userPoints);
                System.out.println("House points: " + housePoints);
            }

            System.out.println("Your cash: " + cash);

            deck.addAll(user.getPlayersHand());
            deck.addAll(house.getPlayersHand());
            userPoints = 0;
            housePoints = 0;
            System.out.println("Do you want to play another hand? (y/n)");
            String choice2 = scan.nextLine();
            if (choice2.equals("y")) {
                j = 0;
            } else if (choice2.equals("n")) {
                j = 1;
            }
        }

    }
}
