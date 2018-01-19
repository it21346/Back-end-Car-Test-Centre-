package gr.dit.hua.service;

import java.util.List;

import gr.dit.hua.entity.Vehicle;

public interface VehicleService {

	public void saveVehicle(Vehicle vehicle);

	public List<Vehicle> getVehicles(int iD);

	public void deleteVehicle(int iD);

	public Vehicle getVehicle(int iD);

	public void updateVehicle(Vehicle vehicle);

	public boolean exists(Vehicle vehicle);

	public void calculateFee(int veh_id, float calculatedFee);


}
