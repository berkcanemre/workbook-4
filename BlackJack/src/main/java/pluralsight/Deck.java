package pluralsight;

import java.util.*;

// Represents a standard deck of 52 playing cards
public class Deck {
    private List<Card> cards = new ArrayList<>(); // List to hold the deck

    // Constructor initializes and shuffles the deck
    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; // All suits
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // All ranks

        // Create all 52 cards
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }

        shuffle(); // Shuffle after creating the deck
    }

    // Shuffle the deck randomly
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deal the top card and remove it from the deck
    public Card dealCard() {
        return cards.remove(0);
    }
}
