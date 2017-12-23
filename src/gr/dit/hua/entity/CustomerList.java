package gr.dit.hua.entity;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CustomerList {

	List<Customer> customerList;
	
	public List<Customer> getCustomerList(){
		return customerList; 
	}
	
	public void setCustomerList(List<Customer> customerList) {
		this.customerList=customerList;
	}
	
}
