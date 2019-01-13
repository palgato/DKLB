public class Player implements Comparable<Player> {

    private int wins;
    private boolean active;

    public Player(int numberOfWins, boolean isActive) {
        wins = numberOfWins;
        active = isActive;
    }

    public int getWins() {
        return wins;
    }

    public boolean getActive() {
        return active;
    }

    public void addWin() {
        wins++;
    }

    public void updateStatus(boolean newStatus) {
        active = newStatus;
    }

    @Override
    public int compareTo(Player player) {
        return player.getWins() - this.wins;
    }
}
