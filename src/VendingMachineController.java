public class VendingMachineController {

    Display display;
    public VendingMachineController() {
        display = new Display(false);
    }

    public boolean selectPop() {
        return false;
    }

    public boolean selectChips() {
        return false;
    }

    public String getDisplay() {
        return "$1.00";
    }

}
