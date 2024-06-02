package Model;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private int productQty;
    private String productCategory;
    
    public Product(int productId, String productName, double productPrice, int productQty, String productCategory){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.productCategory = productCategory;
    }
    public int getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public void setProductQty(int qty){
        this.productQty = qty;
    }
    public int getProductQty(){
        return productQty;
    }
    public String getProductCategory(){
        return productCategory;
    }
}
