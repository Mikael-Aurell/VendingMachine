package se.lexicon.model;

import java.util.Objects;

public class Food extends Product {
    private String calories;
    private Protein protein;

    public Food(){
    }

    public Food(int productId, String name, int price, String calories, Protein protein) {
        super(productId, name, price);
        this.calories = calories;
        this.protein = protein;
    }

    @Override
    public String Examine(){
        return "Name: " + getProductName() + " " +
                "Price " + getPrice() + " " +
                "Calories " + getCalories() + " " +
                "Protein" + getProteinType();
    }

    @Override
    public String Use(){
        return "consumed";
    }

    //Generate getters/setters
    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Protein getProteinType() {
        return protein;
    }

    public void setProteinType(Protein protein) {
        this.protein = protein;
    }

    //Generate equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return calories == food.calories && protein == food.protein;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), calories, protein);
    }

    //Generate toString
    @Override
    public String toString() {
        return super.toString()+"Food{" +
                "calories=" + calories +
                ", protein=" + protein +
                '}';
    }
}
