import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    private VendingMachineController vendingMachineController;

    @Before
    public void setUp() {
        vendingMachineController = new VendingMachineController();
    }

    private void addQuartersToCoinAcceptor(int quarters) {
        for (int i = 0; i < quarters; i++) {
            vendingMachineController.insertCoin(Coin.QUARTER);
        }
    }

    @Test
    public void selectProductWithNoMoneyReturnsPrice() {
        assertFalse(vendingMachineController.selectProduct(Product.POP));
        assertEquals("$1.00", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectProduct(Product.CHIPS));
        assertEquals("$0.50", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectProduct(Product.CANDY));
        assertEquals("$0.65", vendingMachineController.getDisplayPrompt());
    }

    @Test
    public void selectProductWithEnoughMoneyReturnsTrue() {
        addQuartersToCoinAcceptor(4);
        assertTrue(vendingMachineController.selectProduct(Product.POP));
        addQuartersToCoinAcceptor(2);
        assertTrue(vendingMachineController.selectProduct(Product.CHIPS));
        addQuartersToCoinAcceptor(3);
        assertTrue(vendingMachineController.selectProduct(Product.CANDY));
    }

    @Test
    public void selectProductWithMoreThanEnoughMoneyReturnsChange() {
        addQuartersToCoinAcceptor(5);
        assertTrue(vendingMachineController.selectProduct(Product.POP));
        List<Coin> changeCollected = vendingMachineController.getCoinsFromReturnSlot();
        assertEquals(1, changeCollected.size());
        assertEquals(Coin.QUARTER, changeCollected.get(0));
    }

    @Test
    public void insertBadCoinGetsReturned() {
    }

}