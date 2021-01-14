package se.lexicon.model;

import java.util.Objects;

public abstract class Food extends Product {

    private int calories;
    private Protein protein;

    public Food(){

    }

    public Food(int productId, String name, int price, int calories, Protein protein) {
        super(productId, name, price);
        this.calories = calories;
        this.protein = protein;
    }

    //Generate getters/setters


    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
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
        return "Food{" +
                "calories=" + calories +
                ", protein=" + protein +
                '}';
    }
}
