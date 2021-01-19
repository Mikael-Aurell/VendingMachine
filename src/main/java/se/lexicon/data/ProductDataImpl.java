package se.lexicon.data;

import se.lexicon.model.Drink;
import se.lexicon.model.Food;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;

import java.util.Arrays;

import static se.lexicon.model.Protein.CHICKEN;
import static se.lexicon.model.SnackType.BAR;

public class ProductDataImpl implements ProductData {

    private int[] withdraw;
    private Product[] products;
    private int[] denominations; //arrays of valörer
    private String[] getAllProducts;
    private int depositPool;
    private int amount;

    public ProductDataImpl(){
        withdraw = new int[10];
        products = new Product[0];
        denominations = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
        depositPool = 0;
        amount =0;
    }

    @Override //Add to the deposit pool (moneyPool)
    public void AddCurrency(int amount){
        if (amount > 0){
            depositPool = depositPool + amount;
        }
    }

    @Override //Buy Product
    public Product Request(int productNumber){
        int indexOfProduct=0;
        for(int i=0;i<products.length;i++){
            if(products[i].getProductNumber() == productNumber){
                if(depositPool >= products[i].getPrice()){
                    depositPool = depositPool - products[i].getPrice();
                    indexOfProduct = i;
                }
                else {
                    System.out.println("There is not enough money, please add more money");
                }
                break;
            }
        }
        return products[indexOfProduct];
    }


    @Override //Returns change and resets the deposit pool
    public int[] EndSession(){
        withdraw= GenerateWithdraw(depositPool);
        if (depositPool != 0) {
            int returnMoney = depositPool;
            depositPool = 0;
        }
        return withdraw;
    }

    //Generate withdraw array from depositPool
    public int[] GenerateWithdraw(int depositPool){
        if (depositPool != 0){
            int tempPool = depositPool;
            for (int i=9;i>=0;i--){
                if(tempPool >= denominations[i]){
                    withdraw[i]= withdraw[i]+denominations[i];
                    tempPool = tempPool - denominations[i];
                    if(tempPool >= denominations[i]){
                        i++;
                    }
                }
            }
        }
        return withdraw;
    }

    @Override //View a product description
    public String GetDescription (int productNumber){
        int indexOfProduct=0;
        for(int i=0;i<products.length;i++){
            if(products[i].getProductNumber() == productNumber){
                indexOfProduct = i;
                break;
            }
        }
        return products[indexOfProduct].toString();
    }


    @Override //Returns the deposit pool amount
    public int GetBalance(){
    return depositPool;
    }

    @Override //Returns all Products names and product numbers
    public String[] GetProducts() {
        getAllProducts = new String[products.length];
        for(int i=0;i< products.length;i++){
            getAllProducts[i]= (products[i].getProductNumber())+"." + " "
                    + products[i].getName() + " "
                    + products[i].getPrice() +" SEK";
            }
        return getAllProducts;
    }

    @Override
    public Product AddProduct(Product product){
        // checks the input data
        if (product == null) { return null; }
        if(checksForDuplicateId(product)){return null; }

        //Clones the existing product array
        Product[] newProductArray = Arrays.copyOf(products, products.length +1);
        //Add new product
        newProductArray[newProductArray.length-1]=product;
        //Overwrite product array
        products = newProductArray;

        return product;
    }
    //Help method for AddProduct
    private boolean checksForDuplicateId(Product input){
        boolean productExist = false;
        for (Product product: products) {
            if(product.getProductNumber() == input.getProductNumber()){
                productExist = true;
                break;
            }
        }
        return productExist;
    }
}
