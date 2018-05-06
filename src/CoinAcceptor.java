import java.util.ArrayList;
import java.util.List;

public class CoinAcceptor {
    private double insertedValue = 0;
    private List<Coin> stagedCoins = new ArrayList<>();

    public boolean insertCoin(Coin coin) {
        double value = getValueOfCoin(coin);
        if (value != 0)
        {
            insertedValue += getValueOfCoin(coin);
            stagedCoins.add(coin);
            return true;
        }
        return false;
    }

    public double getValueOfCoin(Coin coin) {
        if (coin.equals(Coin.QUARTER)) {
            return .25;
        } else if (coin.equals(Coin.DIME)) {
            return .10;
        } else if (coin.equals(Coin.NICKEL)) {
            return .05;
        } else
            return 0;
    }

    public double getInsertedValue() {
        return insertedValue;
    }

    public void subtractValue(double value) {
        stagedCoins.clear();
        insertedValue -= value;
    }

    public List<Coin> getStagedCoins() {
        return stagedCoins;
    }

    public void clearStagedCoins() {
        stagedCoins.clear();
    }

    public void setInsertedValue(double insertedValue) {
        this.insertedValue = insertedValue;
    }
}
