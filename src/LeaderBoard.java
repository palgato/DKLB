import java.util.*;

public class LeaderBoard
{
    String filePath;
    Map<String, Player> boardPlayers;

    public LeaderBoard(String leaderBoardFilePath) {
        filePath = leaderBoardFilePath;
        boardPlayers = FileHandler.readFromFile(filePath);
    }

    public static void main(String[] args)
    {
        //Create a new LeaderBoard with a specific file name and load any players in it to memory
        LeaderBoard unoBoard = new LeaderBoard("unoBoard.csv");

        //Display the LeaderBoard, i.e. Players and their information
        displayPlayers(unoBoard);

        //Add some new players to the board and display updated LeaderBoard
        unoBoard.addPlayer("Sherlock");
        unoBoard.addPlayer("Watson");
        displayPlayers(unoBoard);

        //Update the status of a Player and display updated LeaderBoard
        unoBoard.updatePlayerStatus("Dave",false);
        displayPlayers(unoBoard);

        //Add a win to a Player and display updated LeaderBoard
        unoBoard.playerWin("Juan");
        displayPlayers(unoBoard);
    }

    private static void displayPlayers(LeaderBoard leaderBoard) {

        //For each Player in the boardPlayers HashMap, display Name, Wins and Active values
        for (String key : leaderBoard.boardPlayers.keySet()) {
            int pWins = leaderBoard.boardPlayers.get(key).wins;
            boolean pActive = leaderBoard.boardPlayers.get(key).active;
            System.out.println("Player: " + key + "; Wins: " + pWins + "; Active: " + pActive);
        }
        System.out.println("Displaying board players: " + leaderBoard.filePath);
    }

    /* Add a Player - Loads a LeaderBoard and adds a new Player to it */
    public void addPlayer(String newPlayerName) {

        //Create a new Player with 0 wins and set as active
        Player newPlayer = new Player(0, true);

        //Add the player to the LeaderBoard HashMap and write to the CSV file
        boardPlayers.put(newPlayerName,newPlayer);
        FileHandler.writeToFile(this);
    }

    /* Remove a Player - takes a Player and removes them from the LeaderBoard */
    public void updatePlayerStatus(String updateName, boolean newStatus) {

        //Check if Player to update exists, update their status and write to the CSV file
        if (boardPlayers.containsKey(updateName)) {
            Player updatedPlayer = boardPlayers.get(updateName);
            updatedPlayer.updateStatus(newStatus);
            boardPlayers.replace(updateName, updatedPlayer);

            FileHandler.writeToFile(this);
        } else {
            //If the Player doesn't exist, print out message saying so
            System.out.println("Player: " + updateName + " does not exist");
        }
    }

    /* Add a win to a Player - takes a name and creates a player in the LeaderBoard */
    public void playerWin(String winnerName) {

        //Check if winning Player exists, add their win and write to the CSV file
        if (boardPlayers.containsKey(winnerName)) {
            Player winner = boardPlayers.get(winnerName);
            winner.addWin();
            boardPlayers.replace(winnerName, winner);

            FileHandler.writeToFile(this);
        } else {
            //If the Player doesn't exist, print out message saying so
            System.out.println("Player: " + winnerName + " does not exist");
        }
    }
}
