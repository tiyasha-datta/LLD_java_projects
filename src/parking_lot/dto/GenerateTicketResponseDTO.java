package parking_lot.dto;

import parking_lot.model.ResponseStatus;
import parking_lot.model.Ticket;
import sun.security.provider.certpath.OCSPResponse;

public class GenerateTicketResponseDTO {

    private ResponseStatus responseStatus;
    private Ticket ticket;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
