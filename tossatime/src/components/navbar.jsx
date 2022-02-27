import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import createEvent from './createEvent';

// stateless functional component
class NavBar extends Component {

    render() {
    return (
        <nav className="navbar navbar-dark bg-light">
            <ul>
                <li className="navbar-brand" href="#">
                    <a href="#">
                        Create Event
                    </a>
                </li>
            </ul>
        </nav>
    );
    }
};
 
export default NavBar;