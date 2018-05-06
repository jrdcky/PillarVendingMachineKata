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

    public boolean selectPop() {
        double price = stockKeeper.getPopPrice();
        display.selectProduct(price);
        if(coinAcceptor.getInsertedValue() >= price) {
            coinAcceptor.subtractValue(price);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean selectChips() {
        display.selectProduct(stockKeeper.getChipsPrice());
        if(coinAcceptor.getInsertedValue() >= stockKeeper.getChipsPrice()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean selectCandy() {
        display.selectProduct(stockKeeper.getCandyPrice());
        if(coinAcceptor.getInsertedValue() >= stockKeeper.getCandyPrice()) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getDisplayPrompt() {
        return display.getPrompt(0);
    }

    public void insertCoin(double weight, double diameter, double width) {
        coinAcceptor.insertCoin(weight, diameter, width);
    }

    public List<Coin> getCoinsFromReturnSlot() {
        return changeDispenser.dispenseChange(coinAcceptor.getInsertedValue());
    }

}
