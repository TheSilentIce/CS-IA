import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navigation from './components/Navigation';
import StatisticsDashboard from './components/StatisticsDashboard';
import StateUniversityMap from './components/MapView';
import './App.css';
import StudentSearch from './components/StudentSearch';

const App: React.FC = () => {
  return (
    <div className="app">
      <BrowserRouter>
        <Navigation />
        <main>
          <Routes>
            <Route path="/" element={<StatisticsDashboard />} />
            <Route path="/map" element={<StateUniversityMap />} />
            <Route path="/table" element={<StudentSearch />} />

          </Routes>
        </main>
      </BrowserRouter>
    </div>
  );
};

export default App;
