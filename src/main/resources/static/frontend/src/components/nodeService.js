import axios from 'axios';
import AuthenticationService from '../service/AuthenticationService';

export default class nodeService {
    getTreeNodes() {
        return axios.get('http://localhost:8081/course/all', { headers: { authorization: AuthenticationService.createBasicAuthToken(sessionStorage.getItem("authenticatedUser"), 
		sessionStorage.getItem("password")) } }).then(res => res.data);
    }
}