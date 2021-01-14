package se.lexicon.model;

import java.util.Objects;

public abstract class Drink extends Product {

    private String volume;
    private String cal;
    private boolean carbonic_acid;

    public Drink(){
    }

    public Drink(int productId, String name, int price, String volume, String cal, boolean carbonic_acid) {
        super(productId, name, price);
        this.volume = volume;
        this.cal = cal;
        this.carbonic_acid = carbonic_acid;
    }

    @Override
    public String Examine(){
        return "Name: " + getName() + " " +
                "Price " + getPrice() + " " +
                "Calories " + getCal();
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

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
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
        return carbonic_acid == drink.carbonic_acid && Objects.equals(volume, drink.volume) && Objects.equals(cal, drink.cal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, cal, carbonic_acid);
    }

    //Generate toString
    @Override
    public String toString() {
        return "Drink{" +
                "volume='" + volume + '\'' +
                ", cal='" + cal + '\'' +
                ", carbonic_acid=" + carbonic_acid +
                '}';
    }
}
