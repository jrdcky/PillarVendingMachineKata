public class ChangeDispenser {
    private CoinAcceptor coinAcceptor;

    public ChangeDispenser(CoinAcceptor coinAcceptor) {
        this.coinAcceptor = coinAcceptor;
    }

    public Coin[] dispenseChange (double amount) {
        return new Coin[] {Coin.QUARTER};
    }
}
