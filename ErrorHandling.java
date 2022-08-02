
public class ErrorHandling
{
    class CustomerNOTFOUNDException extends RuntimeException
    {
        public CustomerNOTFOUNDException()
        {
            super("Customer was not found!");
        }
        public CustomerNOTFOUNDException(String error)
        {
        super(error);
        }
    }
    class CustomerNameNOTFOUNDException extends RuntimeException
    {
        public CustomerNameNOTFOUNDException()
        {
            super ("Customer name was not found!");
        }
    }
    class CustomerAddressNOTFOUNDException extends RuntimeException
    {
        public CustomerAddressNOTFOUNDException()
        {
            super ("Customer address was not found!");
        }
    }
    class ProductNOTFOUNDException extends RuntimeException
    {
        public ProductNOTFOUNDException()
        {
            super("Product was not found!");
        }
        public ProductNOTFOUNDException(String error)
        {
        super(error);
        }
    }
    class ProductOptionsNOTFOUNDException extends RuntimeException
    {
        public ProductOptionsNOTFOUNDException()
        {
            super("Invalid product options entered!");
        }
        public ProductOptionsNOTFOUNDException(String error)
        {
        super(error);
        }
    }
    class ProductOutOfStockException extends RuntimeException
    {
        public ProductOutOfStockException()
        {
            super ("Product is currently out of stock!");
        }
    }
    class OrderNFException extends RuntimeException
    {
        public OrderNFException ()
        {
            super ("Order number was not found!");
        }
    }
    class cartItemNOTFOUNDMessage extends RuntimeException
    {
        public cartItemNOTFOUNDMessage()
        {
            super ("Cart Item Not Found!");
        }
    }}