public class CoinAcceptor {
    private static final Coin[] validCoins = {Coin.QUARTER, Coin.DIME, Coin.NICKEL};

    public boolean insertCoin(double weight, double diameter, double width) {
        for (Coin coin : validCoins) {
            if (weight == coin.getWeight() && diameter == coin.getDiameter() && width == coin.getWidth()) {
                return true;
            }
        }
        return false;
    }

    public double getInsertedValue() {
        return .25;
    }
}
