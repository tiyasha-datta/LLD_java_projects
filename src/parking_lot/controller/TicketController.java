package parking_lot.controller;

import parking_lot.dto.GenerateTicketRequestDTO;
import parking_lot.dto.GenerateTicketResponseDTO;
import parking_lot.model.Gate;
import parking_lot.model.Ticket;
import parking_lot.model.Vehicle;
import parking_lot.service.TicketService;

import java.util.Date;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO){
        return null;
    }
}
