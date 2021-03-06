package gr.dit.hua.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.dit.hua.entity.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	public List<Vehicle> getVehicles(int ID) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Vehicle> query = currentSession.createQuery("from Vehicle where customer_id = :key order by ID ",
				Vehicle.class);
		query.setParameter("key", ID);
		// execute the query and get the results list
		List<Vehicle> vehicles = query.getResultList();
		// return the results
		return vehicles;
	}
    @Override
	public void saveVehicle(Vehicle vehicle) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the vehicle
		currentSession.save(vehicle);
	}

	@Override
	public void deleteVehicle(int iD) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// find the vehicle with the given id
		Vehicle vehicle = currentSession.get(Vehicle.class, iD);

		// delete the customer based on his id
		currentSession.delete(vehicle);
	}

	@Override
	public Vehicle getVehicle(int iD) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Vehicle
		Vehicle vehicle = currentSession.get(Vehicle.class, iD);
		return vehicle;

	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// update the vehicle
		currentSession.update(vehicle);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean exists(Vehicle vehicle) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> query = currentSession.createQuery(
				"select 1 from Vehicle v where  v.registration_number= :key and v.model = :key1 and v.Type= :key2 and v.date = :key3 and v.status = :key4 and v.cc = :key5");
		query.setString("key", vehicle.getRegistration_number());
		query.setString("key1", vehicle.getModel());
		query.setString("key2", vehicle.getType().name());
		query.setString("key3", vehicle.getDate());
		query.setString("key4", vehicle.getStatus());
		query.setLong("key5", vehicle.getCc());
		return (query.uniqueResult() != null);

	}

	@Override
	public void calculateFee(int veh_id,float calculatedFee) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// get Vehicle
		Vehicle vehicle = currentSession.get(Vehicle.class, veh_id);
		
		vehicle.setFee(calculatedFee);
	}
}
