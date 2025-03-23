INSERT INTO State (name) VALUES
('Alabama'), ('Alaska'), ('Arizona'), ('Arkansas'), ('California'),
('Colorado'), ('Connecticut'), ('Delaware'), ('Florida'), ('Georgia'),
('Hawaii'), ('Idaho'), ('Illinois'), ('Indiana'), ('Iowa'),
('Kansas'), ('Kentucky'), ('Louisiana'), ('Maine'), ('Maryland'),
('Massachusetts'), ('Michigan'), ('Minnesota'), ('Mississippi'), ('Missouri'),
('Montana'), ('Nebraska'), ('Nevada'), ('New Hampshire'), ('New Jersey'),
('New Mexico'), ('New York'), ('North Carolina'), ('North Dakota'), ('Ohio'),
('Oklahoma'), ('Oregon'), ('Pennsylvania'), ('Rhode Island'), ('South Carolina'),
('South Dakota'), ('Tennessee'), ('Texas'), ('Utah'), ('Vermont'),
('Virginia'), ('Washington'), ('West Virginia'), ('Wisconsin'), ('Wyoming');

-- Insert universities
INSERT INTO University (name) VALUES
-- Alabama
('University of Alabama'),
('Auburn University'),
('University of Alabama at Birmingham'),

-- Alaska
('University of Alaska Fairbanks'),
('Alaska Pacific University'),
('University of Alaska Anchorage'),

-- Arizona
('University of Arizona'),
('Arizona State University'),
('Northern Arizona University'),

-- Arkansas
('University of Arkansas'),
('Arkansas State University'),
('University of Central Arkansas'),

-- California
('University of California, Berkeley'),
('Stanford University'),
('University of California, Los Angeles'),

-- Colorado
('University of Colorado Boulder'),
('Colorado State University'),
('University of Denver'),

-- Connecticut
('Yale University'),
('University of Connecticut'),
('Wesleyan University'),

-- Delaware
('University of Delaware'),
('Delaware State University'),
('Wilmington University'),

-- Florida
('University of Florida'),
('Florida State University'),
('University of Miami'),

-- Georgia
('University of Georgia'),
('Georgia Institute of Technology'),
('Emory University'),

-- Hawaii
('University of Hawaii at Manoa'),
('Hawaii Pacific University'),
('Chaminade University of Honolulu'),

-- Idaho
('Boise State University'),
('University of Idaho'),
('Idaho State University'),

-- Illinois
('University of Chicago'),
('Northwestern University'),
('University of Illinois Urbana-Champaign'),

-- Indiana
('Purdue University'),
('Indiana University Bloomington'),
('University of Notre Dame'),

-- Iowa
('University of Iowa'),
('Iowa State University'),
('Drake University'),

-- Kansas
('University of Kansas'),
('Kansas State University'),
('Wichita State University'),

-- Kentucky
('University of Kentucky'),
('University of Louisville'),
('Western Kentucky University'),

-- Louisiana
('Tulane University'),
('Louisiana State University'),
('University of Louisiana at Lafayette'),

-- Maine
('Bowdoin College'),
('University of Maine'),
('Colby College'),

-- Maryland
('Johns Hopkins University'),
('University of Maryland'),
('United States Naval Academy'),

-- Massachusetts
('Harvard University'),
('Massachusetts Institute of Technology'),
('Boston University'),

-- Michigan
('University of Michigan'),
('Michigan State University'),
('Wayne State University'),

-- Minnesota
('University of Minnesota'),
('Carleton College'),
('St. Olaf College'),

-- Mississippi
('University of Mississippi'),
('Mississippi State University'),
('Jackson State University'),

-- Missouri
('Washington University in St. Louis'),
('University of Missouri'),
('Saint Louis University'),

-- Montana
('University of Montana'),
('Montana State University'),
('Carroll College'),

-- Nebraska
('University of Nebraska-Lincoln'),
('Creighton University'),
('Nebraska Wesleyan University'),

-- Nevada
('University of Nevada, Las Vegas'),
('University of Nevada, Reno'),
('Sierra Nevada University'),

-- New Hampshire
('Dartmouth College'),
('University of New Hampshire'),
('Southern New Hampshire University'),

-- New Jersey
('Princeton University'),
('Rutgers University'),
('Stevens Institute of Technology'),

-- New Mexico
('University of New Mexico'),
('New Mexico State University'),
('New Mexico Institute of Mining and Technology'),

-- New York
('Columbia University'),
('Cornell University'),
('New York University'),

-- North Carolina
('Duke University'),
('University of North Carolina at Chapel Hill'),
('North Carolina State University'),

-- North Dakota
('University of North Dakota'),
('North Dakota State University'),
('Minot State University'),

