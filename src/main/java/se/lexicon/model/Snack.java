package se.lexicon.model;

import java.util.Objects;

public class Snack extends Product {

    //Todo: add calories
    private String sugarPercent;
    private int quantity;
    private SnackType snackType;

    public Snack(){
    }

    public Snack(int productId, String name, int price, String sugarPercent, int quantity, SnackType snackType) {
        super(productId, name, price);
        this.sugarPercent = sugarPercent;
        this.quantity = quantity;
        this.snackType = snackType;
    }

    @Override
    public String Examine(){
        return "Name: " + getName() + " " +
                "Price " + getPrice() + " " +
                "SugarPercent " + getSugarPercent() + " " +
                "Type of Snack" + getSnackType();
    }

    @Override
    public String Use(){
        return "consumed";
    }

    //Generate Getter/Setters
    public String getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(String sugarPercent) {
        this.sugarPercent = sugarPercent;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SnackType getSnackType() {
        return snackType;
    }

    public void setSnackType(SnackType snackType) {
        this.snackType = snackType;
    }

    //Equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Snack snack = (Snack) o;
        return quantity == snack.quantity && Objects.equals(sugarPercent, snack.sugarPercent) && snackType == snack.snackType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sugarPercent, quantity, snackType);
    }

    //Generate toString

    @Override
    public String toString() {
        return super.toString()+"Snack{" +
                "sugarPercent='" + sugarPercent + '\'' +
                ", quantity=" + quantity +
                ", snackType=" + snackType +
                '}';
    }
}
