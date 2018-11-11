public class Player {

    int wins;
    boolean active;

    public Player(int numberOfWins, boolean isActive) {

        wins = numberOfWins;
        active = isActive;
    }

    public void addWin() {

        wins++;
    }

    public void updateStatus(boolean newStatus) {

        active = newStatus;
    }
}
