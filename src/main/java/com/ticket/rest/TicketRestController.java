package com.ticket.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.Event;
import com.ticket.entity.Ticket;
import com.ticket.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketRestController {

	@Autowired
	private TicketService ticketService;

	// list all tickets
	@GetMapping("/tickets")
	public List<Ticket> getTickets() {
		return ticketService.getTickets();
	}

	// GET /tickets/{ticketId}
	@GetMapping("/tickets/{ticketId}")
	public Ticket getTicket(@PathVariable int ticketId) {
		Ticket ticket = ticketService.getTicket(ticketId);
		if (ticket == null) {
			throw new TicketNotFoundException("Ticket not found - " + ticketId);
		}
		return ticket;
	}

	// POST /tickets add a new ticket
	@PostMapping("/tickets")
	public Ticket addTickets(@RequestBody Ticket ticket) {
		ticket.setTicketId(0);
		ticketService.saveTicket(ticket);
		return ticket;
	}

	// PUT /tickets update existing ticket
	@PutMapping("/tickets")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		ticketService.saveTicket(ticket);
		return ticket;
	}

	// DELETE /tickets/{ticketId} delete existing ticket
	@DeleteMapping("/tickets/{ticketId}")
	public String deleteTicket(@PathVariable int ticketId) {
		Ticket ticket = ticketService.getTicket(ticketId);
		if (ticket == null) {
			throw new TicketNotFoundException("Ticket not found - " + ticketId);
		}
		ticketService.deleteTicket(ticketId);
		return "Deleted ticket id - " + ticketId;
	}

	// GET /events list all events
	@GetMapping("/events")
	public List<Event> getEvents() {
		return ticketService.getEvents();
	}

	// GET /events/{eventId} get a particular event by eventId
	@GetMapping("/events/{eventId}")
	public Event getEvent(@PathVariable int eventId) {
		Event event = ticketService.getEvent(eventId);
		if (event == null) {
			throw new TicketNotFoundException("Event not found - " + eventId);
		}
		return event;
	}
	
	// GET /events/{eventId}/tickets get the tickets for an event based on event id
	@GetMapping("/events/{eventId}/tickets")
	public List<Ticket> getTicketsByEventId(@PathVariable int eventId) {
		List<Ticket> tickets = ticketService.getTickets(eventId);
		if (tickets == null) {
			throw new TicketNotFoundException("Tickets not found for this eventId - " + eventId);
		}
		return tickets;
	}
	
	// DELETE delete an event 
	@DeleteMapping("/events/{eventId}")
	public String deleteEvent(@PathVariable int eventId) {
		Event event = ticketService.getEvent(eventId);
		if (event == null) {
			throw new TicketNotFoundException("Event not found - " + eventId);
		}
		ticketService.deleteEvent(eventId);
		return "Deleted event id - " + eventId;
	}

	// GET /tickets/events/{eventName} get the tickets for a particular event
	@GetMapping("/tickets/events/{eventName}")
	public List<Ticket> searchTicket(@PathVariable String eventName) {
		List<Ticket> tickets = ticketService.searchTickets(eventName);
		if (tickets == null || tickets.size() == 0) {
			throw new TicketNotFoundException("Tickets not found for this event " + eventName);
		}
		return tickets;
	}
}
