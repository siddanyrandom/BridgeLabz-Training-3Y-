import java.util.Scanner;

public class RockPaperScissors {

    // Method to get computer choice
    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.33) return "Rock";
        else if (rand < 0.66) return "Paper";
        else return "Scissors";
    }

    // Method to determine winner
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) return "Draw";
        if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    // Method to calculate win percentages
    public static String[][] calculateStats(String[] winners) {
        int totalGames = winners.length;
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (String w : winners) {
            if (w.equals("User")) userWins++;
            else if (w.equals("Computer")) computerWins++;
            else draws++;
        }

        double userPercentage = ((double) userWins / totalGames) * 100;
        double computerPercentage = ((double) computerWins / totalGames) * 100;

        String[][] stats = new String[4][3];
        stats[0] = new String[]{"Game", "Winner", "Result"};
        for (int i = 0; i < totalGames; i++) {
            stats[i+1] = new String[]{"Game " + (i+1), winners[i], winners[i]};
        }
        stats = new String[][] {
            {"Total Games", String.valueOf(totalGames), ""},
            {"User Wins", String.valueOf(userWins), String.format("%.2f%%", userPercentage)},
            {"Computer Wins", String.valueOf(computerWins), String.format("%.2f%%", computerPercentage)},
            {"Draws", String.valueOf(draws), ""}
        };

        return stats;
    }

    // Method to display results
    public static void displayStats(String[][] stats) {
        System.out.println("\nGame Stats:");
        System.out.println("-----------------------------");
        for (String[] row : stats) {
            System.out.printf("%-15s %-10s %-10s\n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] winners = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice for game " + (i+1) + " (Rock/Paper/Scissors): ");
            String userChoice = sc.nextLine();
            String computerChoice = getComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);
            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Winner: " + winner + "\n");
            winners[i] = winner;
        }

        String[][] stats = calculateStats(winners);
        displayStats(stats);

        sc.close();
    }
}
