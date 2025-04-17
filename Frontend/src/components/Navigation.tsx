import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
import { Link, useLocation } from 'react-router-dom';

const Navigation: React.FC = () => {
  const location = useLocation();
  
  return (
    <Navbar bg="primary" variant="dark" expand="lg" className="navigation-bar" style={{backgroundColor: '#4299e1 !important'}}>
      <Container>
        <Navbar.Brand as={Link} to="/">Hillcrest High School</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <Nav.Link 
              as={Link} 
              to="/" 
              active={location.pathname === '/'}
            >
              Statistics Dashboard
            </Nav.Link>
            <Nav.Link 
              as={Link} 
              to="/map" 
              active={location.pathname === '/map'}
            >
              University Map
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Navigation;
