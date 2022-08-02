
import java.util.ArrayList;
import java.util.HashMap;

public class Cart
{
    private ArrayList <CartItem> cart;
    private HashMap <String, Integer> cartItem;

    Cart ()
    {
        this.cart = new ArrayList<CartItem>();
        this.cartItem = new HashMap<>();
    }
    public Cart(ArrayList <CartItem> item){
        this.cart = item;
    }
    public ArrayList<CartItem> getCart()
    {
        return cart;
    }

    public HashMap <String, Integer> getCartItem()
    {
        return cartItem;
    }

    private boolean cartItemCurrent (CartItem item)
    {
        boolean cartItemCurrent = false;
        for (CartItem itemNext: cart)
        {
            if (item.equals(itemNext))
            {
                cartItemCurrent = true;
            }
        }
        return cartItemCurrent;
    }

    public void cartItemAdd (CartItem item)
    {
        String ID = item.getProduct().getId();
        if (cartItemCurrent(item))
        {
            cartItem.put(ID, cartItem.get(ID) + 1);
        }
        else
        {
            cart.add(item);
            cartItem.put(ID, 1);
        }
    }

    public void cartItemRemove (int cartItem)
    {
        cart.remove(cartItem);
    }

    public void cartPrint()
    {
        if (cart.isEmpty())
        {
            System.out.println("The cart is empty!");
        }
        else
        {
            for (CartItem item : cart)
            {
                int quantity = cartItem.get(item.getProduct().getId());
                System.out.print("Cart has " + quantity + " items");
                item.print();
                System.out.println();
            }
        }
    }

    public int findItem(String productId) {
        for(int i=0;i < cart.size();i++)
        {
            if(cart.get(i).getItem().getId().equals(productId))
            {
                return i;
            }
        }
        return -1;
    }
}