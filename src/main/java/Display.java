public class Display {
    static final String INSERT_COIN = "INSERT COIN";
    static final String EXACT_CHANGE_ONLY = "EXACT CHANGE ONLY";
    static final String OUT_OF_STOCK = "OUT OF STOCK";

    private boolean requireExactChange;
    private boolean outOfStock = false;
    private double selectedProductPrice;

    public Display(boolean requireExactChange) {
        this.requireExactChange = requireExactChange;
    }

    public String getPrompt(double amountInserted) {
        if(amountInserted == 0) {
            return getPromptNoMoneyInserted();
        }
        if(outOfStock) {
            setOutOfStock(false);
            return OUT_OF_STOCK;
        }
        return formatDoubleToString(amountInserted);
    }

    private String getPromptNoMoneyInserted() {
        if(requireExactChange) {
            return EXACT_CHANGE_ONLY;
        }
        else if(selectedProductPrice != 0) {
            String result = formatDoubleToString(selectedProductPrice);
            selectedProductPrice = 0;
            return result;
        }
        else {
            return INSERT_COIN;
        }
    }

    public void setRequireExactChange(boolean requireExactChange) {
        this.requireExactChange = requireExactChange;
    }

    public void selectProduct(double selectedProductPrice) {
        this.selectedProductPrice = selectedProductPrice;
    }

    /**
     * Return the passed double as a String in the format "$x.xx".
     */
    private String formatDoubleToString(double number) {
        String result = String.valueOf(number);
        if (result.length() == 3) {
            result += "0";
        }
        return "$" + result;
    }

    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

}
