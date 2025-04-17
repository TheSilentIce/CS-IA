DELETE FROM StudentUniversity;
DELETE FROM StudentCustomData;
DELETE FROM OtherStudent;
DELETE FROM EngineeringStudent;
DELETE FROM BusinessStudent;
DELETE FROM MedicalStudent;
DELETE FROM Student;

-- MEDICAL STUDENTS (15 students)
-- Batch 1 (students 1-8)
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Jasmine Rivera', 'Pre-Medicine', 2026, true, true, true, true, false, 3.94, 1530, 35, false, true, 'MEDICAL'),
    ('Marcus Wei', 'Biochemistry', 2025, true, true, false, true, true, 3.91, 1510, 34, true, false, 'MEDICAL'),
    ('Sophia Patel', 'Pre-Medicine', 2026, false, true, true, false, false, 3.87, 1490, 33, true, false, 'MEDICAL'),
    ('Jackson Lee', 'Neuroscience', 2027, true, true, false, true, true, 3.96, 1550, 36, false, true, 'MEDICAL'),
    ('Olivia Rodriguez', 'Biochemistry', 2025, true, true, true, true, false, 3.89, 1500, 34, true, false, 'MEDICAL'),
    ('Ethan Kim', 'Human Physiology', 2026, false, true, false, true, true, 3.85, 1480, 33, false, true, 'MEDICAL'),
    ('Amara Johnson', 'Molecular Biology', 2025, true, true, true, false, false, 3.92, 1520, 35, true, false, 'MEDICAL'),
    ('Noah Chen', 'Pre-Medicine', 2027, true, false, false, true, true, 3.93, 1525, 35, false, true, 'MEDICAL');

-- Batch 2 (students 9-15)
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Isabella Gupta', 'Biomedical Sciences', 2026, false, true, true, true, false, 3.84, 1470, 32, true, false, 'MEDICAL'),
    ('Caleb Washington', 'Pre-Medicine', 2025, true, true, false, false, true, 3.90, 1505, 34, true, true, 'MEDICAL'),
    ('Emma Nguyen', 'Biochemistry', 2027, true, true, true, true, false, 3.88, 1495, 33, false, false, 'MEDICAL'),
    ('Lucas Thompson', 'Human Biology', 2026, false, true, false, true, true, 3.86, 1485, 33, true, true, 'MEDICAL'),
    ('Zoe Martinez', 'Pre-Medicine', 2025, true, true, true, false, false, 3.95, 1540, 35, true, false, 'MEDICAL'),
    ('Aiden Garcia', 'Molecular Biology', 2027, true, false, false, true, true, 3.92, 1515, 34, false, true, 'MEDICAL'),
    ('Madison Chen', 'Neuroscience', 2026, false, true, true, true, false, 3.89, 1500, 33, true, false, 'MEDICAL');

-- BUSINESS STUDENTS (15 students)
-- Batch 1 (students 16-23)
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Zoe Peterson', 'Finance', 2026, true, false, true, true, true, 3.85, 1480, 33, true, false, 'BUSINESS'),
    ('Cameron Brooks', 'Marketing', 2025, false, true, true, true, false, 3.67, 1420, 31, true, true, 'BUSINESS'),
    ('Destiny Washington', 'Entrepreneurship', 2026, true, true, false, true, true, 3.79, 1460, 32, true, false, 'BUSINESS'),
    ('Trevor Knight', 'Business Administration', 2025, false, false, true, true, true, 3.72, 1435, 31, true, true, 'BUSINESS'),
    ('Bianca Martinez', 'International Business', 2027, true, true, false, true, false, 3.83, 1470, 32, false, false, 'BUSINESS'),
    ('Malik Johnson', 'Finance', 2026, true, false, true, false, true, 3.76, 1450, 32, true, true, 'BUSINESS'),
    ('Kylie Chen', 'Marketing', 2025, false, true, true, true, false, 3.69, 1425, 31, false, false, 'BUSINESS'),
    ('Jamal Wilson', 'Entrepreneurship', 2027, true, true, false, true, true, 3.81, 1465, 32, true, true, 'BUSINESS');