-- Ohio
('Ohio State University'),
('Case Western Reserve University'),
('University of Cincinnati'),

-- Oklahoma
('University of Oklahoma'),
('Oklahoma State University'),
('University of Tulsa'),

-- Oregon
('University of Oregon'),
('Oregon State University'),
('Reed College'),

-- Pennsylvania
('University of Pennsylvania'),
('Carnegie Mellon University'),
('Pennsylvania State University'),

-- Rhode Island
('Brown University'),
('University of Rhode Island'),
('Rhode Island School of Design'),

-- South Carolina
('University of South Carolina'),
('Clemson University'),
('College of Charleston'),

-- South Dakota
('University of South Dakota'),
('South Dakota State University'),
('Augustana University'),

-- Tennessee
('Vanderbilt University'),
('University of Tennessee'),
('Rhodes College'),

-- Texas
('University of Texas at Austin'),
('Rice University'),
('Texas A&M University'),

-- Utah
('University of Utah'),
('Brigham Young University'),
('Utah State University'),

-- Vermont
('University of Vermont'),
('Middlebury College'),
('Bennington College'),

-- Virginia
('University of Virginia'),
('College of William & Mary'),
('Virginia Tech'),

-- Washington
('University of Washington'),
('Washington State University'),
('Seattle University'),

-- West Virginia
('West Virginia University'),
('Marshall University'),
('West Virginia Wesleyan College'),

-- Wisconsin
('University of Wisconsin-Madison'),
('Marquette University'),
('Lawrence University'),

-- Wyoming
('University of Wyoming'),
('Wyoming Catholic College'),
('Casper College');

-- Associate universities with their states
WITH States AS (
    SELECT state_id, name FROM State
),
Universities AS (
    SELECT university_id, name FROM University
)

