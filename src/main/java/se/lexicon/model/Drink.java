package se.lexicon.model;

import java.util.Objects;

public class Drink extends Product {

    private String volume;
    private String calories;
    private boolean carbonic_acid;

    public Drink(){
    }

    public Drink(int productId, String name, int price, String volume, String calories, boolean carbonic_acid) {
        super(productId, name, price);
        this.volume = volume;
        this.calories = calories;
        this.carbonic_acid = carbonic_acid;
    }

    @Override
    public String Examine(){
        return "Name: " + getProductName() + " " +
                "Price " + getPrice() + " " +
                "Calories " + getCalories();
    }

    @Override
    public String Use(){
        return "consumed";
    }

    //Generate getters/setters
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public boolean isCarbonic_acid() {
        return carbonic_acid;
    }

    public void setCarbonic_acid(boolean carbonic_acid) {
        this.carbonic_acid = carbonic_acid;
    }

    //Generate equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return carbonic_acid == drink.carbonic_acid && Objects.equals(volume, drink.volume) && Objects.equals(calories, drink.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, calories, carbonic_acid);
    }

    //Generate toString
    @Override
    public String toString() {
        return super.toString() +
                "volume='" + volume + '\'' +
                ", calories='" + calories + '\'' +
                ", carbonic_acid=" + carbonic_acid +
                '}';
    }
}
