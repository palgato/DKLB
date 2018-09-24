public class Player {
    String name;
    int wins;

    public Player(String playerName, int playerWins) {
        name = playerName;
        wins = playerWins;
    }

    public String getName() {
        return name;
    }

    public String getWins() {
        return Integer.toString(wins);
    }

    public void addWin() {
        wins++;
    }
}
