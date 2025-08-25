import java.util.Scanner;

public class DeckOfCards {

    // Initialize deck
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Distribute cards to players
    public static String[][] distributeCards(String[] deck, int nCards, int numPlayers) {
        if (nCards > deck.length) {
            System.out.println("Not enough cards in the deck!");
            return null;
        }
        if (nCards % numPlayers != 0) {
            System.out.println("Cannot evenly distribute cards among players.");
            return null;
        }
        int cardsPerPlayer = nCards / numPlayers;
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index++];
            }
        }
        return players;
    }

    // Print players and their cards
    public static void printPlayersCards(String[][] players) {
        if (players == null) return;
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);

        System.out.print("Enter number of cards to distribute: ");
        int nCards = sc.nextInt();
        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();

        String[][] players = distributeCards(deck, nCards, numPlayers);
        printPlayersCards(players);

        sc.close();
    }
}
