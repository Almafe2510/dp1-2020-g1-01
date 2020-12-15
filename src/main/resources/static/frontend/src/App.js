import React, { Component } from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { Solicitudes } from './components/Solicitudes'
import './index.css'
import Login from './components/Login'
import { EditStudent } from './components/EditStudent'
import { SolicitudesProfesor } from './components/SolicitudesProfesor'
import { AlumnosPorTutor } from './components/AlumnosPorTutor'
import { Alumnos } from './components/Alumnos'
import {Home} from './components/Home'
import { MenubarResponsive } from './components/MenubarResponsive'
import {getUserType} from './components/storage'
import {getUserName} from './components/storage'

class App extends Component {

	state = {
		urlBase: "http://localhost:8081",
		username: "",
		userType: ""
	}

	changeUserType(t){
		this.setState({userType: t})
	}

	calculateType(){
		if(this.state.userType===""){
			return getUserType()
		}else{
			return this.state.userType
		}
	}

	calculateUserName(){
		return getUserName()
	}
	

	render() {
		console.log(this.state.username)
		return (
			<div>
			<MenubarResponsive tipoDeUsuario={this.calculateType()}></MenubarResponsive>
				<Router>
					<Route path="/home" render={() =>
						<Home></Home>
					} />
					<Route path="/requests" render={() =>
						<Solicitudes urlBase={this.state.urlBase}></Solicitudes>
					} />
					<Route path="/login" render={() =>
						<Login urlBase={this.state.urlBase} onType={this.changeUserType.bind(this)}></Login>
					} />
					<Route path="/pendingRequests" render={() =>
						<SolicitudesProfesor urlBase={this.state.urlBase}></SolicitudesProfesor>
					} />
					<Route path="/myStudents" render={() =>
						<AlumnosPorTutor urlBase={this.state.urlBase} nickUser={this.calculateUserName()}></AlumnosPorTutor>
					} />
					<Route path="/allStudents" render={() =>
						<Alumnos urlBase={this.state.urlBase}></Alumnos>
					} />
					<Route path="/editStudent" render={() =>
						<EditStudent></EditStudent>
					} />
				</Router>
			</div>
		)
	}
}

export default App