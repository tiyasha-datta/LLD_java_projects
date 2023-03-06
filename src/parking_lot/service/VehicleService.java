package parking_lot.service;

import parking_lot.model.Vehicle;
import parking_lot.model.VehicleType;

public interface VehicleService {
    Vehicle getVehicle(String vehicleNumber);

    Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType);
}
