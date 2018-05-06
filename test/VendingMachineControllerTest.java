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
            vendingMachineController.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
    }

    @Test
    public void selectProductWithNoMoneyReturnsPrice() {
        assertFalse(vendingMachineController.selectProduct(VendingMachineController.Product.POP));
        assertEquals("$1.00", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectProduct(VendingMachineController.Product.CHIPS));
        assertEquals("$0.50", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectProduct(VendingMachineController.Product.CANDY));
        assertEquals("$0.65", vendingMachineController.getDisplayPrompt());
    }

    @Test
    public void selectProductWithEnoughMoneyReturnsTrue() {
        addQuartersToCoinAcceptor(4);
        assertTrue(vendingMachineController.selectProduct(VendingMachineController.Product.POP));
        addQuartersToCoinAcceptor(2);
        assertTrue(vendingMachineController.selectProduct(VendingMachineController.Product.CHIPS));
        addQuartersToCoinAcceptor(3);
        assertTrue(vendingMachineController.selectProduct(VendingMachineController.Product.CANDY));
    }

    @Test
    public void selectProductWithMoreThanEnoughMoneyReturnsChange() {
        addQuartersToCoinAcceptor(5);
        assertTrue(vendingMachineController.selectProduct(VendingMachineController.Product.POP));
        List<Coin> changeCollected = vendingMachineController.getCoinsFromReturnSlot();
        assertEquals(1, changeCollected.size());
        assertEquals(Coin.QUARTER, changeCollected.get(0));


    }

}