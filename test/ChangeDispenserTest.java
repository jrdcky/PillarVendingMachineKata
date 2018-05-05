import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ChangeDispenserTest {

    CoinAcceptor coinAcceptor;
    ChangeDispenser changeDispenser;

    @Before
    public void setUp() {
        coinAcceptor = new CoinAcceptor();
    }

    private void addQuartersToCoinAcceptor(int quarters) {
        for (int i = 0; i < quarters; i++) {
            coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
    }

    private boolean areListsEqual(List<Coin> list1, List<Coin> list2) {
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void inserted75CentsDispense25CentsReturnsTwoQuarters() {
        addQuartersToCoinAcceptor(3);
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        changeExpected.add(Coin.QUARTER);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.25);

        assertTrue(areListsEqual(changeExpected, changeDispensed));
    }

    @Test
    public void inserted50CentsDispense75CentsReturnsEmpty() {
        addQuartersToCoinAcceptor(2);
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.75);

        assertTrue(changeDispensed.isEmpty());
    }

    @Test
    public void inserted75CentsDispense10CentsReturnsDime() {
        addQuartersToCoinAcceptor(3);
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        changeExpected.add(Coin.DIME);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.10);

        assertTrue(areListsEqual(changeExpected, changeDispensed));
    }

}