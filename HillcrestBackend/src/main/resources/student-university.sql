-- Clear existing student-university associations
DELETE FROM StudentUniversity;

-- Associate Students with Universities in all 50 states, matching student types with appropriate universities
-- The following mappings consider that:
-- Medical students: IDs 1-5
-- Business students: IDs 6-10
-- Engineering students: IDs 11-15
-- Other students: IDs 16-20

-- Alabama (universities 1-3)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(1, 1), (2, 1),   -- Medical students at University of Alabama
(6, 2), (7, 2);   -- Business students at Auburn University

-- Alaska (universities 4-6)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(11, 4), (12, 4), -- Engineering students at University of Alaska Fairbanks
(16, 5), (17, 5); -- Other students at Alaska Pacific University

-- Arizona (universities 7-9)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(3, 7), (4, 7),   -- Medical students at University of Arizona
(8, 8), (9, 8);   -- Business students at Arizona State University

-- Arkansas (universities 10-12)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(13, 10), (14, 10), -- Engineering students at University of Arkansas
(18, 11), (19, 11); -- Other students at Arkansas State University

-- California (universities 13-15)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(5, 13), (1, 13),   -- Medical students at University of California, Berkeley
(10, 14), (6, 14),  -- Business students at Stanford University
(15, 15), (11, 15); -- Engineering students at University of California, Los Angeles

-- Colorado (universities 16-18)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(2, 16), (3, 16),   -- Medical students at University of Colorado Boulder
(7, 17), (8, 17);   -- Business students at Colorado State University

-- Connecticut (universities 19-21)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(12, 19), (13, 19), -- Engineering students at Yale University
(20, 20), (16, 20); -- Other students at University of Connecticut

-- Delaware (universities 22-24)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(4, 22), (5, 22),   -- Medical students at University of Delaware
(9, 23), (10, 23);  -- Business students at Delaware State University

-- Florida (universities 25-27)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(14, 25), (15, 25), -- Engineering students at University of Florida
(17, 26), (18, 26); -- Other students at Florida State University

-- Georgia (universities 28-30)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(1, 28), (2, 28),   -- Medical students at University of Georgia
(6, 29), (7, 29);   -- Business students at Georgia Institute of Technology

-- Hawaii (universities 31-33)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(11, 31), (12, 31), -- Engineering students at University of Hawaii at Manoa
(19, 32), (20, 32); -- Other students at Hawaii Pacific University

-- Idaho (universities 34-36)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(3, 34), (4, 34),   -- Medical students at Boise State University
(8, 35), (9, 35);   -- Business students at University of Idaho

-- Illinois (universities 37-39)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(13, 37), (14, 37), -- Engineering students at University of Chicago
(5, 38), (1, 38);   -- Medical students at Northwestern University

-- Indiana (universities 40-42)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(10, 40), (6, 40),  -- Business students at Purdue University
(16, 41), (17, 41); -- Other students at Indiana University Bloomington

-- Iowa (universities 43-45)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(2, 43), (3, 43),   -- Medical students at University of Iowa
(15, 44), (11, 44); -- Engineering students at Iowa State University

-- Kansas (universities 46-48)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(7, 46), (8, 46),   -- Business students at University of Kansas
(18, 47), (19, 47); -- Other students at Kansas State University

-- Kentucky (universities 49-51)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(4, 49), (5, 49),   -- Medical students at University of Kentucky
(12, 50), (13, 50); -- Engineering students at University of Louisville

-- Louisiana (universities 52-54)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(9, 52), (10, 52),  -- Business students at Tulane University
(20, 53), (16, 53); -- Other students at Louisiana State University

-- Maine (universities 55-57)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(1, 55), (2, 55),   -- Medical students at Bowdoin College
(14, 56), (15, 56); -- Engineering students at University of Maine

-- Maryland (universities 58-60)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(6, 58), (7, 58),   -- Business students at Johns Hopkins University
(17, 59), (18, 59); -- Other students at University of Maryland

-- Massachusetts (universities 61-63)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(3, 61), (4, 61),   -- Medical students at Harvard University
(11, 62), (12, 62), -- Engineering students at MIT
(5, 63), (1, 63);   -- Medical students at Boston University

-- Michigan (universities 64-66)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(8, 64), (9, 64),   -- Business students at University of Michigan
(19, 65), (20, 65); -- Other students at Michigan State University

-- Minnesota (universities 67-69)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(13, 67), (14, 67), -- Engineering students at University of Minnesota
(2, 68), (3, 68);   -- Medical students at Carleton College

-- Mississippi (universities 70-72)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(10, 70), (6, 70),  -- Business students at University of Mississippi
(16, 71), (17, 71); -- Other students at Mississippi State University

-- Missouri (universities 73-75)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(4, 73), (5, 73),   -- Medical students at Washington University in St. Louis
(15, 74), (11, 74); -- Engineering students at University of Missouri

