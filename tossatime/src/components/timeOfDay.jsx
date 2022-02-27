import React, { Component } from 'react';
import TimeSelection from './timeSelection';

class timeOfDay extends Component {

    constructor(props) {
        super(props)
        this.state = { 
            times: [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24]
        } 
    }
    render() { 
        return (
            <div>
                <div className='description'>
                    {this.state.descrition}
                </div>
                    {this.state.times.map((value, index) => {
                    return (<div className='timeofday' time={value}> 
                        <TimeSelection dayOfWeek={this.props.dayOfWeek} time={value} key={index} /> 
                    </div>)
                    })}
                
            </div>
        );
    }
}
 
export default timeOfDay;