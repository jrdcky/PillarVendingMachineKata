import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    @Test
    public void selectProductWithNoMoneyReturnsPrice() {
        VendingMachineController vendingMachineController = new VendingMachineController();
        assertFalse(vendingMachineController.selectPop());
        assertEquals("$1.00", vendingMachineController.getDisplayPrompt());
        assertFalse(vendingMachineController.selectChips());
    }

}