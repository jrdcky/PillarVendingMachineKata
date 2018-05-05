import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ChangeDispenserTest {

    @Test
    public void inserted75CentsCost50CentsReturns25Cents() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        ChangeDispenser changeDispenser;
        for(int i = 0; i < 3; i++) {
            coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth());
        }
        changeDispenser = new ChangeDispenser(coinAcceptor);
        assertEquals(.25, changeDispenser.dispenseChange());
    }

}