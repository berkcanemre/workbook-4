package pluralsight;

import java.util.*;

// Represents a player's hand of cards
public class Hand {
    private List<Card> cards = new ArrayList<>(); // List to hold cards in hand

    // Add a card to the hand
    public void addCard(Card card) {
        cards.add(card);
    }

    // Calculate the hand's score, treating Aces as 1 if needed
    public int getScore() {
        int score = 0;
        int aceCount = 0;

        for (Card card : cards) {
            score += card.getValue();
            if (card.toString().contains("Ace")) aceCount++; // Count the number of Aces
        }

        // Adjust score if Aces would cause bust
        while (score > 21 && aceCount > 0) {
            score -= 10; // Treat one Ace as 1 instead of 11
            aceCount--;
        }

        return score;
    }

    // Check if the hand has busted (score over 21)
    public boolean isBusted() {
        return getScore() > 21;
    }

    // Return a string of the hand's cards
    public String toString() {
        return cards.toString();
    }
}