public class VendingMachineController {

    private Display display;
    private StockKeeper stockKeeper;
    public VendingMachineController() {
        display = new Display(false);
        stockKeeper = new StockKeeper(10, 10, 10);
    }

    public boolean selectPop() {
        display.selectProduct(stockKeeper.getPopPrice());
        return false;
    }

    public boolean selectChips() {
        display.selectProduct(stockKeeper.getChipsPrice());
        return false;
    }

    public String getDisplayPrompt() {
        return display.getPrompt(0);
    }

}
