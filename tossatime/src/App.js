import React, { Component } from 'react';
import './App.css';
import AllTimes from './components/allTimes';
import NavBar from './components/navbar';

class App extends Component {

    render() { 

        this.getData();

        return (
            <React.Fragment>
                <NavBar />
                <h1>Its working</h1>
                <AllTimes />
            </React.Fragment>
        );

        
    };

    getData() {
        // create a new XMLHttpRequest
        var xhr = new XMLHttpRequest();
        // get a callback when the server responds
        xhr.addEventListener('load', () => {
          // update the state of the component with the result here
          console.log(xhr.responseText)
        })

        xhr.open('POST', 'http://44.202.141.234:80/createEvent');
        let req = {
            creator: "Jimmy",
            description: "description is good",
            name: "This is a cool event",
            times: [
                {
                    year: "2022",
                    month: "2",
                    day: "26",
                    hour: "6"
                },
                {
                    year: "2022",
                    month: "2",
                    day: "26",
                    hour: "7"
                }
            ]
        }
        
        // xhr.open('POST', 'http://localhost:8080/voteEvent');
        // let req = {
        //     eventID: "982e375d-1ab9-4bbf-b6d9-9d1d3864eba4",
        //     name: "This is a cool event",
        //     times: [
        //         {
        //             year: "2022",
        //             month: "2",
        //             day: "26",
        //             hour: "6"
        //         },
        //         {
        //             year: "2022",
        //             month: "2",
        //             day: "26",
        //             hour: "7"
        //         }
        //     ]
        // }
        
        // xhr.open('POST', 'http://localhost:8080/getEvent');
        // let req = {
        //     eventID: "982e375d-1ab9-4bbf-b6d9-9d1d3864eba4"
        // }

        xhr.send(JSON.stringify(req));
      }

};

export default App;
