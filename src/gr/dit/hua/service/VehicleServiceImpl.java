package gr.dit.hua.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.dit.hua.dao.VehicleDAO;
import gr.dit.hua.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	// inject the CustomerDAO
	@Autowired
	private VehicleDAO vehicleDAO;

	@Override
	@Transactional
	public void saveVehicle(Vehicle vehicle) {
		vehicleDAO.saveVehicle(vehicle);
	}

	@Override
	@Transactional
	public List<Vehicle> getVehicles(int id) {
		return vehicleDAO.getVehicles(id);
	}

	@Override
	@Transactional
	public void deleteVehicle(int iD) {

		vehicleDAO.deleteVehicle(iD);

	}

	@Override
	@Transactional
	public Vehicle getVehicle(int iD) {
		return vehicleDAO.getVehicle(iD);
	}

	@Override
	@Transactional
	public void updateVehicle(Vehicle vehicle) {
		vehicleDAO.updateVehicle(vehicle);
	}

	@Override
	@Transactional
	public boolean exists(Vehicle vehicle) {
		return vehicleDAO.exists(vehicle);
	}

	@Override
	@Transactional
	public void calculateFee(int veh_id,float calculatedFee) {
		vehicleDAO.calculateFee(veh_id,calculatedFee);
	}

}
