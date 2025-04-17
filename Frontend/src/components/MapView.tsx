// components/MapView.tsx
import React, { useState } from 'react';
import { USAMap, USAStateAbbreviation } from '@mirawision/usa-map-react';
import { useNavigate } from 'react-router-dom';
import { Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import "../mapStyles.css";

const stateAbbreviationToName = {
  'AL': 'Alabama', 'AK': 'Alaska', 'AZ': 'Arizona', 'AR': 'Arkansas', 'CA': 'California',
  'CO': 'Colorado', 'CT': 'Connecticut', 'DE': 'Delaware', 'FL': 'Florida', 'GA': 'Georgia',
  'HI': 'Hawaii', 'ID': 'Idaho', 'IL': 'Illinois', 'IN': 'Indiana', 'IA': 'Iowa',
  'KS': 'Kansas', 'KY': 'Kentucky', 'LA': 'Louisiana', 'ME': 'Maine', 'MD': 'Maryland',
  'MA': 'Massachusetts', 'MI': 'Michigan', 'MN': 'Minnesota', 'MS': 'Mississippi', 'MO': 'Missouri',
  'MT': 'Montana', 'NE': 'Nebraska', 'NV': 'Nevada', 'NH': 'New Hampshire', 'NJ': 'New Jersey',
  'NM': 'New Mexico', 'NY': 'New York', 'NC': 'North Carolina', 'ND': 'North Dakota', 'OH': 'Ohio',
  'OK': 'Oklahoma', 'OR': 'Oregon', 'PA': 'Pennsylvania', 'RI': 'Rhode Island', 'SC': 'South Carolina',
  'SD': 'South Dakota', 'TN': 'Tennessee', 'TX': 'Texas', 'UT': 'Utah', 'VT': 'Vermont',
  'VA': 'Virginia', 'WA': 'Washington', 'WV': 'West Virginia', 'WI': 'Wisconsin', 'WY': 'Wyoming'
};

interface Student {
  studentId: number;
  name: string;
  major: string;
  graduationYear?: number;
  studentType: string;
}

interface University {
  universityId: number;
  universityName: string;
  students: Student[];
  studentCount: number;
}

interface StateData {
  stateId: number;
  stateName: string;
  universitiesWithStudents: University[];
  totalUniversities: number;
  totalStudents: number;
}

const MapView: React.FC = () => {
  const navigate = useNavigate();
  const [selectedState, setSelectedState] = useState<USAStateAbbreviation | null>(null);
  const [stateData, setStateData] = useState<StateData | null>(null);
  const [selectedUniversity, setSelectedUniversity] = useState<number | null>(null);
  const [selectedStudent, setSelectedStudent] = useState<Student | null>(null);

  const stateAbbreviations: USAStateAbbreviation[] = [
    'AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA',
    'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD',
    'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ',
    'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC',
    'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'
  ];

  const customStates = stateAbbreviations.reduce((states, state) => {
    return {
      ...states,
      [state]: {
        onClick: () => handleStateClick(state),
        fill: selectedState === state ? '#c0a0ff' : '#000000',
        stroke: '#ffffff'
      }
    };
  }, {});

  const handleStateClick = (stateAbbreviation: USAStateAbbreviation) => {
    setSelectedState(stateAbbreviation);
    setSelectedUniversity(null);
    setSelectedStudent(null);
    fetchStateData(stateAbbreviation);
  };

  const fetchStateData = async (stateAbbreviation: USAStateAbbreviation) => {
    const stateName = stateAbbreviationToName[stateAbbreviation];
    
    try {
      const response = await fetch(`http://localhost:8080/api/v4/states/getState/${stateName}`);
      
      if (!response.ok) {
        throw new Error(`Error fetching data for ${stateName}`);
      }
      
      const data = await response.json();
      console.log(data);
      setStateData(data);
    } catch (err) {
      console.error('Error fetching state data:', err);
    } 
    
  };

  const handleUniversityChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const value = e.target.value;
    setSelectedUniversity(value ? parseInt(value) : null);
    setSelectedStudent(null);
  };

  const handleStudentClick = (student: Student) => {
    setSelectedStudent(student);
  };

  const getStudentsForSelectedUniversity = () => {
    if (!selectedUniversity || !stateData) return [];
    
    const university = stateData.universitiesWithStudents.find(
      u => u.universityId === selectedUniversity
    );
    
    return university ? university.students : [];
  };

  const goToTableView = () => {
    navigate('/table');
  };

  return (
    <div className="d-flex flex-column vh-100" style={{ fontFamily: 'Arial, sans-serif' }}>
      {/* Add toggle button at the top */}
      <div className="d-flex justify-content-end p-2 border-bottom">
        <Button variant="primary" onClick={goToTableView}>Table View</Button>
      </div>
      
      <div className="d-flex flex-grow-1">
        <div className="flex-grow-1 map-container">
          <USAMap 
            customStates={customStates} 
            mapSettings={{
              width: 1200,
              height: 700,
              defaultFill: '#000000',
              defaultStroke: '#ffffff'
            }} 
          />
          
          {selectedStudent && (
            <div className="student-info">
              <h3 className="fw-bold fs-4 mb-2">{selectedStudent.name}</h3>
              <p className="mb-1">Major: {selectedStudent.major}</p>
              <p className="mb-0">Graduation Year: {selectedStudent.graduationYear || 2025}</p>
            </div>
          )}
        </div>
        
        <div style={{ width: '16rem', backgroundColor: '#e2e2e2' }}>
          <div className="state-header">
            {selectedState ? stateAbbreviationToName[selectedState] : 'Select a State'}
          </div>
          
          {selectedState && stateData && (
            <div className="p-3">
              <select 
                className="form-select mb-3"
                value={selectedUniversity || ''}
                onChange={handleUniversityChange}
              >
                <option value="">Select University ▼</option>
                {stateData.universitiesWithStudents.map(university => (
                  <option key={university.universityId} value={university.universityId}>
                    {university.universityName}
                  </option>
                ))}
              </select>
              
              {getStudentsForSelectedUniversity().map(student => (
                <div 
                  key={student.studentId}
                  className="student-card"
                  onClick={() => handleStudentClick(student)}
                >
                  {student.name}
                </div>
              ))}
              
              {selectedUniversity && getStudentsForSelectedUniversity().length === 0 && (
                <div className="text-center">No students at this university</div>
              )}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default MapView;
