import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ChangeDispenserTest {

    @Test
    public void inserted75CentsDispense25CentsReturnsTwoQuarters() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        ChangeDispenser changeDispenser;
        for(int i = 0; i < 3; i++) {
            coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        changeExpected.add(Coin.QUARTER);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.25);

        assertTrue(changeExpected.get(0) == changeDispensed.get(0));
    }

    @Test
    public void inserted50CentsDispense75CentsReturnsEmpty() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        ChangeDispenser changeDispenser;
        for(int i = 0; i < 2; i++) {
            coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.75);

        assertTrue(changeExpected.equals(changeDispensed));
    }

    @Test
    public void inserted75CentsDispense10CentsReturnsDime() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        ChangeDispenser changeDispenser;
        for(int i = 0; i < 3; i++) {
            coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        changeExpected.add(Coin.DIME);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.10);

        assertTrue(changeExpected.equals(changeDispensed));
    }

}