-- Batch 2 (students 24-30)
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Alicia Patel', 'Business Analytics', 2026, false, false, true, false, true, 3.75, 1445, 32, false, false, 'BUSINESS'),
    ('Devin Thompson', 'Finance', 2025, true, true, true, true, false, 3.88, 1495, 33, true, true, 'BUSINESS'),
    ('Natalie Garcia', 'Marketing', 2027, false, false, true, true, true, 3.71, 1430, 31, false, false, 'BUSINESS'),
    ('Marcus Jackson', 'Business Administration', 2026, true, true, false, false, true, 3.77, 1455, 32, true, true, 'BUSINESS'),
    ('Jada Brown', 'International Business', 2025, false, true, true, true, false, 3.84, 1475, 32, false, false, 'BUSINESS'),
    ('Tyler Lee', 'Finance', 2027, true, false, true, false, true, 3.73, 1440, 31, true, true, 'BUSINESS'),
    ('Brianna Wilson', 'Marketing', 2026, false, true, false, true, true, 3.80, 1460, 32, false, false, 'BUSINESS');

-- ENGINEERING STUDENTS (10 students)
-- Batch 1 (students 31-40)
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Elijah Patel', 'Aerospace Engineering', 2025, true, false, true, true, true, 3.93, 1540, 35, false, true, 'ENGINEERING'),
    ('Mia Nguyen', 'Biomedical Engineering', 2026, true, true, false, true, true, 3.88, 1520, 34, true, false, 'ENGINEERING'),
    ('Connor Williams', 'Computer Engineering', 2025, false, true, true, true, false, 3.91, 1530, 35, true, true, 'ENGINEERING'),
    ('Ariana Ramirez', 'Mechanical Engineering', 2026, true, false, true, false, true, 3.95, 1550, 36, false, false, 'ENGINEERING'),
    ('Dante Robinson', 'Civil Engineering', 2027, false, true, false, true, true, 3.87, 1510, 34, true, true, 'ENGINEERING'),
    ('Leila Vasquez', 'Software Engineering', 2025, true, true, true, false, false, 3.92, 1535, 35, false, false, 'ENGINEERING'),
    ('Ravi Kapoor', 'Electrical Engineering', 2026, false, false, true, true, true, 3.89, 1525, 35, true, true, 'ENGINEERING'),
    ('Sophia Jenkins', 'Chemical Engineering', 2025, true, true, false, true, false, 3.94, 1545, 36, false, false, 'ENGINEERING'),
    ('Aiden Harris', 'Materials Science', 2027, false, true, true, false, true, 3.86, 1505, 34, true, true, 'ENGINEERING'),
    ('Yara Al-Farsi', 'Aerospace Engineering', 2026, true, false, true, true, false, 3.90, 1530, 35, false, false, 'ENGINEERING');

-- OTHER STUDENTS (10 students)
-- Batch 1 (students 41-50)
INSERT INTO Student (name, major, graduation_year, is_in_honors_society, had_volunteering, had_sports,
                    had_leadership, had_competition, gpa, sat, act, had_job, had_doom_scrolled, student_type)
