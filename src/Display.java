public class Display {
    static final String INSERT_COIN = "INSERT COIN";

    public String getPrompt(double amountInserted) {
        if(amountInserted == 0) {
            return INSERT_COIN;
        }
        return "$" + String.valueOf(amountInserted);
    }
}
