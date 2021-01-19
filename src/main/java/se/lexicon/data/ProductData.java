package se.lexicon.data;

import se.lexicon.model.Product;

public interface ProductData {

    void AddCurrency(int amount); //Add to the deposit pool (moneyPool)
    Product Request(int productNumber); //Buy a Product
    int EndSession(); //Returns change and resets the deposit pool.
    String GetDescription (int productNumber); //View a product description
    int GetBalance(); //Returns the deposit pool amount.
    String[] GetProducts(); //Returns all Products' names and product numbers
    Product AddProduct(Product product);

}
