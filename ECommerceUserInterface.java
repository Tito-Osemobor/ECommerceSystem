
// import java.util.ArrayList;
import java.util.Scanner;
// import java.util.StringTokenizer;

// Simulation of a Simple E-Commerce System (like Amazon)

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// Simulation of a Simple E-Commerce System (like Amazon)

public class ECommerceUserInterface
{
	public static void main(String[] args)
	{
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			try {
				String action = scanner.nextLine();

				if (action == null || action.equals("")) {
					System.out.print("\n>");
					continue;
				}

				else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
					return;

				else if (action.equalsIgnoreCase("PRODS"))    // List all products for sale
				{
					amazon.printAllProducts();
				}

				else if (action.equalsIgnoreCase("BOOKS"))    // List all books for sale
				{
					amazon.printAllBooks();
				}

				else if (action.equalsIgnoreCase("CUSTS"))    // List all registered customers
				{
					amazon.printCustomers();
				}

				else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
				{
					amazon.printAllOrders();
				}

				else if (action.equalsIgnoreCase("SHIPPED"))    // List all orders that have been shipped
				{
					amazon.printAllShippedOrders();
				}

				else if (action.equalsIgnoreCase("NEWCUST"))    // Create a new registered customer
				{
					String name = "";
					String address = "";

					System.out.print("Name: ");
					if (scanner.hasNextLine())
						name = scanner.nextLine();

					System.out.print("\nAddress: ");
					if (scanner.hasNextLine())
						address = scanner.nextLine();
					boolean success = amazon.createCustomer(name, address);
					if (!success)
						System.out.println(amazon.getErrorMessage());

				}

				else if (action.equalsIgnoreCase("SHIP"))    // ship an order to a customer
				{
					String orderNumber = "";
					System.out.print("Order Number: ");
					// Get order number from scanner
					if (scanner.hasNextLine())
						orderNumber = scanner.nextLine();
					// Ship order to customer (see ECommerceSystem for the correct method to use
					boolean success = amazon.shipOrder(orderNumber);
					if (!success)
						System.out.println(amazon.getErrorMessage());
				}

				else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this customer id
				{
					String customerId = "";

					System.out.print("Customer Id: ");
					// Get customer Id from scanner
					if (scanner.hasNextLine())
						customerId = scanner.nextLine();
					// Print all current orders and all shipped orders for this customer

					boolean success = amazon.printOrderHistory(customerId);
					System.out.println(amazon.getErrorMessage());

				}
				else if (action.equalsIgnoreCase("ORDER")) // order a product for a certain customer
				{
					String productId = "";
					String customerId = "";
					System.out.print("Product Id: ");
					// Get product Id from scanner
					if (scanner.hasNextLine())
						productId = scanner.nextLine();
					System.out.print("\nCustomer Id: ");
					// Get customer Id from scanner
					if (scanner.hasNextLine())
						customerId = scanner.nextLine();
					// Order the product. Check for valid orderNumber string return and for error message set in ECommerceSystem
					String OrdNum = amazon.orderProduct(productId, customerId, "");
					if (OrdNum == null) {
						System.out.println(amazon.getErrorMessage());
					}
					// Print Order Number string returned from method in ECommerceSystem
					else
						System.out.println(OrdNum);
				}


				else if (action.equalsIgnoreCase("ORDERBOOK")) // order a book for a customer, provide a format (Paperback, Hardcover or EBook)
				{
					String productId = "";
					String customerId = "";
					String options = "";

					System.out.print("Product Id: ");
					// get product id
					if (scanner.hasNextLine())
						productId = scanner.nextLine();
					System.out.print("\nCustomer Id: ");
					// get customer id
					if (scanner.hasNextLine())
						customerId = scanner.nextLine();
					System.out.print("\nFormat [Paperback Hardcover EBook]: ");
					// get book format and store in options string
					if (scanner.hasNextLine())
						options = scanner.nextLine();
					// Order product. Check for error message set in ECommerceSystem
					// Print order number string if order number is not null
					String bookOrder = amazon.orderProduct(productId, customerId, options);
					if (bookOrder == null) {
						System.out.println(amazon.getErrorMessage());
					} else {
						System.out.println(bookOrder);
					}
				}

				else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color
				{
					String productId = "";
					String customerId = "";
					String options = "";

					System.out.print("Product Id: ");
					// get product id
					if (scanner.hasNextLine())
						productId = scanner.nextLine();
					System.out.print("\nCustomer Id: ");
					// get customer id
					if (scanner.hasNextLine())
						customerId = scanner.nextLine();
					System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
					// get shoe size and store in options
					if (scanner.hasNextLine())
						options = scanner.nextLine();
					System.out.print("\nColor: \"Black\" \"Brown\": ");
					// get shoe color and append to options
					if (scanner.hasNextLine())
						options = options + " " + scanner.nextLine();
					//order shoes
					String shoeOrder = amazon.orderProduct(productId, customerId, options);
					if (shoeOrder == null) {
						System.out.println(amazon.getErrorMessage());
					} else {
						System.out.println(shoeOrder);
					}
				}

				else if (action.equalsIgnoreCase("BooksByAuthor")) {
					String authorName = "";
					System.out.print("Author's Name: ");
					if (scanner.hasNext()) // gets the author name from the user
						authorName = scanner.next();
					amazon.printAuthorBooks(authorName); // calls the method in ECommerceSystem.java
				}

				else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
				{
					String orderNumber = "";
					System.out.print("Order Number: ");
					// get order number from scanner
					if (scanner.hasNext())
						orderNumber = scanner.next();
					// cancel order. Check for error
					boolean success = amazon.cancelOrder(orderNumber);
					if (!success) {
						System.out.println(amazon.getErrorMessage());
					}
				}

				else if (action.equalsIgnoreCase("ADDTOCART")) //adds product to cart
				{
					String productId = "";
					String customerId = "";
					String productOptions = "";

					System.out.print("Product Id: ");
					if (scanner.hasNext())
						productId = scanner.next();
					System.out.print("\nCustomer Id: ");
					if (scanner.hasNext())
						customerId = scanner.next();
					amazon.AddtoCart(productId, customerId, productOptions);
				}

				else if (action.equalsIgnoreCase("REMCARTITEM")) // removes product from cart
				{
					String productId = "";
					String customerId = "";
					System.out.print("Product Id: ");
					// get product id
					if (scanner.hasNext())
						productId = scanner.next();

					System.out.print("\nCustomer Id: ");
					// get customer id
					if (scanner.hasNext())
						customerId = scanner.next();
					try {
						amazon.RemCartItem(productId, customerId);
					} finally {
						System.out.print("Product removed from cart");
					}
				}

				else if (action.equalsIgnoreCase("PRINTCART")) {
					String customerId = "";
					System.out.print("Customer Id: ");
					if (scanner.hasNext()) {
						customerId = scanner.next();
					}
					amazon.printCart(customerId);
				}

				else if (action.equalsIgnoreCase("ORDERITEMS")) {
					String customerId = "";
					System.out.print("Customer Id: ");
					if (scanner.hasNext()) {
						customerId = scanner.next();
						amazon.orderItems(customerId);
					}
				}

				else if (action.equalsIgnoreCase("STATS"))        // prints number of times a product is ordered
				{
					amazon.printStats();
				}

				else if (action.equalsIgnoreCase("PRINTBYPRICE")) // sort products by price
				{
					amazon.printByPrice();
				}

				else if (action.equalsIgnoreCase("PRINTBYNAME")) // sort products by name (alphabetic)
				{
					amazon.printByName();
				}

				else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
				{
					amazon.sortCustomersByName();
				}

				else if (action.equalsIgnoreCase("ADDTOCART")) {
					String productId = "";
					String customerId = "";
					String productOptions = "";

					System.out.println("Product ID: ");
					if (scanner.hasNext()) {
						productId = scanner.next();
						if (productId.equals("711") || productId.equals("712") || productId.equals("713") || productId.equals("714") || productId.equals("715")) {
							System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
							if (scanner.hasNext())
								productOptions = scanner.next();
							if (productOptions.equals("6") || productOptions.equals("7") || productOptions.equals("8") || productOptions.equals("9") || productOptions.equals("10"))
								System.out.print("\nColor: \"Black\" \"Brown\": ");
							if (scanner.hasNext()) {
								productOptions = productOptions + " " + scanner.next();
							}
						} else {
							System.out.println();
						}
					}

					System.out.println("\nCustomer ID: ");
					if (scanner.hasNext()) {
						customerId = scanner.next();
					}

					try {
						amazon.AddtoCart(productId, customerId, productOptions);
					} finally {
						System.out.print("Product added to cart");
					}
				}

				else if (action.equalsIgnoreCase("REMCARTITEM")) {
					String productId = "";
					String customerId = "";

					System.out.print("Product Id: ");
					if (scanner.hasNextLine())
						productId = scanner.nextLine();

					System.out.print("\nCustomer Id: ");
					if (scanner.hasNextLine())
						customerId = scanner.nextLine();
					String cart = amazon.RemCartItem(productId, customerId);
					System.out.println(cart);
				}

				else if (action.equalsIgnoreCase("PRINTCART")) {
					String customerId = "";
					System.out.println("Customer Id: ");
					if (scanner.hasNext()) {
						customerId = scanner.next();
					}
					amazon.printCart(customerId);
					System.out.println();
				}

				else if (action.equalsIgnoreCase("ORDERITEMS")) {
					String customerId = "";
					System.out.println("Customer Id: ");
					if (scanner.hasNext()) {
						customerId = scanner.next();
					}
					try {
						amazon.orderItems(customerId);
					} finally {
						System.out.println("The items in the cart have been ordered!");
					}
				}
			} // try brace ending
			catch (RuntimeException e) {
				System.out.println(e.getMessage());
				}
			}
		System.out.print("\n>");
		}

	}