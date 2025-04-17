import React, { useState, useEffect } from 'react';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './StudentSearch.css';
import axios from 'axios';

interface Student {
  id: number;
  studentName: string;
  universityName: string;
  major: string;
}

// Sample data for initial start 
const sampleData: Student[] = [];

const StudentSearch: React.FC = () => {
  const navigate = useNavigate();
  const [students, setStudents] = useState<Student[]>(sampleData);
  const [nameFilter, setNameFilter] = useState('');
  const [universityFilter, setUniversityFilter] = useState('');
  const [majorFilter, setMajorFilter] = useState('');
  const [loading, setLoading] = useState(false);

  // Function to handle search button click
  const handleSearch = async () => {
    setLoading(true);
    try {
      // In a real application, you would call your API here
      // For now, we'll simulate searching through our sample data
      const filteredStudents = sampleData.filter(student => {
        const nameMatch = !nameFilter || student.studentName.toLowerCase().includes(nameFilter.toLowerCase());
        const universityMatch = !universityFilter || student.universityName.toLowerCase().includes(universityFilter.toLowerCase());
        const majorMatch = !majorFilter || student.major.toLowerCase().includes(majorFilter.toLowerCase());
        return nameMatch && universityMatch && majorMatch;
      });
      
      // Simulate API delay
      setTimeout(() => {
        setStudents(filteredStudents);
        setLoading(false);
      }, 0);
      
      // Uncomment this to use a real API
      const response = await axios.get('http://localhost:8080/api/simple-students/search', {
        params: {
          name: nameFilter || undefined,
          university: universityFilter || undefined,
          major: majorFilter || undefined
        }
      });
      setStudents(response.data);

    } catch (error) {
      console.error('Error fetching students:', error);
      setLoading(false);
    }
  };

  const goToMap = () => {
    navigate("/map");
  };

  return (
    <div className="container-fluid p-0">
      {/* Header with Logo */}

      <div className="d-flex justify-content-end p-2 border-bottom">
        <Button variant="primary" onClick={goToMap}>Map View</Button>
      </div>
      <div className="row g-0">
        {/* Main content area */}
        <div className="col-md-9">
          {/* Table header */}
          <div className="row g-0">
            <div className="col-md-4 p-3 table-header border">
              <strong>Name</strong>
            </div>
            <div className="col-md-4 p-3 table-header border">
              <strong>University</strong>
            </div>
            <div className="col-md-4 p-3 table-header border">
              <strong>Major</strong>
            </div>
          </div>

          {/* Table content */}
          {loading ? (
            <div className="text-center p-5">
              <div className="spinner-border" role="status">
                <span className="visually-hidden">Loading...</span>
              </div>
            </div>
          ) : (
            <>
              {students.length > 0 ? (
                students.map((student, index) => (
                  <div 
                    key={student.id} 
                    className={`row g-0 ${index % 2 === 0 ? 'table-row-even' : 'table-row-odd'}`}
                  >
                    <div className="col-md-4 p-3 border">{student.studentName}</div>
                    <div className="col-md-4 p-3 border">{student.universityName}</div>
                    <div className="col-md-4 p-3 border">{student.major}</div>
                  </div>
                ))
              ) : (
                <div className="text-center p-5">No students found matching your search criteria</div>
              )}
            </>
          )}
        </div>

        {/* Sidebar with search controls */}
        <div className="col-md-3 search-sidebar p-4">
          <div className="mb-4">
            <label htmlFor="studentInput" className="form-label fw-bold">Students</label>
            <input
              type="text"
              className="form-control"
              id="studentInput"
              value={nameFilter}
              onChange={(e) => setNameFilter(e.target.value)}
              placeholder="Enter student name"
            />
          </div>

          <div className="mb-4">
            <label htmlFor="universityInput" className="form-label fw-bold">University</label>
            <input
              type="text"
              className="form-control"
              id="universityInput"
              value={universityFilter}
              onChange={(e) => setUniversityFilter(e.target.value)}
              placeholder="Enter university name"
            />
          </div>

          <div className="mb-4">
            <label htmlFor="majorInput" className="form-label fw-bold">Major</label>
            <input
              type="text"
              className="form-control"
              id="majorInput"
              value={majorFilter}
              onChange={(e) => setMajorFilter(e.target.value)}
              placeholder="Enter major"
            />
          </div>

          <button 
            className="btn search-button w-100"
            onClick={handleSearch}
            disabled={loading}
          >
            {loading ? 'Searching...' : 'Search'}
          </button>
        </div>
      </div>

      {/* Map button */}
      <div className="position-absolute bottom-0 start-0 m-3">
        <button className="btn map-button">Map</button>
      </div>
    </div>
  );
};

export default StudentSearch;
