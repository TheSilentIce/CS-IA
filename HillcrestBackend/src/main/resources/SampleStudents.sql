DELETE FROM StudentUniversity;
DELETE FROM StudentCustomData;
DELETE FROM OtherStudent;
DELETE FROM EngineeringStudent;
DELETE FROM BusinessStudent;
DELETE FROM MedicalStudent;
DELETE FROM Student;

-- Base Student records for Medical Students
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Emma Johnson', 'Pre-Medicine', 2025, true, true, false, true, true, 3.92, 1520, 34, false, true, 'MEDICAL'),
    ('Michael Chen', 'Biology', 2024, true, true, false, false, true, 3.88, 1490, 33, true, false, 'MEDICAL'),
    ('Sophia Patel', 'Biochemistry', 2025, false, true, true, false, false, 3.76, 1450, 32, true, false, 'MEDICAL'),
    ('Alexander Kim', 'Human Physiology', 2023, true, true, false, true, true, 3.95, 1540, 35, false, true, 'MEDICAL'),
    ('Olivia Martinez', 'Neuroscience', 2024, true, true, true, true, false, 3.82, 1510, 34, true, false, 'MEDICAL');

-- Medical Student specific records
INSERT INTO MedicalStudent (student_id, in_hosa, did_research)
VALUES
    (1, true, true),
    (2, true, true),
    (3, false, true),
    (4, true, true),
    (5, false, true);

-- Base Student records for Business Students
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Ethan Williams', 'Business Administration', 2024, false, false, true, true, true, 3.65, 1420, 31, true, false, 'BUSINESS'),
    ('Ava Thompson', 'Finance', 2023, true, true, false, true, true, 3.78, 1460, 32, true, false, 'BUSINESS'),
    ('Noah Garcia', 'Marketing', 2025, false, true, true, true, false, 3.42, 1350, 29, true, true, 'BUSINESS'),
    ('Isabella Wilson', 'Accounting', 2024, true, false, false, true, true, 3.91, 1480, 33, false, false, 'BUSINESS'),
    ('Liam Davis', 'International Business', 2023, false, true, true, true, false, 3.58, 1390, 30, true, true, 'BUSINESS');

-- Business Student specific records
INSERT INTO BusinessStudent (student_id, had_business, in_business_club)
VALUES
    (6, true, true),
    (7, false, true),
    (8, true, false),
    (9, false, true),
    (10, true, true);

-- Base Student records for Engineering Students
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Charlotte Brown', 'Computer Engineering', 2024, true, false, false, true, true, 3.87, 1510, 34, true, true, 'ENGINEERING'),
    ('Benjamin Taylor', 'Mechanical Engineering', 2025, false, true, true, false, true, 3.72, 1470, 32, false, false, 'ENGINEERING'),
    ('Amelia Anderson', 'Electrical Engineering', 2023, true, false, false, true, true, 3.94, 1530, 35, true, false, 'ENGINEERING'),
    ('Lucas Thomas', 'Civil Engineering', 2024, false, true, true, false, false, 3.62, 1420, 31, true, true, 'ENGINEERING'),
    ('Mia Rodriguez', 'Software Engineering', 2025, true, false, false, true, true, 3.89, 1520, 34, false, false, 'ENGINEERING');

-- Engineering Student specific records
INSERT INTO EngineeringStudent (student_id, in_fbla, did_personal_project)
VALUES
    (11, true, true),
    (12, false, true),
    (13, true, true),
    (14, false, true),
    (15, true, false);

-- Base Student records for Other Students
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Harper Clark', 'Psychology', 2024, true, true, false, false, false, 3.75, 1450, 32, true, false, 'OTHER'),
    ('Henry Lewis', 'English Literature', 2023, false, true, true, true, false, 3.58, 1380, 30, false, true, 'OTHER'),
    ('Evelyn Lee', 'History', 2025, true, true, false, true, false, 3.82, 1470, 33, true, false, 'OTHER'),
    ('Daniel Walker', 'Political Science', 2024, false, false, true, true, true, 3.69, 1410, 31, true, true, 'OTHER'),
    ('Abigail Hall', 'Communications', 2023, true, true, false, false, false, 3.77, 1440, 32, false, false, 'OTHER');

-- Other Student specific records
INSERT INTO OtherStudent (student_id)
VALUES
    (16),
    (17),
    (18),
    (19),
    (20);

-- Sample Custom Data entries
INSERT INTO StudentCustomData (student_id, key_name, value_data)
VALUES
    (1, 'hospital_volunteer_hours', '250'),
    (1, 'dream_specialty', 'Cardiology'),
    (2, 'research_project', 'Gene editing with CRISPR'),
    (6, 'startup_idea', 'Sustainable fashion marketplace'),
    (6, 'internship', 'Goldman Sachs - Summer 2023'),
    (11, 'programming_languages', 'Python, Java, C++'),
    (11, 'github_profile', 'github.com/charlottebrown'),
    (16, 'publications', 'Journal of Psychology Vol.45');