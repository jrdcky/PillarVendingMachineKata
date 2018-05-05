public class ChangeDispenser {
    private CoinAcceptor coinAcceptor;

    public ChangeDispenser(CoinAcceptor coinAcceptor) {
        this.coinAcceptor = coinAcceptor;
    }

    public double dispenseChange() {
        return .25;
    }
}
