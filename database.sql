CREATE DATABASE IF NOT EXISTS sistema_jugadores;
USE sistema_jugadores;

CREATE TABLE IF NOT EXISTS jugadores (
    apellido VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    categoria INT NOT NULL,
    dorsal INT NOT NULL,
    posicion VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    goles INT DEFAULT 0,
    asistencias INT DEFAULT 0,
    tiempojugado DECIMAL(6, 2) DEFAULT 0.0,
    kmrecorridos DECIMAL(6, 2) DEFAULT 0.0,
    golespp INT DEFAULT 0
);

-- Sample data
INSERT INTO jugadores (apellido, nombre, categoria, dorsal, posicion, edad, goles, asistencias, tiempojugado, kmrecorridos, golespp)
VALUES
('Garcia',    'Lionel',   2003, 10, 'Delantero',     21, 15, 8,  1200.5, 95.3, 2),
('Lopez',     'Marcos',   2003, 5,  'Mediocampista', 20, 4,  10, 1100.0, 88.7, 0),
('Martinez',  'Santiago', 2004, 1,  'Arquero',       19, 0,  1,  980.0,  60.2, 0),
('Rodriguez', 'Facundo',  2004, 4,  'Defensor',      19, 2,  3,  1050.5, 82.1, 1),
('Fernandez', 'Agustin',  2003, 9,  'Delantero',     21, 10, 5,  1150.0, 91.4, 1);