-- Montana (universities 76-78)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(7, 76), (8, 76),   -- Business students at University of Montana
(18, 77), (19, 77); -- Other students at Montana State University

-- Nebraska (universities 79-81)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(1, 79), (2, 79),   -- Medical students at University of Nebraska-Lincoln
(12, 80), (13, 80); -- Engineering students at Creighton University

-- Nevada (universities 82-84)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(9, 82), (10, 82),  -- Business students at University of Nevada, Las Vegas
(20, 83), (16, 83); -- Other students at University of Nevada, Reno

-- New Hampshire (universities 85-87)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(3, 85), (4, 85),   -- Medical students at Dartmouth College
(14, 86), (15, 86); -- Engineering students at University of New Hampshire

-- New Jersey (universities 88-90)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(5, 88), (1, 88),   -- Medical students at Princeton University
(17, 89), (18, 89); -- Other students at Rutgers University

-- New Mexico (universities 91-93)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(6, 91), (7, 91),   -- Business students at University of New Mexico
(11, 92), (12, 92); -- Engineering students at New Mexico State University

-- New York (universities 94-96)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(2, 94), (3, 94),   -- Medical students at Columbia University
(8, 95), (9, 95),   -- Business students at Cornell University
(19, 96), (20, 96); -- Other students at New York University

-- North Carolina (universities 97-99)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(13, 97), (14, 97), -- Engineering students at Duke University
(4, 98), (5, 98);   -- Medical students at UNC Chapel Hill

-- North Dakota (universities 100-102)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(10, 100), (6, 100), -- Business students at University of North Dakota
(16, 101), (17, 101); -- Other students at North Dakota State University

-- Ohio (universities 103-105)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(1, 103), (2, 103), -- Medical students at Ohio State University
(15, 104), (11, 104); -- Engineering students at Case Western Reserve University

-- Oklahoma (universities 106-108)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(7, 106), (8, 106),   -- Business students at University of Oklahoma
(18, 107), (19, 107); -- Other students at Oklahoma State University

-- Oregon (universities 109-111)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(3, 109), (4, 109), -- Medical students at University of Oregon
(12, 110), (13, 110); -- Engineering students at Oregon State University

-- Pennsylvania (universities 112-114)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(9, 112), (10, 112),  -- Business students at University of Pennsylvania
(5, 113), (1, 113),   -- Medical students at Carnegie Mellon University
(20, 114), (16, 114); -- Other students at Pennsylvania State University

-- Rhode Island (universities 115-117)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(14, 115), (15, 115), -- Engineering students at Brown University
(2, 116), (3, 116);   -- Medical students at University of Rhode Island

-- South Carolina (universities 118-120)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(6, 118), (7, 118),   -- Business students at University of South Carolina
(17, 119), (18, 119); -- Other students at Clemson University

-- South Dakota (universities 121-123)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(4, 121), (5, 121),   -- Medical students at University of South Dakota
(11, 122), (12, 122); -- Engineering students at South Dakota State University

-- Tennessee (universities 124-126)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(8, 124), (9, 124),   -- Business students at Vanderbilt University
(19, 125), (20, 125); -- Other students at University of Tennessee

-- Texas (universities 127-129)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(13, 127), (14, 127), -- Engineering students at University of Texas at Austin
(1, 128), (2, 128),   -- Medical students at Rice University
(10, 129), (6, 129);  -- Business students at Texas A&M University

-- Utah (universities 130-132)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(15, 130), (11, 130), -- Engineering students at University of Utah
(3, 131), (4, 131),   -- Medical students at Brigham Young University
(7, 132), (8, 132);   -- Business students at Utah State University

-- Vermont (universities 133-135)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(16, 133), (17, 133), -- Other students at University of Vermont
(5, 134), (1, 134);   -- Medical students at Middlebury College

-- Virginia (universities 136-138)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(12, 136), (13, 136), -- Engineering students at University of Virginia
(2, 137), (3, 137);   -- Medical students at College of William & Mary

-- Washington (universities 139-141)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(9, 139), (10, 139),  -- Business students at University of Washington
(18, 140), (19, 140); -- Other students at Washington State University

-- West Virginia (universities 142-144)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(4, 142), (5, 142),   -- Medical students at West Virginia University
(14, 143), (15, 143); -- Engineering students at Marshall University

-- Wisconsin (universities 145-147)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(6, 145), (7, 145),   -- Business students at University of Wisconsin-Madison
(20, 146), (16, 146); -- Other students at Marquette University

-- Wyoming (universities 148-150)
INSERT INTO StudentUniversity (student_id, university_id) VALUES
(1, 148), (2, 148),   -- Medical students at University of Wyoming
(8, 149), (9, 149),   -- Business students at Wyoming Catholic College
(11, 150), (12, 150); -- Engineering students at Casper College