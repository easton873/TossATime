import React, { Component } from 'react';
import './App.css';
import AllTimes from './components/allTimes';
import NavBar from './components/navbar';

class App extends Component {

    render() { 

        return (
            <React.Fragment>
                <NavBar />
                <h1>Its working</h1>
                <AllTimes />
            </React.Fragment>
        );
    };
};

export default App;
