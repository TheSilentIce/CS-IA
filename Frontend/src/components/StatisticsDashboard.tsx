import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Container, Row, Col, Card, Form } from 'react-bootstrap';
import CircularProgressbar from './CircularProgressbar';
import '../StatisticsDashboard.css';
import AnimatedBackground from './AnimatedBackground';

// Define interfaces for our data types
interface GeneralStatistics {
  hadLeadership: number;
  hadVolunteering: number;
  hadSports: number;
  hadCompetition: number;
  hadJob: number;
  isInHonorsSociety: number;
  hadDoomScrolled: number;
  averageGpa: number;
}

interface BusinessStatistics {
  hadBusiness: number;
  inBusinessClub: number;
}

interface EngineeringStatistics {
  inFbla: number;
  didPersonalProject: number;
}

interface MedicalStatistics {
  inHosa: number;
  didResearch: number;
}

interface StatisticsResponse {
  generalStatistics: GeneralStatistics;
  typeSpecificStatistics: BusinessStatistics | EngineeringStatistics | MedicalStatistics | {};
  studentType: string;
}

const StatisticsDashboard: React.FC = () => {
  // State for selected student type
  const [selectedType, setSelectedType] = useState<string>('BUSINESS');
  
  // State for statistics data
  const [statistics, setStatistics] = useState<StatisticsResponse | null>(null);
  
  // State to track loading state
  const [loading, setLoading] = useState<boolean>(true);
  
  // Fetch statistics when selected type changes
  useEffect(() => {
    const fetchStatistics = async () => {
      setLoading(true);
      try {
        const response = await axios.get<StatisticsResponse>(
          `http://localhost:8080/api/statistics/getStatistics`, {
            params: { studentType: selectedType }
          }
        );
        console.log("Statistics data received:", response.data);
        setStatistics(response.data);
      } catch (error) {
        console.error('Error fetching statistics:', error);
      } finally {
        setLoading(false);
      }
    };
    
    fetchStatistics();
  }, [selectedType]);
  
  // Handle type selection change
  const handleTypeChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSelectedType(event.target.value);
  };
  
  // Map student types to their display names
  const studentTypes = [
    { value: 'ALL', label: 'All' },
    { value: 'BUSINESS', label: 'Business' },
    { value: 'MEDICAL', label: 'Medicine' },
    { value: 'ENGINEERING', label: 'Engineering' },
    { value: 'OTHER', label: 'Other' }
  ];
  
  // Return loading state if data is not yet available
  if (loading || !statistics) {
    return (
      <div className="statistics-container d-flex justify-content-center align-items-center">
        <div className="text-center p-5">
          <h2>Loading statistics...</h2>
        </div>
      </div>
    );
  }
  
  // Helper function to ensure we get a valid percentage (defaults to 0 if undefined/null)
  const getValidPercentage = (value: any): number => {
    if (value === undefined || value === null || isNaN(value)) {
      return 0;
    }
    return Number(value);
  };
  
  // Helper function to get the display name for student type
  const getStudentTypeDisplayName = (type: string): string => {
    const found = studentTypes.find(st => st.value === type);
    return found ? found.label : type;
  };
  
  // Determine which statistics to display based on selected type
  let statisticsToDisplay = [];
  
  // Always show average GPA
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="gpa">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.averageGpa) * 25} // Scale from 0-4 to 0-100
            title="Average GPA"
            text={getValidPercentage(statistics.generalStatistics.averageGpa).toFixed(2)}
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  // For ALL students and specific student types, display common attributes
  // Always show general statistics for the selected student type
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="honors">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.isInHonorsSociety)}
            title="Honors/IB Students"
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="leadership">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.hadLeadership)}
            title="Leadership Experience"
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="volunteering">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.hadVolunteering)}
            title="Volunteering Experience"
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="sports">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.hadSports)}
            title="Sports Participation"
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="competition">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.hadCompetition)}
            title="Competition Experience"
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="job">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.hadJob)}
            title="Work Experience"
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  statisticsToDisplay.push(
    <Col md={4} className="mb-4" key="doomScroll">
      <Card className="stats-card general-stat">
        <Card.Body>
          <CircularProgressbar 
            percentage={getValidPercentage(statistics.generalStatistics.hadDoomScrolled)}
            title="Social Media Usage"
          />
        </Card.Body>
      </Card>
    </Col>
  );
  
  // Add a section divider for type-specific stats if needed
  if (selectedType !== 'ALL' && 
      ((selectedType === 'BUSINESS' && 'hadBusiness' in statistics.typeSpecificStatistics) ||
       (selectedType === 'ENGINEERING' && 'inFbla' in statistics.typeSpecificStatistics) ||
       (selectedType === 'MEDICAL' && 'inHosa' in statistics.typeSpecificStatistics))) {
    
    // Add a full-width divider
    statisticsToDisplay.push(
      <Col xs={12} className="mb-4 mt-2" key="divider">
        <div className="stats-divider">
          <span>{getStudentTypeDisplayName(selectedType)} Specific Metrics</span>
        </div>
      </Col>
    );
  }
  
  // If it's a specific student type, also add type-specific statistics
  if (selectedType === 'BUSINESS' && 'hadBusiness' in statistics.typeSpecificStatistics) {
    const businessStats = statistics.typeSpecificStatistics as BusinessStatistics;
    statisticsToDisplay.push(
      <Col md={4} className="mb-4" key="business">
        <Card className="stats-card">
          <Card.Header className="bg-primary text-white">Business Track</Card.Header>
          <Card.Body className="text-center">
            <CircularProgressbar 
              percentage={getValidPercentage(businessStats.hadBusiness)}
              title="Entrepreneurship"
            />
          </Card.Body>
        </Card>
      </Col>
    );
    
    statisticsToDisplay.push(
      <Col md={4} className="mb-4" key="businessClub">
        <Card className="stats-card">
          <Card.Header className="bg-primary text-white">Business Track</Card.Header>
          <Card.Body className="text-center">
            <CircularProgressbar 
              percentage={getValidPercentage(businessStats.inBusinessClub)}
              title="Business Club Membership"
            />
          </Card.Body>
        </Card>
      </Col>
    );
  }
  else if (selectedType === 'ENGINEERING' && 'inFbla' in statistics.typeSpecificStatistics) {
    const engineeringStats = statistics.typeSpecificStatistics as EngineeringStatistics;
    statisticsToDisplay.push(
      <Col md={4} className="mb-4" key="fbla">
        <Card className="stats-card">
          <Card.Header className="bg-warning text-dark">Engineering Track</Card.Header>
          <Card.Body className="text-center">
            <CircularProgressbar 
              percentage={getValidPercentage(engineeringStats.inFbla)}
              title="FBLA Participation"
            />
          </Card.Body>
        </Card>
      </Col>
    );
    
    statisticsToDisplay.push(
      <Col md={4} className="mb-4" key="personalProject">
        <Card className="stats-card">
          <Card.Header className="bg-warning text-dark">Engineering Track</Card.Header>
          <Card.Body className="text-center">
            <CircularProgressbar 
              percentage={getValidPercentage(engineeringStats.didPersonalProject)}
              title="Personal Projects"
            />
          </Card.Body>
        </Card>
      </Col>
    );
  }
  else if (selectedType === 'MEDICAL' && 'inHosa' in statistics.typeSpecificStatistics) {
    const medicalStats = statistics.typeSpecificStatistics as MedicalStatistics;
    statisticsToDisplay.push(
      <Col md={4} className="mb-4" key="hosa">
        <Card className="stats-card">
          <Card.Header className="bg-danger text-white">Medical Track</Card.Header>
          <Card.Body className="text-center">
            <CircularProgressbar 
              percentage={getValidPercentage(medicalStats.inHosa)}
              title="HOSA Membership"
            />
          </Card.Body>
        </Card>
      </Col>
    );
    
    statisticsToDisplay.push(
      <Col md={4} className="mb-4" key="research">
        <Card className="stats-card">
          <Card.Header className="bg-danger text-white">Medical Track</Card.Header>
          <Card.Body className="text-center">
            <CircularProgressbar 
              percentage={getValidPercentage(medicalStats.didResearch)}
              title="Research Participation"
            />
          </Card.Body>
        </Card>
      </Col>
    );
  }

  return (
    <div className="statistics-container">
      <AnimatedBackground />
      <div className="content-row">
        <Container>
          <Row>
            <Col md={9}>
              <h2 className="stats-title">
                {selectedType === 'ALL' 
                  ? 'All Students Statistics' 
                  : `${getStudentTypeDisplayName(selectedType)} Students Statistics`}
              </h2>
              
              <Row>
                {/* Render all statistics */}
                {statisticsToDisplay}
              </Row>
            </Col>
            
            <Col md={3}>
              <Card className="filter-card">
                <Card.Header>
                  <h3>Student Types</h3>
                </Card.Header>
                <Card.Body>
                  <Form>
                    {studentTypes.map((type) => (
                      <Form.Check
                        key={type.value}
                        type="radio"
                        id={`student-type-${type.value}`}
                        label={type.label}
                        value={type.value}
                        checked={selectedType === type.value}
                        onChange={handleTypeChange}
                        className="mb-2"
                      />
                    ))}
                  </Form>
                </Card.Body>
              </Card>
            </Col>
          </Row>
        </Container>
      </div>
    </div>
  );
};

export default StatisticsDashboard;
