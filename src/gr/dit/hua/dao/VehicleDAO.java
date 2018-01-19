package gr.dit.hua.dao;

import java.util.List;

import gr.dit.hua.entity.Vehicle;

public interface VehicleDAO {

	public void saveVehicle(Vehicle vehicle);

	public List<Vehicle> getVehicles(int ID);

	public void deleteVehicle(int iD);

	public Vehicle getVehicle(int iD);

	public void updateVehicle(Vehicle vehicle);

	public boolean exists(Vehicle vehicle);

	public void calculateFee(int veh_id, float calculatedFee);
}
