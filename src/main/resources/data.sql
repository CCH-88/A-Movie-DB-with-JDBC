-- Movies
INSERT INTO movie ("title") VALUES ('Spider-man'); -- 1
INSERT INTO movie ("title") VALUES ('The Hulk'); -- 2
INSERT INTO movie ("title") VALUES ('Thor'); -- 3


-- Character
INSERT INTO character (alias, gender, "name", picture_url) VALUES ('Peter Parker', 'male', 'Spider-man','https://upload.wikimedia.org/wikipedia/en/2/21/Web_of_Spider-Man_Vol_1_129-1.png'); -- 1
INSERT INTO character (alias, gender, "name", picture_url) VALUES ('Robert Bruce Banner', 'male', 'The Hulk','https://upload.wikimedia.org/wikipedia/en/a/aa/Hulk_%28circa_2019%29.png'); -- 2
INSERT INTO character (alias, gender, "name", picture_url) VALUES ('Thor Odinson', 'male', 'Thor','https://upload.wikimedia.org/wikipedia/en/4/41/Thor-272.jpg'); -- 3

-- Franchise
INSERT INTO franchise (description, "name") VALUES ('A superhero franchise', 'Marvel'); -- 1


-- Characters in movie (Students in subject)
--INSERT INTO student_subject (student_id, subject_id) VALUES (1,1);
--INSERT INTO student_subject (student_id, subject_id) VALUES (2,1);
