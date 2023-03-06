package parking_lot.repository;

import parking_lot.model.Ticket;

public interface TicketRepository {

    Ticket save(Ticket ticket);
    Ticket getTicket(int ticketId);

}
