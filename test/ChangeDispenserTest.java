import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class ChangeDispenserTest {

    @Test
    public void inserted75CentsDispense25Cents() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        ChangeDispenser changeDispenser;
        for(int i = 0; i < 3; i++) {
            coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
        changeDispenser = new ChangeDispenser(coinAcceptor);
        Coin changeExpected[] = {Coin.QUARTER};
        Coin changeDispensed[] = changeDispenser.dispenseChange(.25);

        assertTrue(Arrays.equals(changeExpected, changeDispensed));
    }

}