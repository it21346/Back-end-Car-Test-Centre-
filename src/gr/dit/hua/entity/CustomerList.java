package gr.dit.hua.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CustomerList")
@Component
public class CustomerList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Customer> customerList;

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
}
