package pluralsight;

// Represents a single playing card
public class Card {
    private String suit; // Suit of the card (Hearts, Diamonds, etc.)
    private String rank; // Rank of the card (2, 3, ..., King, Ace)

    // Constructor for Card
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Returns the value of the card based on Blackjack rules
    public int getValue() {
        if (rank.equals("Ace")) return 11; // Ace is 11 by default
        if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) return 10; // Face cards are 10
        return Integer.parseInt(rank); // Number cards return their value
    }

    // Returns a string representation of the card
    public String toString() {
        return rank + " of " + suit;
    }
}
