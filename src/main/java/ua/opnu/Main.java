package ua.opnu;

import ua.opnu.java.inheritance.account.*;
import ua.opnu.java.inheritance.bill.DiscountBill;
import ua.opnu.java.inheritance.bill.DiscountBill2;
import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;
import ua.opnu.point.Point;
import ua.opnu.point.Point3D;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Тестування Завдання 1 і 4: DiscountBill vs DiscountBill2 ---");

        Employee clerk = new Employee("Іван");
        Item bread = new Item("Хліб", 20.0, 0.0);
        Item milk = new Item("Молоко", 35.0, 5.0);

        System.out.println("--- 1. Тест 'DiscountBill' (Успадкування, Preferred=true) ---");

        DiscountBill bill1 = new DiscountBill(clerk, true);
        bill1.add(bread);
        bill1.add(milk);

        System.out.println("Співробітник: " + bill1.getClerk().getName());
        System.out.println("Товарів зі знижкою: " + bill1.getDiscountCount());
        System.out.println("Сума знижки: " + bill1.getDiscountAmount());
        System.out.println("Разом до сплати (Успадкування): " + bill1.getTotal());

        System.out.println("\n--- 2. Тест 'DiscountBill2' (Композиція, Preferred=false) ---");

        DiscountBill2 bill2 = new DiscountBill2(clerk, false);
        bill2.add(bread);
        bill2.add(milk);

        System.out.println("Співробітник: " + bill2.getClerk().getName());
        System.out.println("Товарів зі знижкою: " + bill2.getDiscountCount());
        System.out.println("Сума знижки: " + bill2.getDiscountAmount());
        System.out.println("Разом до сплати (Композиція): " + bill2.getTotal());

        System.out.println("\n--- Тестування Завдання (Point3D, Успадкування) ---");

        Point p2d = new Point(3, 4);
        Point3D p3d_1 = new Point3D(1, 2, 2);
        Point3D p3d_2 = new Point3D(4, 6, 14);

        System.out.println("2D distance from origin: " + p2d.distanceFromOrigin());
        System.out.println("3D distance from origin: " + p3d_1.distanceFromOrigin());
        System.out.println("3D to 3D distance: " + p3d_1.distance(p3d_2));
        System.out.println("3D to 2D distance: " + p3d_1.distance(p2d));

        System.out.println("\n--- Тестування Завдання (MinMaxAccount, Композиція) ---");
        Startup startInfo1 = new Startup(1000);

        MinMaxAccount acc1 = new MinMaxAccount(startInfo1);
        System.out.println("Початковий баланс: " + acc1.getBalance());
        System.out.println("Min: " + acc1.getMin() + ", Max: " + acc1.getMax());

        acc1.debit(new Debit(200));
        System.out.println("Баланс: " + acc1.getBalance());
        System.out.println("Min: " + acc1.getMin() + ", Max: " + acc1.getMax());

        acc1.credit(new Credit(500));
        System.out.println("Баланс: " + acc1.getBalance());
        System.out.println("Min: " + acc1.getMin() + ", Max: " + acc1.getMax());
    }
}
