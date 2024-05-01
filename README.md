# Beauty Center Management System

This project aims to provide a management system for a beauty center, allowing the administration of employees, clients, services, and appointments through a REST API implemented with Spring Boot and Spring Data JPA.

## System Requirements

### 1. Entity and Relationship Modeling

- Implementation of entities for Employee, Client, Service, and Appointment using Spring Data JPA.
- Use of appropriate annotations to map each entity to its respective table in the database according to the provided SQL script.
- Definition of relationships between entities:
  - A client can have multiple appointments.
  - An employee can be assigned multiple appointments.
  - A service can be associated with multiple appointments.
- Inclusion of all necessary annotations for primary keys, foreign keys, and other fields according to the database structure.

### 2. REST API Development

- Implementation of a set of REST controllers (`@RestController`) to handle HTTP requests for each type of entity.
- Definition of the following endpoints for each entity:
  - `GET` to retrieve all records and a specific record by ID.
  - `POST` to create new records.
  - `PUT` to update existing records.
  - `DELETE` to delete records by ID.
- Use of DTOs (Data Transfer Objects) to transfer data between the API and the client, ensuring that sensitive data is not unnecessarily exposed.
- Implementation of appropriate exception handling to manage situations such as not found records or errors in data input.

## Execution Instructions

To run this project locally, follow these steps:

1. Clone this repository to your local machine.
2. Ensure you have a compatible database set up and update the connection settings in the `application.properties` file.
3. Run the application using your favorite IDE or via the command line with Maven: `mvn spring-boot:run`.

