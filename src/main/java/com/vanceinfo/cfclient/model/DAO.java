
package com.vanceinfo.cfclient.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Mock persistence.
 */
public class DAO {

    public static Product loadProduct() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return new Product("Wooden wardrobe with glass doors", Integer.valueOf(850), sdf.parse("2012-02-18"));
        } catch (ParseException ex) {
            throw new RuntimeException("Invalid date");
        }
    }
    
    public static List<Product> loadAllProducts() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Product> products = new ArrayList<Product>();
        try {
            products.add(new Product("Chair", Integer.valueOf(25), sdf.parse("2012-02-18")));
            products.add(new Product("Table", Integer.valueOf(150), sdf.parse("2012-02-15")));
            products.add(new Product("Armchair", Integer.valueOf(85), sdf.parse("2012-02-20")));
            products.add(new Product("Wardrobe", Integer.valueOf(450), sdf.parse("2012-02-21")));
            products.add(new Product("Kitchen table", Integer.valueOf(49), sdf.parse("2012-02-15")));
            products.add(new Product("Bookcase", Integer.valueOf(80), sdf.parse("2012-02-17")));
        } catch (ParseException ex) {
            throw new RuntimeException("Invalid date");
        }
        return products;
    }

    public static Customer loadCustomer() {
        Customer customer = new Customer();
        customer.setId(Integer.valueOf(1085));
        customer.setFirstName("Peter");
        customer.setLastName("Jackson");
        customer.setGender(Gender.MALE);
        customer.setPaymentMethod(PaymentMethod.DIRECT_DEBIT);
        customer.setBalance(2500000);
        return customer;
    }
    
    public static List<Customer> loadAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(Integer.valueOf(101), "Cloud", "Foundry", Gender.MALE, PaymentMethod.CREDIT_CARD, 3000));
        customers.add(new Customer(Integer.valueOf(102), "Open", "Shift", Gender.FEMALE, PaymentMethod.BANK_TRANSFER, 12000));
     
       
        return customers;
    }

	public static Transaction loadTransaction(Transaction transaction) {
		if(transaction ==null)
			transaction = new Transaction(0,"BeiJing",100);
		return transaction;
	}
    
}
