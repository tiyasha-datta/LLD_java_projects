package parking_lot.repository;

import parking_lot.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepositoryImpl implements TicketRepository{

    private Map<Long, Ticket> tickets;
    private Long idSq;

    public TicketRepositoryImpl() {
        this.tickets = new HashMap<>();
        idSq = 1000L;
    }

    @Override
    public Ticket save(Ticket ticket) {
        tickets.put(idSq++, ticket);
        ticket.setId(idSq);
        return ticket;
    }

    @Override
    public Ticket getTicket(int ticketId) {
        return tickets.get(ticketId);
    }
}
