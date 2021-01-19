package se.lexicon.model;

import java.util.Objects;

public abstract class Product {
    private final int productNumber;
    private String productName;
    private int price;

    //Generate empty and full constructor
    public Product() {
        productNumber = ProductSequencer.NextId();
    }

    public Product(int productNumber, String productName, int price) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
    }

    //Abstract methods
    public String Examine(){
        return productName + " and costs " + price + "kr";
    }
    public String Use(){
        return "You bought "+ productName;
    }

    //Generate getters/setters
    public int getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //Generate Equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productNumber == product.productNumber && price == product.price && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNumber, productName, price);
    }


    //Generate toString
    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", Name='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
