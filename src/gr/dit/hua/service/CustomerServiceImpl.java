package gr.dit.hua.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.dit.hua.dao.CustomerDAO;
import gr.dit.hua.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	// inject the CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int ID) {
		return customerDAO.getCustomer(ID);
	}

	@Override
	@Transactional
	public void deleteCustomer(int iD) {
		customerDAO.deleteCustomer(iD);
		
	}
	
	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);	
	}

	@Override
	@Transactional
	public boolean exists(Customer customer) {
		 return customerDAO.exists(customer);
	}
	
}