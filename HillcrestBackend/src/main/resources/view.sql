-- Create a database view that joins Student and University data

--SELECT * FROM student_university_view;

CREATE OR REPLACE VIEW student_university_view AS
SELECT
    -- Create a combined unique ID for the view
    (s.student_id * 1000 + u.university_id) AS id,

    -- Student information
    s.student_id,
    s.name AS student_name,
    s.major,
    s.graduation_year,
    s.gpa,
    s.sat,
    s.act,
    s.student_type,
    s.is_in_honors_society,
    s.had_volunteering,
    s.had_sports,
    s.had_leadership,
    s.had_competition,
    s.had_job,

    -- University information
    u.university_id,
    u.name AS university_name

FROM
    student s
JOIN
    studentuniversity su ON s.student_id = su.student_id
JOIN
    university u ON su.university_id = u.university_id;

-- Create an index on the view for better performance
-- CREATE INDEX idx_student_university_view_student_id ON student_university_view(student_id);
-- CREATE INDEX idx_student_university_view_university_id ON student_university_view(university_id);
-- CREATE INDEX idx_student_university_view_student_name ON student_university_view(student_name);
-- CREATE INDEX idx_student_university_view_university_name ON student_university_view(university_name);
-- CREATE INDEX idx_student_university_view_major ON student_university_view(major);

-- Grant permissions if needed (adjust as necessary for your database setup)
-- GRANT SELECT ON student_university_view TO your_application_user;