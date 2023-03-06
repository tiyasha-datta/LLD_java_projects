package parking_lot.service;

import parking_lot.exception.NoParkingSpotAvailableException;
import parking_lot.model.*;
import parking_lot.repository.TicketRepository;
import parking_lot.repository.TicketRepositoryImpl;
import parking_lot.strategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketServiceImpl implements  TicketService{

    private TicketRepository ticketRepository;
    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketServiceImpl(TicketRepository ticketRepository, VehicleService vehicleService, GateService gateService, SpotAssignmentStrategy spotAssignmentStrategy) {
        this.ticketRepository = ticketRepository;
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public TicketServiceImpl() {
        this.ticketRepository = new TicketRepositoryImpl();
    }

    @Override
    public Ticket generateTicket(String vehicleNumber, Long gateId, VehicleType vehicleType) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGate(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        ticket.setGate(gate);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assign(vehicleType, gate);

        if(parkingSpot == null){
            throw new NoParkingSpotAvailableException("Currently no parking spots are available");
        }

        ticket.setParkingSpot(parkingSpot);
        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;
    }
}
