import java.util.ArrayList;
import java.util.List;

public class ChangeDispenser {
    private CoinAcceptor coinAcceptor;

    public ChangeDispenser(CoinAcceptor coinAcceptor) {
        this.coinAcceptor = coinAcceptor;
    }

    public List<Coin> dispenseChange(double amount) {
        List<Coin> change = new ArrayList<>(coinAcceptor.getStagedCoins());
        if (amount > coinAcceptor.getInsertedValue()) {
            coinAcceptor.clearStagedCoins();
            return change;
        }
        else if (amount == coinAcceptor.getInsertedValue() && !change.isEmpty()) {
            coinAcceptor.clearStagedCoins();
            return change;
        }
        else {
            change.clear();
            return coinsToReturn(amount, change);
        }
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
