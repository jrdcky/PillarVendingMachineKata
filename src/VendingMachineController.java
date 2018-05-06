import java.util.ArrayList;
import java.util.List;

public class VendingMachineController {

    private List<Coin> returnSlot;
    private Display display;
    private StockKeeper stockKeeper;
    private CoinAcceptor coinAcceptor;
    private ChangeDispenser changeDispenser;

    public VendingMachineController() {
        returnSlot = new ArrayList<>();
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
            returnSlot.addAll(changeDispenser.dispenseChange(coinAcceptor.getInsertedValue()));
            return true;
        }
        else {
            return false;
        }
    }

    public String getDisplayPrompt() {
        return display.getPrompt(coinAcceptor.getInsertedValue());
    }

    public void insertCoin(Coin coin) {
        if (!coinAcceptor.insertCoin(coin)) {
            returnSlot.add(coin);
        }
    }

    public void returnCoins() {
            returnSlot.addAll(changeDispenser.dispenseChange(coinAcceptor.getInsertedValue()));
    }

    public List<Coin> getCoinsFromReturnSlot() {
        return returnSlot;
    }

}
