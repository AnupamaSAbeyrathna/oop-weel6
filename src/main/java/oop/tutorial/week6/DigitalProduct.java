package oop.tutorial.week6;

import oop.tutorial.week6.service.interfaces.Discountable;

public class DigitalProduct extends Product implements Discountable{

    private double discountedPrice;
    private String downloadUrl;
    private double fileSizeMB;

    public DigitalProduct () {}

    public DigitalProduct(Long id,
                          String name,
                          double price,
                          String downloadUrl,
                          double fileSize) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSize;
    }

     
    @Override 
    public String getSummary() { 
        return "Digital: " + getName() + " | DownloadUrl: " + downloadUrl; 
    } 
  
    public String getDownloadUrl() { 
        return downloadUrl; 
    } 

    public double getFileSizeMB() { 
        return fileSizeMB; 
    } 

    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
        // TODO Auto-generated method stub
        // TODO: return the field 
    }

}
