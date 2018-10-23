import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileHandler {

    /* Read from File - reads a Leaderboard file and returns a Hashmap of Players and their wins */
    public static Map<String, Wins> readFromFile(String filePath){
        String line;
        //int numLines = 0;
        Map<String, Wins> loadedPlayers;
        loadedPlayers = new HashMap<String, Wins>();

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                List<String> aList = new ArrayList<>(Arrays.asList(line.split(",")));
                String n = aList.get(0);
                Wins w = new Wins(Integer.parseInt(aList.get(1)));
                loadedPlayers.put(n,w);
                //numLines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedPlayers;
    }

    /* Write to File - adds a Player and their number of wins to a LeaderBoard */
    public static void writeToFile(LeaderBoard leaderBoard, String writeName, int writeWins) {

        //Create a writer which will write information to a file
        FileWriter writer = null;

        try {
            //Pass the LeaderBoard filePath to the FileWriter
            writer = new FileWriter(leaderBoard.filePath,true);

            //Append the name and number of wins to the leaderBoard file as comma separated values
            writer.append(writeName);
            writer.append(",");
            writer.append(Integer.toString(writeWins));
            writer.append('\n');

            //Print out successful added line of leaderBoard file

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
}
