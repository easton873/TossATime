import React, { Component } from 'react';
import TimeOfDay from './timeOfDay';

class AllTimes extends Component {
    constructor(props){
        super(props);
        this.state = { 
            dayOfWeek: [0,1,2,3,4,5,6],
            description: 'description is good',
            weekday: ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"],
            value: ''
        } 
    }

    handleSubmit = () => {

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


    render() { 

        const {weekday} = this.state.weekday

        return (

            <form className='form'>
                <div className='container'>
                    <div className='description'>
                        <label className='m-2'>Creator</label>
                        <input type='text' value='Jimmy' />
                        <label className='m-2'>Event Name</label>
                        <input type='text' value='This is a cool event' />
                        <label className='m-2'>Description</label>
                        <input type="text" value={this.state.description} />
                <button className='btn btn-dark m-3' onClick={this.handleSubmit}>Submit</button>
                    </div>
                    
                        {this.state.dayOfWeek.map((value, index) => {
                        return <div className='dayofweek'>
                            <TimeOfDay dayOfWeek={value} key={index} /> 
                        </div>
                        })}

                </div>
            </form>
        );
    }
}
 
export default AllTimes;