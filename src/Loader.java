import java.util.HashMap;
import java.util.Map;

public class Loader {
    /* Load a LeaderBoard from a given file and display its contents */
    public static Map<String, Wins> loadLeaderBoard(LeaderBoard leaderBoard) {

        //Create a HashMap of Players and their wins
        Map<String, Wins> loadedPlayers = new HashMap<String, Wins>();

        //Read from a given file and add Players and their wins to the HashMap
        loadedPlayers = FileHandler.readFromFile(leaderBoard.filePath);

        //Display the Player and associated wins

        return loadedPlayers;
    }
}
