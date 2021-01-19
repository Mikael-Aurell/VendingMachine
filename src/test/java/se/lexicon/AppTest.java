package se.lexicon;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import se.lexicon.model.*;
import se.lexicon.data.*;



import static se.lexicon.model.Protein.CHICKEN;
import static se.lexicon.model.SnackType.BAR;


public class AppTest {
    private String noMoneyErrorMsg;
    private Drink aCoke;
    private Food aChickenBaguette;
    private Snack aSnickers;
    private String[] getProducts;

    ProductData productData = new ProductDataImpl();


    @Before
    public void productImport () {
        noMoneyErrorMsg = "There is not enough money, please add more money.";

        aCoke = new Drink(1, "Coke", 15, "33 cl", "105 kcal", true);
        aChickenBaguette = new Food(2, "Chicken Baguette", 50, "402 kcal", CHICKEN);
        aSnickers = new Snack(3, "Snickers", 10, "25 %", 1, BAR);


        productData.AddProduct(aCoke);
        productData.AddProduct(aChickenBaguette);
        productData.AddProduct(aSnickers);

        getProducts = new String[3];

        getProducts[0]= "1. Coke 15 SEK";
        getProducts[1]= "2. Chicken Baguette 50 SEK";
        getProducts[2]= "3. Snickers 10 SEK";
    }

    @Test
    public void Test_Add_Products(){
        Assert.assertEquals(aCoke.toString(), productData.GetDescription(1));
    }

    @Test
    public void Test_Get_Description_For_a_Single_Product(){
        Assert.assertEquals(aSnickers.toString(), productData.GetDescription(3));
    }

    @Test
    public void Test_Get_Products(){
        Assert.assertArrayEquals(getProducts ,productData.GetProducts());

    }

    @Test
    public void Test_Add_Balance(){
        productData.AddCurrency(400);
        Assert.assertEquals(400,productData.GetBalance());
    }

    @Test
    public void Test_Try_To_Buy_With_No_Money(){
        productData.AddCurrency(49);
        Assert.assertEquals(null, productData.Request(2));
    }

    @Test
    public void Test_Buy_Products(){
        productData.AddCurrency(100);
        Assert.assertEquals(aChickenBaguette.getProductName(), productData.Request(2).getProductName());
    }

    @Test
    public void Test_EndSession(){
        productData.AddCurrency(400);
        Assert.assertEquals(400, productData.EndSession());

    }
}
