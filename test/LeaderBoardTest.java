import org.junit.Test;

import static org.junit.Assert.*;

public class LeaderBoardTest {
    private LeaderBoard testBoard = new LeaderBoard("testBoard.csv");

    @Test
    public void testFilepath() {
        assertEquals("testBoard.csv", testBoard.getFilePath());
    }

    /* Test the addPlayer() method in the LeaderBoard class
     * A newly added Player is created with 0 wins and an active value of true */
    @Test
    public void testAddPlayer() {
        Player testPlayer = new Player(0,true);
        testBoard.addPlayer("Charlie");
        Player addedPlayer = testBoard.getBoardPlayers().get("Charlie");

        assertEquals(testPlayer.getWins(), addedPlayer.getWins());
        assertEquals(testPlayer.getActive(), addedPlayer.getActive());
    }

    /* Test the updatePlayer() method in the LeaderBoard class
     * A Player 'Mac' has an initial active value of false */
    @Test
    public void testUpdatePlayer() {
        Player testPlayer = new Player(3, true);
        testBoard.updatePlayerStatus("Mac",true);
        Player updatedPlayer = testBoard.getBoardPlayers().get("Mac");

        assertEquals(testPlayer.getActive(), updatedPlayer.getActive());
    }

    /* Test the playerWin() method in the LeaderBoard class
     * A Player 'Dennis' has an initial wins value of 4 */
    @Test
    public void testPlayerWin() {
        Player testPlayer = new Player(5,true);
        testBoard.playerWin("Dennis");
        Player winningPlayer = testBoard.getBoardPlayers().get("Dennis");

        assertEquals(testPlayer.getWins(),winningPlayer.getWins());
    }

    /* Test the showPlayer() method in the LeaderBoard class
     * A Player 'Dee' has an initial wins value of 7 and true active status */
    @Test
    public void testShowPlayer() {
        Player testPlayer = new Player(7,true);

        assertEquals(testPlayer,testBoard.showPlayer("Dee"));
    }
}