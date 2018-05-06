public class CoinAcceptor {
    private double insertedValue = 0;

    public boolean insertCoin(Coin coin) {
        double value = getValueOfCoin(coin);
        if (value != 0)
        {
            insertedValue += getValueOfCoin(coin);
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
        insertedValue -= value;
    }
}
