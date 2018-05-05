public enum Coin {
    QUARTER (5.670, .955, .069);

    private final double weight;
    private final double diameter;
    private final double width;

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
