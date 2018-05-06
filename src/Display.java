public class Display {
    static final String INSERT_COIN = "INSERT COIN";
    static final String EXACT_CHANGE_ONLY = "EXACT CHANGE ONLY";
    private boolean requireExactChange;

    public Display(boolean requireExactChange) {
        this.requireExactChange = requireExactChange;
    }

    public String getPrompt(double amountInserted) {
        if(amountInserted == 0) {
            return getPromptNoMoneyInserted();
        }
        return "$" + String.valueOf(amountInserted);
    }

    private String getPromptNoMoneyInserted() {
        if(requireExactChange) {
            return EXACT_CHANGE_ONLY;
        }
        else {
            return INSERT_COIN;
        }
    }

    public void setRequireExactChange(boolean requireExactChange) {
        this.requireExactChange = requireExactChange;
    }

}
