import com.wildlife.Board;
import com.wildlife.organisms.animals.herbivores.Boar;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {

    @Test
    public void testAnimalMove() {
        int startingPosX = 1;
        int startingPosY = 1;
        Board board = new Board(10, 10);
        Boar b = new Boar(startingPosX, startingPosY, board);

        b.performAction();

        assertTrue(b.getPositionX() != startingPosX || b.getPositionY() != startingPosY);
    }
}
