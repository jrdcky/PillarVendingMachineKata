import java.util.List;

public class VendingMachineController {

    private Display display;
    private StockKeeper stockKeeper;
    private CoinAcceptor coinAcceptor;
    private ChangeDispenser changeDispenser;

    public VendingMachineController() {
        display = new Display(false);
        coinAcceptor = new CoinAcceptor();
        changeDispenser = new ChangeDispenser(coinAcceptor);
        stockKeeper = new StockKeeper(10, 10, 10);
    }

    public boolean selectProduct(Product product) {
        double price = product.getPrice();

        display.selectProduct(price);
        if(coinAcceptor.getInsertedValue() >= price) {
            coinAcceptor.subtractValue(price);
            return true;
        }
        else {
            return false;
        }
    }

    public String getDisplayPrompt() {
        return display.getPrompt(0);
    }

    public void insertCoin(Coin coin) {
        coinAcceptor.insertCoin(coin);
    }

    public List<Coin> getCoinsFromReturnSlot() {
        return changeDispenser.dispenseChange(coinAcceptor.getInsertedValue());
    }

}
