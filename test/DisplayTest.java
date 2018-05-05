import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {

    @Test
    public void getDisplayNoCoinsEqualsInsertCoin() {
        Display display = new Display();
        assertEquals(Display.INSERT_COIN, display.getPrompt(0));
    }
}