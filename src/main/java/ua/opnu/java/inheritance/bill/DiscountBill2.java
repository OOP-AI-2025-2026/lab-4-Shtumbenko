package ua.opnu.java.inheritance.bill;

public class DiscountBill2 {
    private GroceryBill bill;
    private int discountCount;
    private double discountAmount;
    private boolean preferred;

    public DiscountBill2(Employee clerk, boolean preferred) {
        this.bill = new GroceryBill(clerk);
        this.discountCount = 0;
        this.discountAmount = 0.0;
        this.preferred = preferred;
    }

    public void add(Item i) {
        this.bill.add(i);

        if (this.preferred && i.getDiscount() > 0) { // [cite: 246]
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        double originalTotal = this.bill.getTotal();
        double finalTotal = originalTotal - this.discountAmount;

        return Math.round(finalTotal * 100.0) / 100.0;
    }

    public Employee getClerk() {
        return this.bill.getClerk();
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        double originalTotal = this.bill.getTotal();
        if (originalTotal == 0.0) {
            return 0.0;
        }
        return (this.discountAmount / originalTotal) * 100.0;
    }
}
