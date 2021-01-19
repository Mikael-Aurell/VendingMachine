package se.lexicon;


import org.junit.Before;
import org.junit.Test;
import se.lexicon.data.ProductData;
import se.lexicon.data.ProductDataImpl;
import se.lexicon.model.Drink;
import se.lexicon.model.Food;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;


import static se.lexicon.model.Protein.CHICKEN;
import static se.lexicon.model.SnackType.BAR;


public class AppTest {
    ProductData productData = new ProductDataImpl();

    @Before
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
}
