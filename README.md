# Football Player Management ⚽

A football player management desktop application built with Java Swing and MySQL. Code in spanish

## Features

- Register players with their personal data and position
- Record and update player statistics (goals, assists, minutes played, km covered, own goals)
- Search players by last name
- Edit and delete players
- View full player list

## Tech Stack

- Java (Swing GUI)
- MySQL
- JDBC — MySQL Connector/J 9.4.0
- MVC architecture (Model / View / Controller)
- NetBeans IDE

## Project Structure

```
src/
├── Principal/          # App entry point
├── Modelo/
│   ├── Jugador.java
│   ├── Estadistica.java
│   └── DAO/
│       └── JugadorDAO.java
├── Vista/
│   └── VistaJugador.java
└── Controlador/
    └── JugadorController.java
```

## Requirements

- Java JDK 8 or higher
- MySQL 8 or higher
- MySQL Connector/J ([download here](https://dev.mysql.com/downloads/connector/j/))

## Setup

### 1. Import the database

```bash
mysql -u root -p < database.sql
```

Or open it manually in MySQL Workbench and execute it.

### 2. Configure your database credentials

Open `src/Modelo/DAO/JugadorDAO.java` and update:

```java
private static final String URL  = "jdbc:mysql://localhost:3306/sistema_jugadores";
private static final String USER = "your_username";
private static final String PASS = "your_password";
```

### 3. Add the JDBC driver

In NetBeans: right-click the project → Properties → Libraries → Add JAR → select `mysql-connector-j-9.4.0.jar`

### 4. Run

Execute `Principal/Aplicacion.java` as the main class.

## Known Limitations

- Player search is done by last name. If two players share the same last name, only the first result is returned. A future improvement would be to return a list and let the user select from it.
