import java.util.ArrayList;
import java.util.List;

public class VendingMachineController {

    private List<Coin> returnSlot;
    private Display display;
    private StockKeeper stockKeeper;
    private CoinAcceptor coinAcceptor;
    private ChangeDispenser changeDispenser;

    public VendingMachineController(int pop, int chips, int candy, int quarters, int dimes, int nickels) {
        returnSlot = new ArrayList<>();
        display = new Display(false);
        coinAcceptor = new CoinAcceptor(quarters, dimes, nickels);
        changeDispenser = new ChangeDispenser(coinAcceptor);
        stockKeeper = new StockKeeper(pop, chips, candy);
    }

    public boolean selectProduct(Product product) {
        double price = product.getPrice();
        display.selectProduct(price);
        if(coinAcceptor.getInsertedValue() >= price && checkStock(product)) {
            coinAcceptor.subtractValue(price);
            returnSlot.addAll(changeDispenser.dispenseChange(coinAcceptor.getInsertedValue()));
            return true;
        }
        else {
            return false;
        }
    }

    public String getDisplayPrompt() {
        display.setRequireExactChange(coinAcceptor.getNeedExactChange());
        return display.getPrompt(coinAcceptor.getInsertedValue());
    }

    public void insertCoin(Coin coin) {
        if (!coinAcceptor.insertCoin(coin)) {
            returnSlot.add(coin);
        }
    }

    public void returnCoins() {
            returnSlot.addAll(changeDispenser.dispenseChange(coinAcceptor.getInsertedValue()));
            coinAcceptor.setInsertedValue(0);
    }

    public List<Coin> getCoinsFromReturnSlot() {
        return returnSlot;
    }

    private boolean checkStock(Product product) {
        if (stockKeeper.isProductInStock(product)){
            display.setOutOfStock(false);
            return true;
        }
        else {
            display.setOutOfStock(true);
            return false;
        }
    }

}
