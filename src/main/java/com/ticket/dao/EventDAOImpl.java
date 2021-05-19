package com.ticket.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticket.entity.Event;
import com.ticket.entity.Ticket;

@Repository
public class EventDAOImpl implements EventDAO {

	// Injecting the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Event> getEvents() {
		Session session = sessionFactory.getCurrentSession();
		// create the query to get the events
		Query<Event> query = session.createQuery("from Event order by id", Event.class);
		List<Event> events = query.getResultList();
		return events;
	}

	@Override
	public List<Ticket> getTickets(int eventId) {
		Session session = sessionFactory.getCurrentSession();
		Event event = session.get(Event.class, eventId);
		return event.getTickets();
	}

	@Override
	public Event getEvent(int eventId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Event.class, eventId);
	}

	@Override
	public void deleteEvent(int eventId) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Ticket> query = session.createQuery("delete from Event where id=:id");
		query.setParameter("id", eventId);
		query.executeUpdate();
	}

	@Override
	public List<Ticket> searchTickets(String searchEvent) {
		Session session = sessionFactory.getCurrentSession();
		Query<Event> query = null;
		if (searchEvent != null && searchEvent.trim().length() > 0) {
			query = session.createQuery("from Event where lower(eventName) like :searchEvent", Event.class);
			query.setParameter("searchEvent", "%" + searchEvent.toLowerCase() + "%");
		} else {
			// search event is empty
			query = session.createQuery("from Event", Event.class);
		}
		Event event = query.getResultList().get(0);
		return event.getTickets();
	}

}
