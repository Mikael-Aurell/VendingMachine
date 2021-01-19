package se.lexicon;


import se.lexicon.data.ProductData;
import se.lexicon.data.ProductDataImpl;
import se.lexicon.model.Drink;
import se.lexicon.model.Food;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;

import java.util.Arrays;
import java.util.Scanner;

import static se.lexicon.model.Protein.CHICKEN;
import static se.lexicon.model.SnackType.BAR;

public class App
{
    public static void main( String[] args )
    {
        ProductData productData = new ProductDataImpl();

        Drink aCoke = new Drink();
        aCoke.setName("Coke");
        aCoke.setPrice(15);
        aCoke.setVolume("33 cl");
        aCoke.setCalories("105 kcal");
        aCoke.setCarbonic_acid(true);

        Food aChickenBaguette = new Food();
        aChickenBaguette.setName("Chicken Baguette");
        aChickenBaguette.setPrice(50);
        aChickenBaguette.setProteinType(CHICKEN);
        aChickenBaguette.setCalories("402 kcal");

        Snack aSnickers = new Snack();
        aSnickers.setName("Snickers");
        aSnickers.setPrice(10);
        aSnickers.setSnackType(BAR);

        productData.AddProduct(aCoke); //id=1
        productData.AddProduct(aChickenBaguette); //id=2
        productData.AddProduct(aSnickers); //id=3

        while(true){

            System.out.println("#################################################");
            System.out.println("#### VENDING MACHINE PROGRAM ####################");

            System.out.println("### 1. Deposit Money");
            System.out.println("### 2. Get Balance");
            System.out.println("### 3. Show All Products");
            System.out.println("### 4. Buy a Product");
            System.out.println("### 5. View Single Product Description");
            System.out.println("### 0. End Session (CASH OUT");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a valid operation number: ");
            String operationType = scanner.nextLine();


            switch (operationType) {

                case "1": //Deposit money
                    Scanner scAddCurrency = new Scanner(System.in);
                    System.out.println("Insert preferable money: ");
                    productData.AddCurrency(scAddCurrency.nextInt());
                    System.out.println(productData.GetBalance());
                    break;

                case "2": //Get Balance
                    System.out.println("Your Balance are: "+productData.GetBalance() + " SEK.");
                    break;

                case "3": //Gets All Product names and numbers
                    System.out.println(Arrays.toString(productData.GetProducts()));
                    break;

                case "4":
                    System.out.println(Arrays.toString(productData.GetProducts()));
                    Scanner scChooseProductToBuy = new Scanner(System.in);
                    System.out.println("Type the number of the product you want to buy: ");
                    Product theProductToBuy = productData.Request(scChooseProductToBuy.nextInt());
                    break;

                case "5":
                    System.out.println(Arrays.toString(productData.GetProducts()));
                    Scanner theProductToShow = new Scanner(System.in);
                    System.out.println("Choose productnumber");
                    System.out.println(productData.GetDescription(theProductToShow.nextInt()));
                    break;

                case "0":
                    int withdraw[] = productData.EndSession();
                    System.out.println("The denominations are: ");
                    for(int i=0;i<withdraw.length;i++)
                    System.out.println(withdraw[i]+"kr");
                    break;

                default:
                    System.out.println("operation type is not valid");
                    break;
            }
        }
    }
}
