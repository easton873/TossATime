import React, { Component } from 'react';

class timeSelection extends Component {

	constructor(props) {
		super(props);
		this.state = {
			time: this.props.time,
			dayOfWeek: this.props.dayOfWeek,
			isAvailable: false
	};

	this.handleInputChange = this.handleInputChange.bind(this);
	}

	handleInputChange(event) {
		const target = event.target;
		const value = target.type === 'checkbox' ? target.checked : target.value;
		const name = target.name;

		this.setState({
			[name]: value
		});


	}

	render() {

		const time = this.state.time

		return (

				<label>
					<p>{this.props.dayOfWeek}, {time}</p>
					<input 
					name='isAvailable' 
					type='checkbox'
					checked={this.isAvailable}
					onChange={this.handleInputChange}/>
				</label>

			);

	}

}

export default timeSelection