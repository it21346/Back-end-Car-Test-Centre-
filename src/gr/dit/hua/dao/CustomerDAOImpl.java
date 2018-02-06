package gr.dit.hua.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.dit.hua.dao.CustomerDAO;
import gr.dit.hua.entity.Appointment;
import gr.dit.hua.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer order by surname", Customer.class);

		// execute the query and get the results list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer
		currentSession.save(customer);

	}

	@Override
	public void updateCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// update the customer
		currentSession.update(customer);
	}

	@Override
	public Customer getCustomer(int ID) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Customer customer = currentSession.get(Customer.class, ID);
		return customer;
	}

	@Override
	public void deleteCustomer(int iD) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer with the given id
		Customer customer = currentSession.get(Customer.class, iD);

		// delete the customer based on his id
		currentSession.delete(customer);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean exists(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> query = currentSession
				.createQuery("select 1 from Customer c where  c.name= :key and c.surname= :key2 and c.email= :key3");
		query.setString("key", customer.getName());
		query.setString("key2", customer.getSurname());
		query.setString("key3", customer.getEmail());
		return (query.uniqueResult() != null);
	}

	@Override
	public List<Appointment> getAppointments() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Appointment> query = currentSession.createQuery("from Appointment order by date", Appointment.class);
		// execute the query and get the results list
		List<Appointment> appointments = query.getResultList();

		// return the results
		return appointments;
	}

	@Override
	public void saveAppointment(Appointment appointment) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the appointment
		currentSession.save(appointment);
	}

	@Override
	public Appointment getAppointment(int ID) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return appointment
		Appointment appointment = currentSession.get(Appointment.class, ID);

		return appointment;
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("----->"+appointment.getStatus());
		currentSession.update(appointment);
	}
}
