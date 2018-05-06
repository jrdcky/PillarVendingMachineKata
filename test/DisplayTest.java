import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {

    private Display display;

    @Before
    public void setUp() {
        display = new Display(false);
    }

    @Test
    public void getPromptNoCoinsEqualsInsertCoin() {
        assertEquals(Display.INSERT_COIN, display.getPrompt(0));
    }

    @Test
    public void getPromptWithCoinsDisplaysValue() {
        assertEquals("$0.25", display.getPrompt(.25));
        assertEquals("$1.25", display.getPrompt(1.25));
        display.setRequireExactChange(true);
        assertEquals("$0.05", display.getPrompt(.05));
        assertEquals("$1.05", display.getPrompt(1.05));
    }

    @Test
    public void getPromptNoCoinsExactChangeDisplayExactChange() {
        display.setRequireExactChange(true);
        assertEquals(Display.EXACT_CHANGE_ONLY, display.getPrompt(0));
    }

    @Test
    public void getPromptNoCoinsAfterProductSelectedEqualsPrice() {
        display.selectProduct(1.00);
        assertEquals("$1.00", display.getPrompt(0));
    }
}