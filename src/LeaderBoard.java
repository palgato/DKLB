import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LeaderBoard
{
    public static void main(String[] args)
    {
        String filepath = "DKLeaderBoard.csv";
        createLeaderBoard(filepath);
    }

    public static void createLeaderBoard(String fileName) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(fileName);
            writer.append("Dave");
            writer.append(',');
            writer.append("1");
            writer.append('\n');

            System.out.println("CSV file created");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* Add a Player - takes a name and creates a player in the LeaderBoard */
    public static void addPlayer(String playerName, String filepath) {

/*        //setup mechanism to write to CSV file
        //need to work out how to use this without using filepath as an argument to the method
        FileWriter fw = new FileWriter(filepath,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        //append playerName to the file and allocate 0 wins by default
        pw.println(playerName + "," + 0);
        pw.flush();
        pw.close();

        //print out / display a successful message that the player has been added
        System.out.println("Player " + playerName + " added!");*/
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
