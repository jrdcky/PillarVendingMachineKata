public enum Product {
    POP (1.00),
    CHIPS (.50),
    CANDY (.65);

    private final double price;

    Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
