-- Clear existing student-university associations
DELETE FROM StudentUniversity;

-- Each student is assigned to exactly one university
-- Distributing students across different states to ensure good coverage

-- MEDICAL STUDENTS (IDs 1-15)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
-- Top medical schools across different states
(1, 61),  -- Jasmine Rivera at Harvard University (Massachusetts)
(2, 58),  -- Marcus Wei at Johns Hopkins University (Maryland)
(3, 13),  -- Sophia Patel at UC Berkeley (California)
(4, 94),  -- Jackson Lee at Columbia University (New York)
(5, 14),  -- Olivia Rodriguez at Stanford University (California)
(6, 73),  -- Ethan Kim at Washington University in St. Louis (Missouri)
(7, 97),  -- Amara Johnson at Duke University (North Carolina)
(8, 43),  -- Noah Chen at University of Iowa (Iowa)
(9, 28),  -- Isabella Gupta at University of Georgia (Georgia)
(10, 49), -- Caleb Washington at University of Kentucky (Kentucky)
(11, 98), -- Emma Nguyen at UNC Chapel Hill (North Carolina)
(12, 100), -- Lucas Thompson at University of North Dakota (North Dakota)
(13, 103), -- Zoe Martinez at Ohio State University (Ohio)
(14, 112), -- Aiden Garcia at University of Pennsylvania (Pennsylvania)
(15, 1);   -- Madison Chen at University of Alabama (Alabama)

-- BUSINESS STUDENTS (IDs 16-30)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
-- Top business schools across different states
(16, 112), -- Zoe Peterson at University of Pennsylvania (Pennsylvania)
(17, 37),  -- Cameron Brooks at University of Chicago (Illinois)
(18, 64),  -- Destiny Washington at University of Michigan (Michigan)
(19, 14),  -- Trevor Knight at Stanford University (California)
(20, 61),  -- Bianca Martinez at Harvard University (Massachusetts)
(21, 139), -- Malik Johnson at University of Washington (Washington)
(22, 127), -- Kylie Chen at University of Texas at Austin (Texas)
(23, 19),  -- Jamal Wilson at Yale University (Connecticut)
(24, 124), -- Alicia Patel at Vanderbilt University (Tennessee)
(25, 70),  -- Devin Thompson at University of Mississippi (Mississippi)
(26, 106), -- Natalie Garcia at University of Oklahoma (Oklahoma)
(27, 22),  -- Marcus Jackson at University of Delaware (Delaware)
(28, 25),  -- Jada Brown at University of Florida (Florida)
(29, 4),   -- Tyler Lee at University of Alaska Fairbanks (Alaska)
(30, 7);   -- Brianna Wilson at University of Arizona (Arizona)

-- ENGINEERING STUDENTS (IDs 31-40)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
-- Top engineering schools across different states
(31, 62),  -- Elijah Patel at MIT (Massachusetts)
(32, 29),  -- Mia Nguyen at Georgia Tech (Georgia)
(33, 13),  -- Connor Williams at UC Berkeley (California)
(34, 127), -- Ariana Ramirez at University of Texas at Austin (Texas)
(35, 136), -- Dante Robinson at University of Virginia (Virginia)
(36, 104), -- Leila Vasquez at Case Western Reserve University (Ohio)
(37, 40),  -- Ravi Kapoor at Purdue University (Indiana)
(38, 145), -- Sophia Jenkins at University of Wisconsin-Madison (Wisconsin)
(39, 16),  -- Aiden Harris at University of Colorado Boulder (Colorado)
(40, 10);  -- Yara Al-Farsi at University of Arkansas (Arkansas)

-- OTHER STUDENTS (IDs 41-50)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
-- Liberal arts and diverse universities across different states
(41, 95),  -- Kai Tanaka at Cornell University (New York)
(42, 19),  -- Nora Ibrahim at Yale University (Connecticut)
(43, 96),  -- Jordan Ramirez at New York University (New York)
(44, 55),  -- Ava Mitchell at Bowdoin College (Maine)
(45, 85),  -- Liam Carter at Dartmouth College (New Hampshire)
(46, 37),  -- Aria Wong at University of Chicago (Illinois)
(47, 91),  -- Santiago Reyes at University of New Mexico (New Mexico)
(48, 115), -- Maya Foster at Brown University (Rhode Island)
(49, 118), -- Harrison Edwards at University of South Carolina (South Carolina)
(50, 133); -- Zuri Johnson at University of Vermont (Vermont)