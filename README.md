# ticketRESTApp

Refactored the [Ticket Web App](https://github.com/runyud/ticketApp), which was in JSP into a REST app 

REST endpoints

HTTP Method  | Rest End Points | Description 
------------ | -------------   | -------------  
GET | /api/tickets | get the list of all existing tickets
GET | /api/tickets/{ticketId} | Get a particular ticket based on ticketId
POST | /api/tickets | adding a new ticket
PUT  | /api/tickets  | updating an existing ticket
DELETE | /api/tickets/{ticketId} | deleting an existing ticket based on ticketId
GET | /api/events | list all events
GET | /events/{eventId} | get a particular event by eventId
GET | /events/{eventId}/ticket | get the tickets for an event based on event id
GET | /api/tickets/events/{eventName} | Get all tickets that have an event matching eventName

Will throw a ticketNotFoundException if any search query returns no results
