import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

        //Create a new HashMap that will store a set of Players
        HashMap<Player, Integer> unoPlayers = new HashMap<Player, Integer>();

        //Create new Players
        // - need to prompt a user to specify these
        Player dave = new Player("Dave",0);
        Player donna = new Player("Donna",1);
        Player bob = new Player("Bob",4);

        //Add each Player to the HashMap
        // - need to work out how to create a sequence for the keys
        unoPlayers.put(dave,1);
        unoPlayers.put(donna,2);
        unoPlayers.put(bob,3);

        //Create the LeaderBoard with the set of Players
        unoBoard.createLeaderBoard(unoPlayers);

        //Load an existing LeaderBoard
        // - need to check if a CSV file exists and to load in all the Players in it
        unoBoard.loadLeaderBoard();
    }

    /* Create a LeaderBoard file and add in a set of Players */
    public void createLeaderBoard(HashMap<Player, Integer> players) {

        //Cycle through each Player in the HashMap and write to the LeaderBoard file
        for (Player p : players.keySet()) {
                writeToFile(p.getName(),p.getWins());
        }

        //Print out successful creation of LeaderBoard file
        System.out.println("CSV file " + filePath + " successfully created");
    }

    /* Load a LeaderBoard from a given file and display its contents */
    public void loadLeaderBoard() {

        //Create a HashMap of Players and their wins
        HashMap<Player, Integer> showPlayers = new HashMap<Player, Integer>();

        //Read from a given file and add Players and their wins to the HashMap
        showPlayers = readFromFile(this.filePath);

        //Display the Player and associated wins
        for (Player p : showPlayers.keySet()) {
            System.out.println("Player: " + p.getName() + "; Wins: " + p.getWins());
        }
    }

    public HashMap<Player, Integer> readFromFile(String filePath){
        String line;
        int numLines = 0;
        String csvSplitBy = ",";
        HashMap<Player, Integer> loadedPlayers = new HashMap<Player, Integer>();

        try {
            FileReader fr = new FileReader(filePath);

            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                List<String> aList = new ArrayList<>(Arrays.asList(line.split(csvSplitBy)));
                String n = aList.get(0);
                int w = Integer.parseInt(aList.get(1));
                Player p = new Player(n, w);
                loadedPlayers.put(p,numLines);
                numLines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedPlayers;
    }

    /* Add a Player - takes a name and creates a player in the LeaderBoard */
    public void writeToFile(String writeName, String writeWins) {

        //Create a writer which will write information to a file
        FileWriter writer = null;

        try {
            //Pass the LeaderBoard filePath to the FileWriter
            writer = new FileWriter(this.filePath,true);

            //Cycle through each Player in the HashMap as comma separated values
            writer.append(writeName);
            writer.append(",");
            writer.append(writeWins);
            writer.append('\n');

            //Print out successful creation of LeaderBoard file
            System.out.println("CSV file " + this.filePath + " successfully updated");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                //Finish writing to the file and close it
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
