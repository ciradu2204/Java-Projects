/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author mga
 */

public class Customer implements Comparable<Customer>
{
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private CustomerType customerType;
    
    private static int numberOfCustomers=0;


    public Customer()
    {
        this.customerId = ++numberOfCustomers;
        this.customerName = null;
        this.customerAddress = null;
        this.customerEmail = null;
        this.customerType = CustomerType.INTERNAL_ACCOUNT;
    }	
	
    public Customer(String customerName, String customerAddress,
                    String customerEmail, CustomerType customerType)
    {
        this.customerId = ++numberOfCustomers;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerType = customerType;
    }

    public static int getNumberOfCustomers() {
        return numberOfCustomers;
    }
    
    public int getCustomerId()
    {
        return customerId;
    }    
    
    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }      
    
    public String getCustomerName()
    {
        return customerName;
    }     
    
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }     
    
    public String getCustomerAddress()
    {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress)
    {
        this.customerAddress = customerAddress;
    }    
    
    public String getCustomerEmail()
    {
        return customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail)
    {
        this.customerEmail = customerEmail;
    }
    
    public CustomerType getCustomerType()
    {
        return customerType;
    }
    
    public void setCustomerType(CustomerType customerType)
    {
        this.customerType = customerType;
    }    
    
//    @Override
//    public int hashCode() {
//        return getCustomerId() * 31 + getCustomerName().hashCode() * 31 + getCustomerAddress().hashCode() * 31 +  getCustomerEmail().hashCode() * 31;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof Customer) {
//            Customer c = (Customer)o;
//            return  c.getCustomerId() == getCustomerId() &&
//                    c.getCustomerName() == getCustomerName() &&
//                    c.getCustomerAddress().equals(getCustomerAddress()) && 
//                    c.getCustomerEmail().equals(getCustomerEmail());
//        } else {
//            return false;
//        }
//    }
//

    public static  Comparator<Customer> typeComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            String custtype = o1.getCustomerType().toString();
            String custtype2 = o2.getCustomerType().toString();

            //ascending order
           // return custtype.compareTo(custtype2);

            //descending order
            return custtype2.compareTo(custtype);
        }
    };

    public static  Comparator<Customer> CustomerAddressComparator = new Comparator<Customer>() {
    @Override
    public int compare(Customer o1, Customer o2) {
        String custAddress1 = o1.getCustomerAddress();
        String custAddress2 = o2.getCustomerAddress();

        //ascending order
        //return custAddress1.compareTo(custAddress2);

        //descending order
        return custAddress2.compareTo(custAddress1);
    }
};


    public static Comparator<Customer> CustomerNameComparator
                      = new Comparator<Customer>() {

        @Override
        public int compare(Customer cust1, Customer cust2) {

          String custName1 = cust1.getCustomerName();
          String custName2 = cust2.getCustomerName();

          //ascending order
          return custName1.compareTo(custName2);

          //descending order
          //return custName2.compareTo(custName1);
        }

    };

    @Override
    public int compareTo(Customer compareCustomer) {

		int custId = ((Customer) compareCustomer).getCustomerId();

		//ascending order
		return this.customerId - custId;

		//descending order
		//return customerId - this.custId;

    }
    
    @Override
    public String toString() {
        return  "customer id: " + getCustomerId() + ", " +
                "customer name: " + getCustomerName() + ", " +
                "customer address: " + getCustomerAddress() + ", " +	
                "customer email: " + getCustomerEmail() + ", " +
                "customer type: " + getCustomerType();
    }


}

