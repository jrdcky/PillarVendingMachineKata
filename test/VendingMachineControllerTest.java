import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    private VendingMachineController vendingMachineController;
    private VendingMachineController outOfStockController;

    @Before
    public void setUp() {
        vendingMachineController = new VendingMachineController(10, 10, 10, 100, 100, 100);
        outOfStockController = new VendingMachineController(0, 0, 0, 2, 0, 1);
    }

    private void addCoinsToCoinAcceptor(VendingMachineController vhc, int number, Coin coin) {
        for (int i = 0; i < number; i++) {
            vhc.insertCoin(coin);
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
        addCoinsToCoinAcceptor(vendingMachineController, 4, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.POP));
        addCoinsToCoinAcceptor(vendingMachineController, 4, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.CHIPS));
        addCoinsToCoinAcceptor(vendingMachineController, 4, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.CANDY));
    }

    @Test
    public void selectProductWithMoreThanEnoughMoneyReturnsChange() {
        addCoinsToCoinAcceptor(vendingMachineController, 5, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.POP));
        List<Coin> changeCollected = vendingMachineController.getCoinsFromReturnSlot();
        assertEquals(1, changeCollected.size());
        assertEquals(Coin.QUARTER, changeCollected.get(0));
    }

    @Test
    public void selectProductOutOfStockReturnsFalse() {
        addCoinsToCoinAcceptor(outOfStockController, 5, Coin.QUARTER);
        assertFalse(outOfStockController.selectProduct(Product.POP));
    }

    @Test
    public void insertBadCoinGetsReturned() {
        Coin badCoin = new Coin(1, .5, .006);
        vendingMachineController.insertCoin(badCoin);
        List<Coin> changeCollected = vendingMachineController.getCoinsFromReturnSlot();
        assertEquals(1, changeCollected.size());
        assertEquals(badCoin, changeCollected.get(0));
    }

    @Test
    public void testReturnCoinsGivesBackSameCoins() {
        addCoinsToCoinAcceptor(vendingMachineController, 3, Coin.QUARTER);
        addCoinsToCoinAcceptor(vendingMachineController, 2, Coin.DIME);
        addCoinsToCoinAcceptor(vendingMachineController, 1, Coin.NICKEL);
        vendingMachineController.returnCoins();
        List<Coin> changeCollected = vendingMachineController.getCoinsFromReturnSlot();
        assertEquals(6, changeCollected.size());
        assertTrue(changeCollected.contains(Coin.NICKEL));
    }

    @Test
    public void whenCoinInsertedThenDisplayShowsAmount() {
        addCoinsToCoinAcceptor(vendingMachineController, 1, Coin.QUARTER);
        assertEquals("$0.25", vendingMachineController.getDisplayPrompt());
    }

    @Test
    public void afterChangeRequestedThenDisplayShowsInsertCoin() {
        addCoinsToCoinAcceptor(vendingMachineController, 1, Coin.QUARTER);
        vendingMachineController.returnCoins();
        assertEquals(Display.INSERT_COIN, vendingMachineController.getDisplayPrompt());
    }

    @Test
    public void lowChangeThenDisplayShowsExactChangeOnly() {
        assertEquals(Display.EXACT_CHANGE_ONLY, outOfStockController.getDisplayPrompt());
    }

}