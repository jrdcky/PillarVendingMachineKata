import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {

    @Test
    public void getDisplayNoCoinsEqualsInsertCoin() {
        Display display = new Display();
        assertEquals(Display.INSERT_COIN, display.getPrompt(0));
    }

    @Test
    public void getDisplayWithCoinsDisplaysValue() {
        Display display = new Display();
        assertEquals("$0.25", display.getPrompt(.25));
    }
}