import React, { Component } from 'react';

class timeSelection extends Component {

	constructor(props) {
		super(props);
		this.state = {
			time: this.props.time,
			dayOfWeek: this.props.dayOfWeek,
			isAvailable: false,
			value: ''+this.props.dayOfWeek+this.props.time
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

		return (

				<label>
					<p>{this.state.dayOfWeek}, {this.state.time}</p>
					<input
					name='isAvailable' 
					type='checkbox'
					checked={this.isAvailable}
					value={this.state.value}
					onChange={this.handleInputChange}/>
				</label>

			);

	}

}

export default timeSelection