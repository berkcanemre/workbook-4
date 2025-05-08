package pluralsight;

import java.util.*;

// Main game class for running Blackjack
public class BlackJackGame {
    private List<Player> players = new ArrayList<>(); // List of all players
    private Deck deck; // The shared deck

    // Start the game
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // Ask how many players
        System.out.print("Enter number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());

        // Collect player names
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        deck = new Deck(); // Initialize deck

        // Deal 2 cards to each player
        for (Player player : players) {
            player.getHand().addCard(deck.dealCard());
            player.getHand().addCard(deck.dealCard());
        }

        // Allow each player to take turns (optional Hit/Stay)
        for (Player player : players) {
            System.out.println("\n" + player.getName() + "'s turn. Current hand: " + player.getHand());
            while (!player.getHand().isBusted() && player.wantsToHit(scanner)) {
                player.getHand().addCard(deck.dealCard());
                System.out.println("New hand: " + player.getHand());
            }

            if (player.getHand().isBusted()) {
                System.out.println(player.getName() + " has busted with " + player.getHand().getScore());
            } else {
                System.out.println(player.getName() + " stays with " + player.getHand().getScore());
            }
        }

        // Determine winner
        Player winner = determineWinner();
        if (winner != null) {
            System.out.println("\nWinner is: " + winner.getName() + " with " + winner.getHand().getScore());
        } else {
            System.out.println("\nNo winner. All players busted.");
        }

        scanner.close();
    }

    // Determine which player won
    private Player determineWinner() {
        Player winner = null;
        int bestScore = 0;

        for (Player player : players) {
            int score = player.getHand().getScore();
            if (score <= 21 && score > bestScore) {
                bestScore = score;
                winner = player;
            }
        }

        return winner;
    }
}