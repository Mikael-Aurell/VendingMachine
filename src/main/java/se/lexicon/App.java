package se.lexicon;


import se.lexicon.data.ProductData;
import se.lexicon.data.ProductDataImpl;
import se.lexicon.model.Drink;
import se.lexicon.model.Food;
import se.lexicon.model.Snack;

import java.util.Scanner;

import static se.lexicon.model.Protein.CHICKEN;
import static se.lexicon.model.SnackType.BAR;

public class App
{
    public static void main( String[] args )
    {
        ProductData productData = new ProductDataImpl();
        while(true){
            System.out.println("#################################################");
            System.out.println("#### VENDING MACHINE PROGRAM ####################");
            System.out.println("### 1. add Drink");
            System.out.println("### 2. add Food");
            System.out.println("### 3. add Snack");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a valid operation number: ");
            String operationType = scanner.nextLine();

            switch (operationType) {
                case "1":
                    Drink aCoke = new Drink();
                        aCoke.setName("Coke");
                        aCoke.setPrice(15);
                        aCoke.setVolume("33 cl");
                        aCoke.setCalories("105 kcal");

                        aCoke.setCarbonic_acid(true);
                    System.out.println(aCoke);
                case "2":
                    Food aChickenBaguette = new Food();
                    aChickenBaguette.setName("Chicken");
                    aChickenBaguette.setPrice(15);
                    aChickenBaguette.setProteinType(CHICKEN);
                    aChickenBaguette.setCalories("402 kcal");

                    System.out.println(aChickenBaguette);
                case "3":
                    Snack aSnickers = new Snack();
                    aSnickers.setName("Snickers");
                    aSnickers.setPrice(15);
                    aSnickers.setSnackType(BAR);
                    //aCoke.setCal("105 kcal"); Todo: need to add variable calories in class Snack

                    System.out.println(aSnickers);
                default:
                    System.out.println(operationType +"operation type is not valid");
                    }

            }

        }
    }

