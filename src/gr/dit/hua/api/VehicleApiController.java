package gr.dit.hua.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.dit.hua.entity.Vehicle;
import gr.dit.hua.entity.Vehicle.type_of_vehicle;
import gr.dit.hua.entity.VehicleList;
import gr.dit.hua.service.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApiController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleList vehicleList;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Vehicle getVehicle(@PathVariable("id") int id) {

		Vehicle vehicle = vehicleService.getVehicle(id);
		System.out.println("vehicle :" + vehicle);

		return vehicle;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteVehicle(@PathVariable("id") int id) {
		vehicleService.deleteVehicle(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public VehicleList getVehicles(@PathVariable("id") int cust_id) {

		List<Vehicle> vehicles = vehicleService.getVehicles(cust_id);
		System.out.println("vehicles :" + vehicles);
		this.vehicleList.setVehicleList(vehicles);
		return this.vehicleList;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Vehicle createVehicle(@RequestParam("model") String model,@RequestParam("registration_number") String registration_number,@RequestParam("Type") type_of_vehicle Type,@RequestParam("date") String date,@RequestParam("cc") int cc) {
		Vehicle vehicle = new Vehicle(model,registration_number,Type,date,cc);
		vehicle.setStatus("Pending");
		vehicleService.saveVehicle(vehicle);
		return vehicle;
	}
	
	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Vehicle createVehiclefromJson(@RequestBody Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return vehicle;
	}
}