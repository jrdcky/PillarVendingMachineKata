import java.util.ArrayList;
import java.util.List;

public class ChangeDispenser {
    private CoinAcceptor coinAcceptor;

    public ChangeDispenser(CoinAcceptor coinAcceptor) {
        this.coinAcceptor = coinAcceptor;
    }

    public List<Coin> dispenseChange(double amount) {
        ArrayList<Coin> change = new ArrayList<>();
        if (amount > coinAcceptor.getInsertedValue()) {
            return change;
        }

        return coinsToReturn(amount, change);
    }

    private List<Coin> coinsToReturn(double amount, List<Coin> change) {
        if (amount >= .25) {
            change.add(Coin.QUARTER);
            return coinsToReturn(amount - .25, change);
        } else if (amount >= .10) {
            change.add(Coin.DIME);
            return coinsToReturn(amount - .10, change);
        } else if (amount >= .05) {
            change.add(Coin.NICKEL);
            return coinsToReturn(amount - .5, change);
        } else {
            return change;
        }
    }
}
