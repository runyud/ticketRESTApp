package com.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.dao.EventDAO;
import com.ticket.dao.TicketDAO;
import com.ticket.entity.Event;
import com.ticket.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	// Inject DAO
	@Autowired
	private TicketDAO ticketDAO;
	
	@Autowired
	private EventDAO eventDAO;

	@Override
	@Transactional
	public List<Ticket> getTickets() {
		return ticketDAO.getTickets();
	}

	@Override
	@Transactional
	public void saveTicket(Ticket ticket) {
		ticketDAO.saveTicket(ticket);
	}

	@Override
	@Transactional
	public Ticket getTicket(int id) {
		return ticketDAO.getTicket(id);
	}

	@Override
	@Transactional
	public void deleteTicket(int id) {
		ticketDAO.deleteTicket(id);
	}
	
	@Override
	@Transactional
	public List<Event> getEvents() {
		return eventDAO.getEvents();
	}

	@Override
	@Transactional
	public List<Ticket> getTickets(int eventId) {
		return eventDAO.getTickets(eventId);
	}

	@Override
	@Transactional
	public Event getEvent(int eventId) {
		return eventDAO.getEvent(eventId);
	}

	@Override
	@Transactional
	public void deleteEvent(int eventId) {
		eventDAO.deleteEvent(eventId);
	}
	
	@Override
	@Transactional
	public List<Ticket> searchTickets(String searchEvent) {
		return eventDAO.searchTickets(searchEvent);
	}

	

}
