-- Main Student table
DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
    student_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    major VARCHAR(255),
    graduation_year INTEGER,
    is_in_honors_society BOOLEAN DEFAULT FALSE,
    had_volunteering BOOLEAN DEFAULT FALSE,
    had_sports BOOLEAN DEFAULT FALSE,
    had_leadership BOOLEAN DEFAULT FALSE,
    had_competition BOOLEAN DEFAULT FALSE,
    gpa DECIMAL(3,2),
    sat INTEGER,
    act INTEGER,
    had_job BOOLEAN DEFAULT FALSE,
    had_doom_scrolled BOOLEAN DEFAULT FALSE,
    student_type VARCHAR(20) NOT NULL -- To identify the type of student
);

-- MedicalStudent table
DROP TABLE IF EXISTS MedicalStudent;
CREATE TABLE MedicalStudent (
    student_id INTEGER PRIMARY KEY,
    in_hosa BOOLEAN DEFAULT FALSE,
    did_research BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE
);

-- BusinessStudent table
DROP TABLE IF EXISTS BusinessStudent;
CREATE TABLE BusinessStudent (
    student_id INTEGER PRIMARY KEY,
    had_business BOOLEAN DEFAULT FALSE,
    in_business_club BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE
);

-- EngineeringStudent table
DROP TABLE IF EXISTS EngineeringStudent;
CREATE TABLE EngineeringStudent (
    student_id INTEGER PRIMARY KEY,
    in_fbla BOOLEAN DEFAULT FALSE,
    did_personal_project BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE
);

-- OtherStudent table
DROP TABLE IF EXISTS OtherStudent;
CREATE TABLE OtherStudent (
    student_id INTEGER PRIMARY KEY,
    FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE
);

-- University table
DROP TABLE IF EXISTS University;
CREATE TABLE University (
    university_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- State table
DROP TABLE IF EXISTS State;
CREATE TABLE State (
    state_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- University-State relationship
DROP TABLE IF EXISTS UniversityState;
CREATE TABLE UniversityState (
    university_id INTEGER,
    state_id INTEGER,
    PRIMARY KEY (university_id, state_id),
    FOREIGN KEY (university_id) REFERENCES University(university_id) ON DELETE CASCADE,
    FOREIGN KEY (state_id) REFERENCES State(state_id) ON DELETE CASCADE
);

-- Student-University relationship
DROP TABLE IF EXISTS StudentUniversity;

CREATE TABLE StudentUniversity (
    student_id INTEGER,
    university_id INTEGER,
    PRIMARY KEY (student_id, university_id),
    FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE,
    FOREIGN KEY (university_id) REFERENCES University(university_id) ON DELETE CASCADE
);

-- Table for storing custom student data (representing the HashMap functionality)
DROP TABLE IF EXISTS StudentCustomData;

CREATE TABLE StudentCustomData (
    student_id INTEGER,
    key_name VARCHAR(255),
    value_data TEXT,
    PRIMARY KEY (student_id, key_name),
    FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE
);