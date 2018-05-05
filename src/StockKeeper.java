public class StockKeeper {

    private static final double POP_PRICE = 1.00;
    private static final double CANDY_PRICE = .65;
    private static final double CHIPS_PRICE = .50;
    private int pop;
    private int chips;
    private int candy;

    public StockKeeper(int pop, int chips, int candy) {
        this.pop = pop;
        this.chips = chips;
        this.candy = candy;
    }

    public boolean isPopInStock() {
        if (pop >= 1){
            return true;
        }
        return false;
    }

    public boolean isChipsInStock() {
        if (chips >= 1){
            return true;
        }
        return false;
    }

    public boolean isCandyInStock() {
        if (candy >= 1){
            return true;
        }
        return false;
    }

    public double getPopPrice () {
        return POP_PRICE;
    }

    public double getCandyPrice() {
        return CANDY_PRICE;
    }

    public double getChipsPrice() {
        return CHIPS_PRICE;
    }

    public boolean buyPop() {
        if (isPopInStock()) {
            pop -= 1;
            return true;
        }
        return false;
    }

    public boolean buyCandy() {
        if (isCandyInStock()) {
            candy -= 1;
            return true;
        }
        return false;
    }

    public boolean buyChips() {
        if (isChipsInStock()) {
            chips -= 1;
            return true;
        }
        return false;
    }
}
