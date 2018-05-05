import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {

    @Test
    public void getPromptNoCoinsEqualsInsertCoin() {
        Display display = new Display(false);
        assertEquals(Display.INSERT_COIN, display.getPrompt(0));
    }

    @Test
    public void getPromptWithCoinsDisplaysValue() {
        Display display = new Display(false);
        assertEquals("$0.25", display.getPrompt(.25));
        assertEquals("$1.25", display.getPrompt(1.25));
        assertEquals("$0.05", display.getPrompt(.05));
    }

    @Test
    public void getPromptNoCoinsExactChangeDisplayExactChange() {
        Display display = new Display(true);
        assertEquals(Display.EXACT_CHANGE_ONLY, display.getPrompt(0));
    }
}