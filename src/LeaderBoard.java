import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        //unoBoard.addPlayer("Sherlock");
        //unoBoard.addPlayer("Watson");
        //displayPlayers(unoBoard);

        //Update the status of a Player and display updated LeaderBoard
        //unoBoard.updatePlayerStatus("Dave",false);
        //displayPlayers(unoBoard);

        //Add a win to a Player and display updated LeaderBoard
        //unoBoard.playerWin("Juan");
        //displayPlayers(unoBoard);

        //Sort the list of Players based on number of wins
        sortBoardPlayers(unoBoard);

        //Show a Player
        //unoBoard.showPlayer("Charlie");
        //unoBoard.showPlayer("Dave");
    }

    /* Display all active Players from a LeaderBoard */
    private static void displayPlayers(LeaderBoard leaderBoard) {

        //For each active Player in the boardPlayers HashMap, display Name, Wins and Active values
        System.out.println("*******************************");
        System.out.println("Displaying Players....");
        for (String key : leaderBoard.boardPlayers.keySet()) {
            int pWins = leaderBoard.boardPlayers.get(key).wins;
            boolean pActive = leaderBoard.boardPlayers.get(key).active;
            if(pActive) {
                System.out.println("Player: " + key + "; Wins: " + pWins);
            }
        }
    }

    /* Sort the loaded players in descending Wins value */
    public static void sortBoardPlayers(LeaderBoard leaderBoard) {

        //Add LeaderBoard Players to a List and sort them in descending order of Wins
        List<Player> sortedBoardplayers = new ArrayList<>(leaderBoard.boardPlayers.values());
        Collections.sort(sortedBoardplayers);

        //Print out the sorted Players only displaying active Players
        System.out.println("*******************************");
        System.out.println("LEADERBOARD");
        System.out.println("Position | Player (Wins)");
        String padding = "        | ";
        int position = 1;
        for (int i = 0; i < sortedBoardplayers.size(); i++) {
            Player p = sortedBoardplayers.get(i);
            if (p.active) {
                System.out.println(position + padding + getKey(leaderBoard.boardPlayers, p) + "(" + p.wins + ")");
                position++;
            }
        }
    }

    /* Returns the Name of a Player in a Map of Players where their name is the key */
    public static String getKey(Map<String, Player> map, Player player) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(player)) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    /* Add a Player - Loads a LeaderBoard and adds a new Player to it */
    public void addPlayer(String newPlayerName) {

        //Check if Player to add exists and create them
        if (!boardPlayers.containsKey(newPlayerName)) {
            //Create a new Player with 0 wins and set as active
            Player newPlayer = new Player(0, true);

            //Add the player to the LeaderBoard HashMap and write to the CSV file
            boardPlayers.put(newPlayerName,newPlayer);
            FileHandler.writeToFile(this);
        } else {
            //If the Player already exists, print out message saying so
            System.out.println("*******************************");
            System.out.println("Adding Player....");
            System.out.println("Player: " + newPlayerName + " already exists for this Leaderboard");
        }
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
            System.out.println("*******************************");
            System.out.println("Updating Player....");
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
            System.out.println("*******************************");
            System.out.println("Adding Player win....");
            System.out.println("Player: " + winnerName + " does not exist");
        }
    }

    /* Show a Player - display a single Player and their relevant information */
    public void showPlayer(String playerName) {

        System.out.println("*******************************");
        System.out.println("Showing Player....");

        //Check if winning Player exists, add their win and write to the CSV file
        if (boardPlayers.containsKey(playerName)) {
            Player showPlayer = boardPlayers.get(playerName);

            System.out.println("Player: " + playerName + " Wins: " + showPlayer.getWins() + " Active: " + showPlayer.getActive());
        } else {
            //If the Player doesn't exist, print out message saying so
            System.out.println("Player: " + playerName + " does not exist");
        }
    }
}
