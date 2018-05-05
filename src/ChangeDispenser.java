public class ChangeDispenser {
    private CoinAcceptor coinAcceptor;

    public ChangeDispenser(CoinAcceptor coinAcceptor) {
        this.coinAcceptor = coinAcceptor;
    }

    public Coin[] dispenseChange (double amount) {
        Coin[] change = {};
        if (amount > coinAcceptor.getInsertedValue())
        {
            return change;
        }
        return new Coin[] {Coin.QUARTER};
    }
}
