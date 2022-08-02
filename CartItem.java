
public class CartItem extends Product
{
    private Product product;
    private String productOptions;

    CartItem (Product product, String productOptions)
    {
        this.product = product;
        this.productOptions = productOptions;
    }

    public Product getProduct()
    {
        return product;
    }

    public String getProductOptions()
    {
        return productOptions;
    }

    public void print()
    {
        System.out.printf("\nId: %-5s Category: %-9s Name: %-20s Price: %7.1f", product.getId(), product.getCategory(), product.getName(), product.getPrice());
    }

    public boolean equals (CartItem other)
    {
        return this.product.getId().equals(other.getProduct().getId()) && this.productOptions.equals(other.getProductOptions());
    }

    public Product getItem() {
        return product;
    }
}
