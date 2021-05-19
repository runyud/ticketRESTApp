# ticketRESTApp

Refactored the [Ticket Web App](https://github.com/runyud/ticketApp), which was in JSP into a REST app 

REST endpoints

HTTP Method  | Rest End Points | Description 
------------ | -------------   | -------------  
GET | /api/tickets | get the list of all existing tickets
GET | /api/tickets/{ticketId} | Get a particular ticket based on ticketId
GET | /api/tickets/{eventName} | Get all tickets that have an event matching eventName
POST | /api/tickets | adding a new ticket
PUT  | /api/tickets  | updating an existing ticket
DELETE | /api/tickets/{ticketId} | deleting an existing ticket based on ticketId

Will throw a ticketNotFoundException if any search query returns no results
