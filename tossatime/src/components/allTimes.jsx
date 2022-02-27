import React, { Component } from 'react';
import TimeOfDay from './timeOfDay';

class AllTimes extends Component {
    constructor(props){
        super(props);
        this.state = { 
            dayOfWeek: [0,1,2,3,4,5,6],
            description: 'This is a description of the event',
            weekday: ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"],
            value: ''
        } 
    }

    handleSubmit = () => {

        const value = JSON.parse(Object.entries(localStorage))

        alert(value)

    }


    render() { 

        const {weekday} = this.state.weekday

        return (

            <form className='form'>
                <div className='container'>
                    <div className='description'>
                        {this.state.description}
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