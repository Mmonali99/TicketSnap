

# TicketSnap


**TicketSnap** is a full-stack ticketing system for real-time movie seat booking and instant confirmation. It allows users to search for movies, select seats, book tickets, and manage their profiles, while admins can manage movies and shows. The backend is built with Spring Boot, Spring Security (JWT), and MySQL, and the frontend uses React with React Router.

## Features
- **User Features**:
  - Register and login with JWT authentication.
  - Search and filter movies.
  - View movie details and showtimes.
  - Select seats interactively and book tickets.
  - View booking history.
- **Admin Features**:
  - Add new movies via an admin dashboard.
- **Real-time**:
  - Instant seat availability updates.
  - Payment simulation (extendable to real gateways).
- **Notifications**:
  - Simulated email/SMS notifications for bookings.

## Tech Stack
- **Backend**:
  - Spring Boot 3.2.3
  - Spring Security (JWT)
  - Spring Data JPA
  - MySQL 8.0+
  - Maven
- **Frontend**:
  - React 18
  - React Router DOM
  - Axios
  - CSS (custom styles)
- **Database**: MySQL
- **Runtime**: Java 17, Node.js 18+

## Project Structure
```
ticket-snap/
├── ticket-snap-backend/      # Spring Boot backend
│   ├── ticket-snap/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/ticketsnap/
│   │   │   │   │   ├── config/       # Security and JWT config
│   │   │   │   │   ├── controllers/  # REST controllers
│   │   │   │   │   ├── exceptions/   # Custom exceptions
│   │   │   │   │   ├── models/      # JPA entities
│   │   │   │   │   ├── repository/  # JPA repositories
│   │   │   │   │   └── service/     # Business logic
│   │   │   │   └── resources/
│   │   │   │       └── application.properties  # Config
│   │   └── pom.xml                  # Maven dependencies
│   └── README.md                    # Backend-specific README
├── ticket-snap-frontend/            # React frontend
│   ├── src/
│   │   ├── components/              # Reusable components
│   │   ├── pages/                   # Page components
│   │   ├── services/                # API and auth helpers
│   │   ├── styles/                  # CSS styles
│   │   ├── App.js                   # Main app with routing
│   │   └── index.js                 # Entry point
│   ├── public/                      # Static assets
│   └── package.json                 # NPM dependencies
└── README.md                        # This file
```

## Prerequisites
- **Java 17**: Install from [AdoptOpenJDK](https://adoptopenjdk.net/) or equivalent.
- **Maven**: Install from [Maven](https://maven.apache.org/).
- **Node.js 18+**: Install from [Node.js](https://nodejs.org/).
- **MySQL 8.0+**: Install from [MySQL](https://dev.mysql.com/downloads/).
- **MySQL Workbench** (optional): For database management.
- **Git**: For cloning the repository.


