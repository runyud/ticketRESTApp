package com.ticket.service;

import java.util.List;

import com.ticket.entity.Ticket;

public interface TicketService {
	
	public List<Ticket> getTickets();

	public void saveTicket(Ticket ticket);

	public Ticket getTicket(int id);

	public void deleteTicket(int id);

	public List<Ticket> searchTickets(String searchEvent);
}
