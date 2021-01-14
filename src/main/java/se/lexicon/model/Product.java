package se.lexicon.model;

import java.util.Objects;

public abstract class Product {
    private final int productNumber;
    private String Name;
    private int price;

    //Generate empty and full constructor
    public Product() {
        productNumber = ProductSequencer.NextId();
    }

    public Product(int productNumber, String name, int price) {
        this.productNumber = productNumber;
        Name = name;
        this.price = price;
    }

    //Abstract methods
    public abstract String Examine();
    public abstract String Use();

    //Generate getters/setters
    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
        return productNumber == product.productNumber && price == product.price && Objects.equals(Name, product.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNumber, Name, price);
    }


    //Generate toString
    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", Name='" + Name + '\'' +
                ", price=" + price +
                '}';
    }
}
