import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    Player testPlayer = new Player(5,true);

    @Test
    public void testGetWins() {
        assertEquals(5,testPlayer.getWins());
    }

    @Test
    public void testGetStatus() {
        assertEquals(true, testPlayer.getActive());
    }

    @Test
    public void testAddWins() {
        testPlayer.addWin();
        assertEquals(6,testPlayer.getWins());
    }

    @Test
    public void testUpdateStatus() {
        testPlayer.updateStatus(false);
        assertEquals(false, testPlayer.getActive());
    }

    @Test
    public void testEquals() {
        Player test1 = new Player(5,true);
        assertEquals(test1,testPlayer);

    }
}