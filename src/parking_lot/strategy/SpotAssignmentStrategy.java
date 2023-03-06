package parking_lot.strategy;

import parking_lot.model.Gate;
import parking_lot.model.ParkingSpot;
import parking_lot.model.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot assign(VehicleType vehicleType, Gate gate);
}
