public class Coin {
    public static final Coin QUARTER = new Coin(5.670, .955, .069);
    public static final Coin DIME = new Coin(2.268, .705, .053);
    public static final Coin NICKEL = new Coin(5 ,.835, .077);

    private double weight;
    private double diameter;
    private double width;

    Coin(double weight, double diameter, double width) {
        this.weight = weight;
        this.diameter = diameter;
        this.width = width;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWidth() {
        return width;
    }

    public double getWeight() {
        return weight;
    }
}