INSERT INTO UniversityState (university_id, state_id)
SELECT u.university_id, s.state_id FROM
(
    -- Alabama
    SELECT 'University of Alabama' as uni, 'Alabama' as state UNION ALL
    SELECT 'Auburn University', 'Alabama' UNION ALL
    SELECT 'University of Alabama at Birmingham', 'Alabama' UNION ALL

    -- Alaska
    SELECT 'University of Alaska Fairbanks', 'Alaska' UNION ALL
    SELECT 'Alaska Pacific University', 'Alaska' UNION ALL
    SELECT 'University of Alaska Anchorage', 'Alaska' UNION ALL

    -- Arizona
    SELECT 'University of Arizona', 'Arizona' UNION ALL
    SELECT 'Arizona State University', 'Arizona' UNION ALL
    SELECT 'Northern Arizona University', 'Arizona' UNION ALL

    -- Arkansas
    SELECT 'University of Arkansas', 'Arkansas' UNION ALL
    SELECT 'Arkansas State University', 'Arkansas' UNION ALL
    SELECT 'University of Central Arkansas', 'Arkansas' UNION ALL

    -- California
    SELECT 'University of California, Berkeley', 'California' UNION ALL
    SELECT 'Stanford University', 'California' UNION ALL
    SELECT 'University of California, Los Angeles', 'California' UNION ALL

    -- Colorado
    SELECT 'University of Colorado Boulder', 'Colorado' UNION ALL
    SELECT 'Colorado State University', 'Colorado' UNION ALL
    SELECT 'University of Denver', 'Colorado' UNION ALL

    -- Connecticut
    SELECT 'Yale University', 'Connecticut' UNION ALL
    SELECT 'University of Connecticut', 'Connecticut' UNION ALL
    SELECT 'Wesleyan University', 'Connecticut' UNION ALL

    -- Delaware
    SELECT 'University of Delaware', 'Delaware' UNION ALL
    SELECT 'Delaware State University', 'Delaware' UNION ALL
    SELECT 'Wilmington University', 'Delaware' UNION ALL

    -- Florida
    SELECT 'University of Florida', 'Florida' UNION ALL
    SELECT 'Florida State University', 'Florida' UNION ALL
    SELECT 'University of Miami', 'Florida' UNION ALL

    -- Georgia
    SELECT 'University of Georgia', 'Georgia' UNION ALL
    SELECT 'Georgia Institute of Technology', 'Georgia' UNION ALL
    SELECT 'Emory University', 'Georgia' UNION ALL

    -- Hawaii
    SELECT 'University of Hawaii at Manoa', 'Hawaii' UNION ALL
    SELECT 'Hawaii Pacific University', 'Hawaii' UNION ALL
    SELECT 'Chaminade University of Honolulu', 'Hawaii' UNION ALL

    -- Idaho
    SELECT 'Boise State University', 'Idaho' UNION ALL
    SELECT 'University of Idaho', 'Idaho' UNION ALL
    SELECT 'Idaho State University', 'Idaho' UNION ALL

    -- Illinois
    SELECT 'University of Chicago', 'Illinois' UNION ALL
    SELECT 'Northwestern University', 'Illinois' UNION ALL
    SELECT 'University of Illinois Urbana-Champaign', 'Illinois' UNION ALL

    -- Indiana
    SELECT 'Purdue University', 'Indiana' UNION ALL
    SELECT 'Indiana University Bloomington', 'Indiana' UNION ALL
    SELECT 'University of Notre Dame', 'Indiana' UNION ALL

    -- Iowa
    SELECT 'University of Iowa', 'Iowa' UNION ALL
    SELECT 'Iowa State University', 'Iowa' UNION ALL
    SELECT 'Drake University', 'Iowa' UNION ALL

    -- Kansas
    SELECT 'University of Kansas', 'Kansas' UNION ALL
    SELECT 'Kansas State University', 'Kansas' UNION ALL
    SELECT 'Wichita State University', 'Kansas' UNION ALL

    -- Kentucky
    SELECT 'University of Kentucky', 'Kentucky' UNION ALL
    SELECT 'University of Louisville', 'Kentucky' UNION ALL
    SELECT 'Western Kentucky University', 'Kentucky' UNION ALL

    -- Louisiana
    SELECT 'Tulane University', 'Louisiana' UNION ALL
    SELECT 'Louisiana State University', 'Louisiana' UNION ALL
    SELECT 'University of Louisiana at Lafayette', 'Louisiana' UNION ALL

    -- Maine
    SELECT 'Bowdoin College', 'Maine' UNION ALL
    SELECT 'University of Maine', 'Maine' UNION ALL
    SELECT 'Colby College', 'Maine' UNION ALL

    -- Maryland
    SELECT 'Johns Hopkins University', 'Maryland' UNION ALL
    SELECT 'University of Maryland', 'Maryland' UNION ALL
    SELECT 'United States Naval Academy', 'Maryland' UNION ALL

    -- Massachusetts
    SELECT 'Harvard University', 'Massachusetts' UNION ALL
    SELECT 'Massachusetts Institute of Technology', 'Massachusetts' UNION ALL
    SELECT 'Boston University', 'Massachusetts' UNION ALL

    -- Michigan
    SELECT 'University of Michigan', 'Michigan' UNION ALL
    SELECT 'Michigan State University', 'Michigan' UNION ALL
    SELECT 'Wayne State University', 'Michigan' UNION ALL

    -- Minnesota
    SELECT 'University of Minnesota', 'Minnesota' UNION ALL
    SELECT 'Carleton College', 'Minnesota' UNION ALL
    SELECT 'St. Olaf College', 'Minnesota' UNION ALL

    -- Mississippi
    SELECT 'University of Mississippi', 'Mississippi' UNION ALL
    SELECT 'Mississippi State University', 'Mississippi' UNION ALL
    SELECT 'Jackson State University', 'Mississippi' UNION ALL

    -- Missouri
    SELECT 'Washington University in St. Louis', 'Missouri' UNION ALL
    SELECT 'University of Missouri', 'Missouri' UNION ALL
    SELECT 'Saint Louis University', 'Missouri' UNION ALL

    -- Montana
    SELECT 'University of Montana', 'Montana' UNION ALL
    SELECT 'Montana State University', 'Montana' UNION ALL
    SELECT 'Carroll College', 'Montana' UNION ALL

    -- Nebraska
    SELECT 'University of Nebraska-Lincoln', 'Nebraska' UNION ALL
    SELECT 'Creighton University', 'Nebraska' UNION ALL
    SELECT 'Nebraska Wesleyan University', 'Nebraska' UNION ALL

    -- Nevada
    SELECT 'University of Nevada, Las Vegas', 'Nevada' UNION ALL
    SELECT 'University of Nevada, Reno', 'Nevada' UNION ALL
    SELECT 'Sierra Nevada University', 'Nevada' UNION ALL

    -- New Hampshire
    SELECT 'Dartmouth College', 'New Hampshire' UNION ALL
    SELECT 'University of New Hampshire', 'New Hampshire' UNION ALL
    SELECT 'Southern New Hampshire University', 'New Hampshire' UNION ALL

    -- New Jersey
    SELECT 'Princeton University', 'New Jersey' UNION ALL
    SELECT 'Rutgers University', 'New Jersey' UNION ALL
    SELECT 'Stevens Institute of Technology', 'New Jersey' UNION ALL

    -- New Mexico
    SELECT 'University of New Mexico', 'New Mexico' UNION ALL
    SELECT 'New Mexico State University', 'New Mexico' UNION ALL
    SELECT 'New Mexico Institute of Mining and Technology', 'New Mexico' UNION ALL

    -- New York
    SELECT 'Columbia University', 'New York' UNION ALL
    SELECT 'Cornell University', 'New York' UNION ALL
    SELECT 'New York University', 'New York' UNION ALL

    -- North Carolina
    SELECT 'Duke University', 'North Carolina' UNION ALL
    SELECT 'University of North Carolina at Chapel Hill', 'North Carolina' UNION ALL
    SELECT 'North Carolina State University', 'North Carolina' UNION ALL

    -- North Dakota
    SELECT 'University of North Dakota', 'North Dakota' UNION ALL
    SELECT 'North Dakota State University', 'North Dakota' UNION ALL
    SELECT 'Minot State University', 'North Dakota' UNION ALL

    -- Ohio
    SELECT 'Ohio State University', 'Ohio' UNION ALL
    SELECT 'Case Western Reserve University', 'Ohio' UNION ALL
    SELECT 'University of Cincinnati', 'Ohio' UNION ALL

    -- Oklahoma
    SELECT 'University of Oklahoma', 'Oklahoma' UNION ALL
    SELECT 'Oklahoma State University', 'Oklahoma' UNION ALL
    SELECT 'University of Tulsa', 'Oklahoma' UNION ALL

    -- Oregon
    SELECT 'University of Oregon', 'Oregon' UNION ALL
    SELECT 'Oregon State University', 'Oregon' UNION ALL
    SELECT 'Reed College', 'Oregon' UNION ALL

    -- Pennsylvania
    SELECT 'University of Pennsylvania', 'Pennsylvania' UNION ALL
    SELECT 'Carnegie Mellon University', 'Pennsylvania' UNION ALL
    SELECT 'Pennsylvania State University', 'Pennsylvania' UNION ALL

    -- Rhode Island
    SELECT 'Brown University', 'Rhode Island' UNION ALL
    SELECT 'University of Rhode Island', 'Rhode Island' UNION ALL
    SELECT 'Rhode Island School of Design', 'Rhode Island' UNION ALL

    -- South Carolina
    SELECT 'University of South Carolina', 'South Carolina' UNION ALL
    SELECT 'Clemson University', 'South Carolina' UNION ALL
    SELECT 'College of Charleston', 'South Carolina' UNION ALL

    -- South Dakota
    SELECT 'University of South Dakota', 'South Dakota' UNION ALL
    SELECT 'South Dakota State University', 'South Dakota' UNION ALL
    SELECT 'Augustana University', 'South Dakota' UNION ALL

    -- Tennessee
    SELECT 'Vanderbilt University', 'Tennessee' UNION ALL
    SELECT 'University of Tennessee', 'Tennessee' UNION ALL
    SELECT 'Rhodes College', 'Tennessee' UNION ALL

    -- Texas
    SELECT 'University of Texas at Austin', 'Texas' UNION ALL
    SELECT 'Rice University', 'Texas' UNION ALL
    SELECT 'Texas A&M University', 'Texas' UNION ALL

    -- Utah
    SELECT 'University of Utah', 'Utah' UNION ALL
    SELECT 'Brigham Young University', 'Utah' UNION ALL
    SELECT 'Utah State University', 'Utah' UNION ALL

    -- Vermont
    SELECT 'University of Vermont', 'Vermont' UNION ALL
    SELECT 'Middlebury College', 'Vermont' UNION ALL
    SELECT 'Bennington College', 'Vermont' UNION ALL

    -- Virginia
    SELECT 'University of Virginia', 'Virginia' UNION ALL
    SELECT 'College of William & Mary', 'Virginia' UNION ALL
    SELECT 'Virginia Tech', 'Virginia' UNION ALL

    -- Washington
    SELECT 'University of Washington', 'Washington' UNION ALL
    SELECT 'Washington State University', 'Washington' UNION ALL
    SELECT 'Seattle University', 'Washington' UNION ALL

    -- West Virginia
    SELECT 'West Virginia University', 'West Virginia' UNION ALL
    SELECT 'Marshall University', 'West Virginia' UNION ALL
    SELECT 'West Virginia Wesleyan College', 'West Virginia' UNION ALL

    -- Wisconsin
    SELECT 'University of Wisconsin-Madison', 'Wisconsin' UNION ALL
    SELECT 'Marquette University', 'Wisconsin' UNION ALL
    SELECT 'Lawrence University', 'Wisconsin' UNION ALL

    -- Wyoming
    SELECT 'University of Wyoming', 'Wyoming' UNION ALL
    SELECT 'Wyoming Catholic College', 'Wyoming' UNION ALL
    SELECT 'Casper College', 'Wyoming'
) AS data
JOIN Universities u ON data.uni = u.name
JOIN States s ON data.state = s.name;

