-- Wstaw adres
INSERT INTO address (id, address_line_1, address_line_2, city, postal_code)
VALUES (1, 'Budowlana', '16', 'Wroclaw', '62-030');

INSERT INTO address (id, address_line_1, address_line_2, city, postal_code)
VALUES (2, 'Grunwaldzka', '22', 'Gdańsk', '80-001');

INSERT INTO address (id, address_line_1, address_line_2, city, postal_code)
VALUES (3, 'Piotrkowska', '10', 'Łódź', '90-001');

INSERT INTO address (id, address_line_1, address_line_2, city, postal_code)
VALUES (4, 'Kościuszki', '5', 'Warszawa', '00-001');

INSERT INTO address (id, address_line_1, address_line_2, city, postal_code)
VALUES (5, 'Wyspiańskiego', '7', 'Kraków', '30-001');

-- Lekarze
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, specialization)
VALUES (1, 'Marek', 'Konrad', '+48 992 112 221', 'marekkonrad@o2.pl', 'kardiolog');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, specialization)
VALUES (2, 'Anna', 'Nowak', '+48 555 123 456', 'anna.nowak@example.com', 'pediatra');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, specialization)
VALUES (3, 'Piotr', 'Kowalski', '+48 111 222 333', 'piotr.kowalski@example.com', 'chirurg');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, specialization)
VALUES (4, 'Ewa', 'Wiśniewska', '+48 987 654 321', 'ewa.wisniewska@example.com', 'dermatolog');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, specialization)
VALUES (5, 'Jan', 'Nowicki', '+48 333 444 555', 'jan.nowicki@example.com', 'ortopeda');

-- Pacjenci
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
VALUES (1, 'Andrzej', 'Karolak', '+49 113 845 149', 'andrzejkarolak@onet.pl', 'patient01', '1999-01-18');

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
VALUES (2, 'Anna', 'Nowak', '+48 555 123 456', 'anna.nowak@example.com', 'patient02', '1985-07-10');

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
VALUES (3, 'Tomasz', 'Kowalski', '+44 789 456 123', 'tomasz.kowalski@example.com', 'patient03', '1976-03-25');

-- Wizyty
INSERT INTO visit (doctor_id, patient_id, time)
VALUES (1, 1, '2024-04-25 14:00:00');

INSERT INTO visit (doctor_id, patient_id, time)
VALUES (2, 2, '2024-04-26 10:00:00');

INSERT INTO visit (doctor_id, patient_id, time)
VALUES (3, 3, '2024-04-27 16:30:00');

INSERT INTO visit (doctor_id, patient_id, time)
VALUES (4, 1, '2024-04-28 09:00:00');

INSERT INTO visit (doctor_id, patient_id, time)
VALUES (5, 2, '2024-04-29 13:45:00');

