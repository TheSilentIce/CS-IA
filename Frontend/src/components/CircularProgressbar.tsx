import React, { useEffect, useState, useMemo } from 'react';
import '../CircularProgressbar.css';

interface CircularProgressbarProps {
  percentage: number;
  title: string;
  text?: string; // Optional custom text to display in the center
}

const CircularProgressbar: React.FC<CircularProgressbarProps> = ({ 
  percentage, 
  title,
  text
}) => {
  // State to animate the progress
  const [progress, setProgress] = useState(0);
  
  // Generate a random color on component mount
  const randomColor = useMemo(() => {
    // Predefined vibrant colors for better aesthetics
    const colors = [
      '#4285F4', // Google Blue
      '#EA4335', // Google Red
      '#FBBC05', // Google Yellow
      '#34A853', // Google Green
      '#8E44AD', // Purple
      '#16A085', // Turquoise
      '#F39C12', // Orange
      '#3498DB', // Light Blue
      '#E74C3C', // Bright Red
      '#2ECC71', // Emerald
      '#9B59B6', // Amethyst
      '#1ABC9C', // Turquoise
      '#F1C40F', // Sun Yellow
      '#E67E22', // Carrot Orange
      '#27AE60'  // Nephritis Green
    ];
    return colors[Math.floor(Math.random() * colors.length)];
  }, []);
  
  // Ensure percentage is between 0 and 100 and not NaN
  const normalizedPercentage = isNaN(percentage) ? 0 : Math.min(100, Math.max(0, percentage));
  
  // Animate the progress on mount or when percentage changes
  useEffect(() => {
    // Reset progress to 0 before animating to the new value
    setProgress(0);
    
    // Use timeout to ensure animation works
    const timeout = setTimeout(() => {
      setProgress(normalizedPercentage);
    }, 100);
    
    return () => clearTimeout(timeout);
  }, [normalizedPercentage]);
  
  // Calculate stroke-dasharray and stroke-dashoffset for the circle
  const radius = 40;
  const circumference = 2 * Math.PI * radius;
  const strokeDashoffset = circumference - (progress / 100) * circumference;
  
  // Format the percentage text
  const displayText = text || `${Math.round(progress)}%`;
  
  return (
    <div className="circular-progressbar">
      <svg className="progress-ring" width="130" height="130" viewBox="0 0 120 120">
        {/* Background circle */}
        <circle
          className="progress-ring-circle-bg"
          cx="60"
          cy="60"
          r={radius}
        />
        
        {/* Progress circle */}
        <circle
          className="progress-ring-circle"
          cx="60"
          cy="60"
          r={radius}
          strokeDasharray={circumference}
          strokeDashoffset={strokeDashoffset}
          transform="rotate(-90, 60, 60)"
          style={{ stroke: randomColor }}
        />
        
        {/* Percentage text */}
        <text
          x="50%"
          y="50%"
          dy=".3em"
          textAnchor="middle"
          className="progress-text"
        >
          {displayText}
        </text>
      </svg>
      
      <h3 className="stat-title">{title}</h3>
    </div>
  );
};

export default CircularProgressbar;
