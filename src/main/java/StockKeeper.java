public class StockKeeper {
    private int pop;
    private int chips;
    private int candy;

    public StockKeeper(int pop, int chips, int candy) {
        this.pop = pop;
        this.chips = chips;
        this.candy = candy;
    }

    public boolean isProductInStock(Product product) {
        switch (product) {
            case POP:
                if(pop >= 1) {
                    return true;
                }
                break;
            case CHIPS:
                if(chips >= 1) {
                    return true;
                }
                break;
            case CANDY:
                if(candy >= 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean buyProduct(Product product) {
        if (isProductInStock(product)) {
            switch (product) {
                case POP:
                    pop -= 1;
                    break;
                case CHIPS:
                    chips -= 1;
                    break;
                case CANDY:
                    candy -= 1;
            }
            return true;
        }
        return false;
    }

}
