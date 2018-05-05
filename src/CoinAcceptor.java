public class CoinAcceptor {
    private static final Coin[] validCoins = {Coin.QUARTER, Coin.DIME, Coin.NICKEL};
    private double insertedValue = 0;

    public boolean insertCoin(double weight, double diameter, double width) {
        for (Coin coin : validCoins) {
            if (weight == coin.getWeight() && diameter == coin.getDiameter() && width == coin.getWidth()) {
                insertedValue += getValueOfCoin(coin);
                return true;
            }
        }
        return false;
    }

    public double getValueOfCoin(Coin coin) {
        switch(coin) {
            case QUARTER:
                return .25;
            case DIME:
                return .10;
            case NICKEL:
                return .05;
            default:
                return 0;
        }
    }

    public double getInsertedValue() {
        return insertedValue;
    }
}
