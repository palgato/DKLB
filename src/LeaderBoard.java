import java.util.HashMap;
import java.util.Map;

public class LeaderBoard
{
    String filePath;

    public LeaderBoard(String leaderBoardFilePath) {
        filePath = leaderBoardFilePath;
    }
    public static void main(String[] args)
    {
        //Create a new LeaderBoard with a specific file name
        LeaderBoard unoBoard = new LeaderBoard("unoBoard.csv");

        //Load a HashMap with players from the LeaderBoard's CSV file
        //Then display the list of players and their wins
        Map<String, Wins> loadedPlayers = new HashMap<String, Wins>(Loader.loadLeaderBoard(unoBoard));
        for (String p : loadedPlayers.keySet()) {
            System.out.println("Player: " + p + "; Wins: " + loadedPlayers.get(p).wins);
        }
        System.out.println("Loaded CSV file: " + unoBoard.filePath);

        //Add a player to the board and display updated LeaderBoard
        unoBoard.addPlayer("Sherlock");
        Map<String, Wins> addLoadedPlayers = new HashMap<String, Wins>(Loader.loadLeaderBoard(unoBoard));
        for (String p : addLoadedPlayers.keySet()) {
            System.out.println("Player: " + p + "; Wins: " + addLoadedPlayers.get(p).wins);
        }
        System.out.println("Added Player and updated CSV file: " + unoBoard.filePath);

        //Create a HashMap of players and their wins
        //Create a LeaderBoard CSV file with the HashMap
        Map<String, Wins> unoPlayers = new HashMap<String, Wins>();
        unoPlayers.put("Chile",new Wins(10));
        unoPlayers.put("Argentina",new Wins(5));
        unoPlayers.put("Peru",new Wins(-10));

        //Create the LeaderBoard with the set of Players
        unoBoard.createLeaderBoard(unoPlayers);
        for (String p : unoPlayers.keySet()) {
            System.out.println("Player: " + p + "; Wins: " + unoPlayers.get(p).wins);
        }
        System.out.println("Added new Players and updated CSV file: " + unoBoard.filePath);

    }

    /* Create a LeaderBoard file and add in a set of Players */
    public void createLeaderBoard(Map<String, Wins> listOfPlayers) {

        //Cycle through each Player in the HashMap and write to the LeaderBoard file
        for (String key : listOfPlayers.keySet()) {
            int wins = listOfPlayers.get(key).getWins();
            FileHandler.writeToFile(this, key, wins);
        }

    }

    /* Add a Player - Loads a LeaderBoard and adds a new Player to it */
    public void addPlayer(String newPlayer) {

        //Add the player to the file and allocate '0' wins
        FileHandler.writeToFile(this, newPlayer, 0);

    }

    /* Remove a Player - takes a Player and removes them from the LeaderBoard */
    public void removePlayer(String player) {
        //

    }

    /* Add a win to a Player - takes a name and creates a player in the LeaderBoard */
    public void playerWin(String name) {
        //find the player in CSV file

        //retrieve the number of wins from the CSV file

        //increment the number of wins

        //update the CSV file with the new value

    }
}
