import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    @Test
    public void selectProductWithNoMoneyReturnsPrice() {
        VendingMachineController vendingMachineController = new VendingMachineController();
        assertFalse(vendingMachineController.selectPop());
        assertEquals("$1.00", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectChips());
        assertEquals("$0.50", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectCandy());
        assertEquals("$0.65", vendingMachineController.getDisplayPrompt());
    }

    @Test
    public void selectProductWithEnoughMoneyReturnsTrue() {
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        vendingMachineController.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        vendingMachineController.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        vendingMachineController.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        assertTrue(vendingMachineController.selectPop());
    }

}