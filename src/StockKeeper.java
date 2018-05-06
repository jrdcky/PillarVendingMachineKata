public class StockKeeper {
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
