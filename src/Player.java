public class Player implements Comparable<Player> {

    int wins;
    boolean active;

    public Player(int numberOfWins, boolean isActive) {

        wins = numberOfWins;
        active = isActive;
    }

    public Integer getWins() {

        return wins;
    }

    public Boolean getActive() {

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
