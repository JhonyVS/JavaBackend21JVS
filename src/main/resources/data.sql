-- Insertar cursos primero
INSERT INTO curso (nombre, siglas, estado) VALUES
('Taller de Programacion', 'TP', TRUE),
('Base de Datos I', 'DB 1', TRUE),
('Programacion I', 'PI', TRUE);

-- Insertar estudiantes
INSERT INTO estudiante (nombres, apellidos, dni, edad) VALUES
('Jhony', 'Veizaga Sanchez', '7999999 cba', 35),
('Carlos', 'Veizaga Sanchez', '79899910 cba', 23),
('Brayan', 'Veizaga Sanchez', '799999510 cba', 21);

-- Insertar matriculas
INSERT INTO matricula (fecha, id_estudiante, estado) VALUES
('2025-02-16 10:00:00', 1, TRUE),
('2025-02-16 10:00:00', 2, TRUE),
('2025-02-16 10:00:00', 3, TRUE);

-- Insertar detalle matricula
INSERT INTO detalle_matricula (id_matricula, id_curso, aula) VALUES
(1, 1, '690-A'), 
(1, 2, '690-A'), 
(2, 2, '624-B'), 
(2, 3, '624-B'), 
(3, 3, '617-C'), 
(3, 1, '617-C');
