import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    private VendingMachineController vendingMachineController;

    @Before
    public void setUp() {
        vendingMachineController = new VendingMachineController();
    }

    private void addQuartersToCoinAcceptor(int quarters) {
        for (int i = 0; i < quarters; i++) {
            vendingMachineController.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
    }

    @Test
    public void selectProductWithNoMoneyReturnsPrice() {
        assertFalse(vendingMachineController.selectPop());
        assertEquals("$1.00", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectChips());
        assertEquals("$0.50", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectCandy());
        assertEquals("$0.65", vendingMachineController.getDisplayPrompt());
    }

    @Test
    public void selectProductWithEnoughMoneyReturnsTrue() {
        addQuartersToCoinAcceptor(4);
        assertTrue(vendingMachineController.selectPop());
        addQuartersToCoinAcceptor(2);
        assertTrue(vendingMachineController.selectChips());
        addQuartersToCoinAcceptor(3);
        assertTrue(vendingMachineController.selectCandy());
    }

}