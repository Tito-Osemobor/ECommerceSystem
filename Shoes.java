
public class Shoes extends Product
{
    int size6_Black_Stock;
    int size6_Brown_Stock;
    int size7_Black_Stock;
    int size7_Brown_Stock;
    int size8_Black_Stock;
    int size8_Brown_Stock;
    int size9_Black_Stock;
    int size9_Brown_Stock;
    int size10_Black_Stock;
    int size10_Brown_Stock;

    public Shoes(String name,String id, double price, int size6_Black_Stock, int size6_Brown_Stock, int size7_Black_Stock, int size7_Brown_Stock, int size8_Black_Stock,
                 int size8_Brown_Stock, int size9_Black_Stock, int size9_Brown_Stock, int size10_Black_Stock, int size10_Brown_Stock,int stats)
    {
        super(name, id, price, 100000, Product.Category.CLOTHING,stats);
        this.size6_Black_Stock = size6_Black_Stock;
        this.size6_Brown_Stock = size6_Brown_Stock;
        this.size7_Black_Stock = size7_Black_Stock;
        this.size7_Brown_Stock = size7_Brown_Stock;
        this.size8_Black_Stock = size8_Black_Stock;
        this.size8_Brown_Stock = size8_Brown_Stock;
        this.size9_Black_Stock = size9_Black_Stock;
        this.size9_Brown_Stock = size9_Brown_Stock;
        this.size10_Black_Stock = size10_Black_Stock;
        this.size10_Brown_Stock = size10_Brown_Stock;
    }

    public boolean validOptions(String productOptions)
    {
        switch (productOptions)
        {
            case "6 Black":
            case "8 Black":
            case "10 Black":
            case "8 Brown":
            case "10 Brown":
            case "7 Brown":
            case "7 Black":
            case "9 Black":
            case "6 Brown":
            case "9 Brown":
                return true;
            default: return false;
        }
    }

    @Override
    public int getStockCount(String productOptions)
    {
        switch (productOptions)
        {
            case "6 Black": return size6_Black_Stock;
            case "6 Brown": return size6_Brown_Stock;
            case "7 Black": return size7_Black_Stock;
            case "7 Brown": return size7_Brown_Stock;
            case "8 Black": return size8_Black_Stock;
            case "8 Brown": return size8_Brown_Stock;
            case "9 Black": return size9_Black_Stock;
            case "9 Brown": return size9_Brown_Stock;
            case "10 Black": return size10_Black_Stock;
            case "10 Brown": return size10_Brown_Stock;
            default: return super.getStockCount(productOptions);
        }
    }

    @Override
    public void setStockCount(int stockCount, String productOptions)
    {
        switch (productOptions)
        {
            case "6 Black": this.size6_Black_Stock = stockCount; break;
            case "6 Brown": this.size6_Brown_Stock = stockCount; break;
            case "7 Black": this.size7_Black_Stock = stockCount; break;
            case "7 Brown": this.size7_Brown_Stock = stockCount; break;
            case "8 Black": this.size8_Black_Stock = stockCount; break;
            case "8 Brown": this.size8_Brown_Stock = stockCount; break;
            case "9 Black": this.size9_Black_Stock = stockCount; break;
            case "9 Brown": this.size9_Brown_Stock = stockCount; break;
            case "10 Black": this.size10_Black_Stock = stockCount; break;
            case "10 Brown": this.size10_Brown_Stock = stockCount; break;
        }
    }

    @Override
    public void reduceStockCount(String productOptions)
    {
        switch (productOptions)
        {
            case "6 Black": size6_Black_Stock--; break;
            case "6 Brown": size6_Brown_Stock--; break;
            case "7 Black": size7_Black_Stock--; break;
            case "7 Brown": size7_Brown_Stock--; break;
            case "8 Black": size8_Black_Stock--; break;
            case "8 Brown": size8_Brown_Stock--; break;
            case "9 Black": size9_Brown_Stock--; break;
            case "9 Brown": size9_Black_Stock--; break;
            case "10 Black": size10_Brown_Stock--; break;
            case "10 Brown": size10_Black_Stock--; break;

        }
    }

    @Override
    public void print()
    {
        super.print();
    }

}