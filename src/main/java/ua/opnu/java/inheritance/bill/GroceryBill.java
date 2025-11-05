package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;
    private List<Item> items;
    private double total;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void add(Item i) {
        items.add(i);
        total += i.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public Employee getClerk() {
        return clerk;
    }
}
