package fact.it.exerciseproduct.model;

import java.util.ArrayList;

public class Webshop {
    private String url;
    private ArrayList<Product> productList = new ArrayList<>();

    public Webshop(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void addProduct(Product product){
        this.productList.add(product);
    }

    public int getNumberOfProducts(){
        return this.productList.size();
    }

    public String showProductFromProductList(int i){
        String message;
        if (productList.size() -1 < i){
            message = "no product with this index in the list";
        }
        else {
            message = "The product " + productList.get(i).getName() + " (" + productList.get(i).getAmount() + " pieces in stock) costs €" + productList.get(i).getPrice();
        }
        return message;
    }
}