VALUES
    ('Kai Tanaka', 'Environmental Science', 2025, true, true, true, false, false, 3.82, 1470, 32, true, false, 'OTHER'),
    ('Nora Ibrahim', 'International Relations', 2026, false, true, true, true, false, 3.76, 1450, 31, true, true, 'OTHER'),
    ('Jordan Ramirez', 'Film Studies', 2025, true, false, false, true, true, 3.71, 1430, 30, false, true, 'OTHER'),
    ('Ava Mitchell', 'Psychology', 2027, false, true, true, false, false, 3.78, 1455, 32, true, false, 'OTHER'),
    ('Liam Carter', 'English Literature', 2026, true, false, false, true, true, 3.74, 1440, 31, false, true, 'OTHER'),
    ('Aria Wong', 'Sociology', 2025, false, true, true, true, false, 3.80, 1460, 32, true, false, 'OTHER'),
    ('Santiago Reyes', 'Political Science', 2027, true, true, false, false, true, 3.77, 1450, 31, false, true, 'OTHER'),
    ('Maya Foster', 'Anthropology', 2026, false, false, true, true, false, 3.73, 1435, 30, true, false, 'OTHER'),
    ('Harrison Edwards', 'Philosophy', 2025, true, true, true, false, true, 3.79, 1460, 32, false, true, 'OTHER'),
    ('Zuri Johnson', 'Communications', 2027, false, true, false, true, false, 3.75, 1445, 31, true, false, 'OTHER');

-- Medical Student specific records
INSERT INTO MedicalStudent (student_id, in_hosa, did_research)
VALUES
    (1, true, true), (2, false, true), (3, true, false), (4, true, true), (5, false, true),
    (6, true, false), (7, false, true), (8, true, true), (9, false, false), (10, true, true),
    (11, false, true), (12, true, false), (13, true, true), (14, false, true), (15, true, false);

-- Business Student specific records
INSERT INTO BusinessStudent (student_id, had_business, in_business_club)
VALUES
    (16, true, true), (17, true, false), (18, false, true), (19, true, true), (20, false, false),
    (21, true, true), (22, false, true), (23, true, false), (24, false, true), (25, true, true),
    (26, false, false), (27, true, true), (28, false, true), (29, true, false), (30, false, true);

-- Engineering Student specific records
INSERT INTO EngineeringStudent (student_id, in_fbla, did_personal_project)
VALUES
    (31, true, true), (32, false, true), (33, true, false), (34, false, true), (35, true, true),
    (36, false, false), (37, true, true), (38, false, true), (39, true, false), (40, false, true);

-- Other Student specific records
INSERT INTO OtherStudent (student_id)
VALUES
    (41), (42), (43), (44), (45), (46), (47), (48), (49), (50);

-- Custom Data entries
INSERT INTO StudentCustomData (student_id, key_name, value_data)
VALUES
    -- Medical Students
    (1, 'hospital_volunteer_hours', '320'),
    (1, 'dream_specialty', 'Neurosurgery'),
    (2, 'research_project', 'Antibiotic resistance mechanisms'),
    (3, 'shadowing_experience', 'Cardiology, 150 hours'),
    (4, 'mcat_score', '518'),
    (5, 'published_papers', '2'),
    (6, 'clinical_experience', 'Emergency department, 200 hours'),
    (7, 'research_lab', 'Immunology Research Center'),

    -- Business Students
    (16, 'internship', 'JPMorgan Chase - Summer 2024'),
    (16, 'stock_portfolio_value', '$12,450'),
    (17, 'business_idea', 'Sustainable fashion e-commerce platform'),
    (18, 'leadership_role', 'President of Entrepreneurship Society'),
    (19, 'startup_competition', 'Finalist, University Venture Challenge 2024'),
    (20, 'investment_fund', 'Student-managed fund, $2.5M AUM'),

    -- Engineering Students
    (31, 'programming_languages', 'Python, MATLAB, C++, Java, R'),
    (31, 'github_profile', 'github.com/elijahpatel'),
    (32, 'research_lab', 'Tissue Engineering Laboratory'),
    (33, 'engineering_project', 'Solar-powered water purification system'),
    (34, 'hackathon_awards', 'Winner, NASA Space Apps Challenge 2024'),
    (35, 'patent_application', 'Pending: Smart prosthetic control system'),

    -- Other Students
    (41, 'field_research', 'Amazon Rainforest Conservation Project'),
    (42, 'languages', 'English, Arabic, French, Spanish'),
    (43, 'portfolio', 'jordanramirez.com/films'),
    (44, 'research_focus', 'Cognitive behavioral therapy for anxiety disorders'),
    (45, 'published_work', 'Short story collection in University Literary Review');