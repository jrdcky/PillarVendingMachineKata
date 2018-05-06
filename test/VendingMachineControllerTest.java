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

    private void addCoinsToCoinAcceptor(int number, Coin coin) {
        for (int i = 0; i < number; i++) {
            vendingMachineController.insertCoin(coin);
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
        addCoinsToCoinAcceptor(4, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.POP));
        addCoinsToCoinAcceptor(4, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.CHIPS));
        addCoinsToCoinAcceptor(4, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.CANDY));
    }

    @Test
    public void selectProductWithMoreThanEnoughMoneyReturnsChange() {
        addCoinsToCoinAcceptor(5, Coin.QUARTER);
        assertTrue(vendingMachineController.selectProduct(Product.POP));
        List<Coin> changeCollected = vendingMachineController.getCoinsFromReturnSlot();
        assertEquals(1, changeCollected.size());
        assertEquals(Coin.QUARTER, changeCollected.get(0));
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
        addCoinsToCoinAcceptor(3, Coin.QUARTER);
        addCoinsToCoinAcceptor(2, Coin.DIME);
        addCoinsToCoinAcceptor(1, Coin.NICKEL);
        vendingMachineController.returnCoins();
        List<Coin> changeCollected = vendingMachineController.getCoinsFromReturnSlot();
        assertEquals(6, changeCollected.size());
        assertTrue(changeCollected.contains(Coin.NICKEL));
    }

    @Test
    public void whenCoinInsertedThenDisplayShowsAmount() {
        addCoinsToCoinAcceptor(1, Coin.QUARTER);
        assertEquals("$0.25", vendingMachineController.getDisplayPrompt());
    }

    @Test
    public void afterChangeRequestedThenDisplayShowsInsertCoin() {
        addCoinsToCoinAcceptor(1, Coin.QUARTER);
        vendingMachineController.returnCoins();
        assertEquals(Display.INSERT_COIN, vendingMachineController.getDisplayPrompt());
    }

}