package com.ticket.dao;

import java.util.List;

import com.ticket.entity.Event;
import com.ticket.entity.Ticket;

public interface EventDAO {
	
	public List<Event> getEvents();
	
	public List<Ticket> getTickets(int eventId);
	
	public List<Ticket> searchTickets(String searchEvent);
	
	public Event getEvent(int eventId);
	
	public void deleteEvent(int eventId);
	
}
