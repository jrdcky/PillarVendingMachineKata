public class VendingMachineController {

    private Display display;
    private StockKeeper stockKeeper;
    private CoinAcceptor coinAcceptor;

    public VendingMachineController() {
        display = new Display(false);
        coinAcceptor = new CoinAcceptor();
        stockKeeper = new StockKeeper(10, 10, 10);
    }

    public boolean selectPop() {
        display.selectProduct(stockKeeper.getPopPrice());
        if(coinAcceptor.getInsertedValue() >= stockKeeper.getPopPrice()) {
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
        return false;
    }

    public String getDisplayPrompt() {
        return display.getPrompt(0);
    }

    public void insertCoin(double weight, double diameter, double width) {
        coinAcceptor.insertCoin(weight, diameter, width);
    }

}
