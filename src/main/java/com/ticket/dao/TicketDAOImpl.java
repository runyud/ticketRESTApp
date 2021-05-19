package com.ticket.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticket.entity.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO {

	// Injecting the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Ticket> getTickets() {
		Session session = sessionFactory.getCurrentSession();
		// create the query to get the tickets
		Query<Ticket> query = session.createQuery("from Ticket order by ticketId", Ticket.class);
		List<Ticket> tickets = query.getResultList();
		return tickets;
	}

	@Override
	public void saveTicket(Ticket ticket) {
		Session session = sessionFactory.getCurrentSession();
		// save or update the ticket
		session.saveOrUpdate(ticket);
	}

	@Override
	public Ticket getTicket(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Ticket.class, id);
	}

	@Override
	public void deleteTicket(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Ticket> query = session.createQuery("delete from Ticket where ticketId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
