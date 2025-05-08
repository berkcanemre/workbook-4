package pluralsight;

import java.util.*;

// Represents a player in the game
public class Player {
    private String name; // Player's name
    private Hand hand = new Hand(); // Player's hand of cards

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Get player's name
    public String getName() {
        return name;
    }

    // Get player's hand
    public Hand getHand() {
        return hand;
    }

    // Ask player if they want to hit or stay
    public boolean wantsToHit(Scanner scanner) {
        System.out.print(name + ", do you want to hit? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y");
    }
}