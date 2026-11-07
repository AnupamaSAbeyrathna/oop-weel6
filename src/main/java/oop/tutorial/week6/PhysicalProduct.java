package oop.tutorial.week6;

import oop.tutorial.week6.service.interfaces.Discountable;

// A PhysicalProduct IS-A Product because it inherites from the Product class
// Cashier
public class PhysicalProduct extends Product implements Discountable{

    private double discountedPrice;
    private double weightKg;
    private String demensions;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String demensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.demensions = demensions;
    }

    public double getWeightKg() { return weightKg; }
    public String getDemensions() { return demensions; }

    @Override 
    public String getSummary() {
        return "Physical: " + getName() + " | Weight:" + getWeightKg();
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped); 
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
