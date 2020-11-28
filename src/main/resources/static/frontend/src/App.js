import React, { Component } from 'react';
import { MenubarResponsive } from './components/MenubarResponsive';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { Solicitudes } from './components/Solicitudes';
import './index.css';
import Login from './components/Login';
import ExtraccionMensajes from './components/ExtraccionMensajes';
import { EditStudent } from './components/EditStudent';
import { SolicitudesProfesor } from './components/SolicitudesProfesor';
import { AlumnosPorTutor } from './components/AlumnosPorTutor';
import { Alumnos } from './components/Alumnos';


class App extends Component {

	extraccion = new ExtraccionMensajes();
	constructor(){
		super()
		this.state = {
			urlBase: "http://localhost:8081",
			tipoDeUsuario:"integrante",
			nickUsuario: this.extraccion.getParameterByName("nickUsuario")
		}
	}
	
	componentDidMount(){
		var m = this.extraccion.getParameterByName("message");
		if(m!==""){
			this.setState({tipoDeUsuario:m});
		}
	}

	render() {
		
		console.log( this.state.nickUsuario)
		return (
			<React.Fragment>
				<MenubarResponsive tipoDeUsuario={this.state.tipoDeUsuario}></MenubarResponsive>
				<Router>
					<Route path="/requests" render={() =>
						<Solicitudes tipoDeUsuario={this.state.tipoDeUsuario} urlBase={this.state.urlBase}></Solicitudes>
					} />
					<Route path="/login" render={() =>
						<Login urlBase={this.state.urlBase}></Login>
					} />
					<Route path="/pendingRequests" render= {() =>
						<SolicitudesProfesor urlBase={this.state.urlBase}></SolicitudesProfesor>
					} />
					<Route path="/myStudents" render={()=>
						<AlumnosPorTutor urlBase={this.state.urlBase}></AlumnosPorTutor>
					} />
					<Route path="/allStudents" render={()=>
						<Alumnos urlBase={this.state.urlBase}></Alumnos>
					} />
					<Route path = "/editStudent" render={() =>
						<EditStudent></EditStudent>
					} />
					
				</Router>
			</React.Fragment>
		)
	}
}

export default App;