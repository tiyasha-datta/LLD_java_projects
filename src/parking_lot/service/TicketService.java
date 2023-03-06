package parking_lot.service;

import parking_lot.model.Ticket;
import parking_lot.model.VehicleType;

public interface TicketService {

    Ticket generateTicket(String vehicleNumber, Long gateId, VehicleType vehicleType);
}
