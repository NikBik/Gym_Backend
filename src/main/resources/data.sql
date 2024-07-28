

-- Insert dummy data into the gym_class table

INSERT INTO gym_class (name, schedule) VALUES
('Yoga Basics', '2024-07-30 08:00:00'),
('Advanced Pilates', '2024-07-30 09:30:00'),
('Cardio Blast', '2024-07-31 18:00:00'),
('Strength Training', '2024-08-01 17:00:00');

-- Insert dummy data into the workout table

INSERT INTO workout (user_id, program_id, details, workout_date) VALUES
(1, 201, 'Completed 30 minutes of cardio, 15 minutes of stretching.', '2023-01-05'),
(2, 202, 'Completed strength training with focus on legs and back.','2023-01-05'),
(3, 203, 'Participated in advanced yoga class.','2023-01-05'),
(4, 204, 'Did a full-body workout with emphasis on upper body.','2023-01-05');

-- Insert dummy data into the equipment table

INSERT INTO equipment (name, status) VALUES
('Treadmill', 'Available'),
('Stationary Bike', 'Under Maintenance'),
('Dumbbells Set', 'Available'),
('Elliptical Trainer', 'Available');

INSERT INTO users (USER_NAME,  FIRST_NAME , LAST_NAME , PASSWORD , LAST_LOGIN) VALUES
('omy', 'Om', 'Doe', 'dumbbellsparadise123', CURRENT_TIMESTAMP),
('niket', 'Niket', 'Sourabh', 'dumbbellsparadise123', CURRENT_TIMESTAMP),
('nikbik', 'NikBik', 'Johnson', 'dumbbellsparadise123', CURRENT_TIMESTAMP);

-- Insert example programs
INSERT INTO GYM_PROGRAMS (PROGRAM_NAMES, DESCRIPTION, CHARGES, PERIOD) VALUES
('Personal Training', 'One-on-one training sessions with a certified personal trainer. Customized workout and nutrition plans.', 50.00, 'Per Session'),
('Group Yoga', 'Yoga classes in a group setting focusing on flexibility, strength, and relaxation.', 20.00, 'Per Class'),
('HIIT Bootcamp', 'High-Intensity Interval Training sessions designed to improve cardiovascular fitness and strength.', 25.00, 'Per Class'),
('Nutritional Counseling', 'Personalized nutrition advice and meal planning from a certified nutritionist.', 75.00, 'Per Session'),
('Senior Fitness', 'Specialized fitness programs for seniors to enhance mobility, strength, and overall health.', 30.00, 'Per Class'),
('Pre/Post-Natal Fitness', 'Fitness programs tailored for pre and post-natal women to maintain health and fitness during and after pregnancy.', 35.00, 'Per Class'),
('Virtual Fitness Classes', 'Online workout sessions including a variety of classes like yoga, HIIT, and strength training.', 15.00, 'Per Class'),
('Fitness Workshops', 'Workshops on various fitness topics including advanced techniques and wellness strategies.', 40.00, 'Per Workshop');

-- Insert sample data into the membership table

INSERT INTO membership (user_id, plan_id, start_date, end_date) VALUES
(1, 1, '2024-01-01', '2024-02-01'),
(2, 2, '2024-01-15', '2024-02-15'),
(3, 3, '2024-02-01', '2024-03-01'),
(1, 5, '2024-03-01', '2024-04-01');
