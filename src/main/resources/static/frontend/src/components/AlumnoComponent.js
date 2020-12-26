import axios from 'axios';
import {Component} from 'react';

export default class AlumnoComponent extends Component{
		
	getAllStudents(baseUrl){
		return axios.get(baseUrl + "/alumnos/all").then(res => res.data);
	}

	getStudentsByCourse(baseUrl, course){
		return axios.get(baseUrl + "/alumnos/getByCourse/"+course).then(res => res.data);
	}
        
	getStudentsByNameOfGroup(baseUrl, group){
		return axios.get(baseUrl + "/alumnos/"+group).then(res => res.data);
	}

	getWallOfFameForStudents(baseUrl, fecha){
		return axios.get(baseUrl+"/premiados/"+fecha).then(res=>res.data);
	}

	getTheLastWeek(baseUrl){
		return axios.get(baseUrl+"/premiados/ultimaSemana").then(res=>res.data);
	}

	assign(persona) {
        return axios.put("http://localhost:8081/alumnos/assignStudent", persona).then(res => res.data);
    }

	postNewPremiado(baseUrl, fecha ,formData){
        return axios.post(baseUrl+"/premiados/añadirPremiado/"+fecha ,formData,{withCredentials: true});
	}
	
	editPremiado(baseUrl, formData){
		return axios.put(baseUrl+"/premiados/editarPremiado", formData,{withCredentials: true});
	}
	
}

