package gr.dit.hua.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CustomerList")
@Component
public class VehicleList {

	List<Vehicle> vehicleList;

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
