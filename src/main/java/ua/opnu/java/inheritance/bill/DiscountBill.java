package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {
    private int discountCount = 0;
    private double discountAmount = 0.0;
    private boolean preferred;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
    }

    @Override
    public void add(Item i) {
        super.add(i);

        if (this.preferred && i.getDiscount() > 0) {
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public double getTotal() {
        double originalTotal = super.getTotal();
        double finalTotal = originalTotal - this.discountAmount;

        return Math.round(finalTotal * 100.0) / 100.0;
    }

    public double getDiscountPercent() {
        double originalTotal = super.getTotal();
        if (originalTotal == 0.0) {
            return 0.0;
        }
        return (this.discountAmount / originalTotal) * 100.0;
    }
}
