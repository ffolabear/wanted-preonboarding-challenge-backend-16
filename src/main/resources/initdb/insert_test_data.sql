INSERT INTO `performance` (name, price, round, type, start_date, is_reserve)
VALUES ('레베카', 100000, 1, 0, '2024-01-20 19:30:00', 'disable'),
       ('퍼거슨', 900000, 2, 0, '2024-01-24 12:30:00', 'disable'),
       ('레오나르도', 95000, 1, 0, '2024-01-20 16:30:00', 'disable'),
       ('디카프리오', 80000, 2, 0, '2024-01-15 11:30:00', 'disable'),
       ('톰', 70000, 3, 1, '2024-01-20 17:30:00', 'disable'),
       ('크루즈', 50000, 1, 2, '2024-01-21 21:30:00', 'disable'),
       ('조니', 40000, 2, 1, '2024-01-24 19:30:00', 'disable'),
       ('뎁', 50000, 1, 1, '2024-01-22 19:30:00', 'disable')
       ;

INSERT INTO performance_seat_info VALUES
 (DEFAULT, (SELECT id FROM performance limit 1), 1, 1, 'A', 1, 'enable', DEFAULT, DEFAULT)
,(DEFAULT, (SELECT id FROM performance limit 1), 1, 1, 'A', 2, 'enable', DEFAULT, DEFAULT)
,(DEFAULT, (SELECT id FROM performance limit 1), 1, 1, 'A', 3, 'enable', DEFAULT, DEFAULT)
,(DEFAULT, (SELECT id FROM performance limit 1), 1, 1, 'A', 4, 'enable', DEFAULT, DEFAULT);
