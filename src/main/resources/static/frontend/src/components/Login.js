import { Button } from 'primereact/button'
import { InputText } from 'primereact/inputtext'
import { withRouter } from "react-router-dom"
import '../login.css'
import { ExtraccionUsuarios } from './ExtraccionUsuarios'
import { Component } from 'react'
import {storageUserType} from './storage'
import {storageNickUsername} from './storage'

class Login extends Component {

    username = this.username.bind(this)
    password = this.password.bind(this)
    type = new ExtraccionUsuarios(this.props.urlBase)
    calculateType = this.calculateType.bind(this)

    state = {
        username: "",
        password: "",
        type: "",
        error: null
    }

    username(event) {
        this.setState({ username: event.target.value })
    }

    password(event) {
        this.setState({ password: event.target.value })
    }

    async calculateType(event) {
        event.preventDefault()
        await this.type.getType(this.state.username, this.state.password).then(data => this.setState({ type: data }))
        if (this.state.type === "Username not exist" || this.state.type === "Incorrect password") {
            this.setState({ error: <div className="alert alert-danger" role="alert">{this.state.type}</div> })
            this.props.history.push("/login")
        } else {
            storageUserType(this.state.type)
            this.props.onType(this.state.type)
            storageNickUsername(this.state.username)
            this.props.history.push("/")
        }
    }

    render() {
        return (
            <div>
                <div className="c">
                    <div className="login">
                        <form method="GET" onSubmit={this.calculateType}>
                            <div className="t"><div><h5>Login</h5></div></div>
                            {this.state.error}
                            <div className="i">
                                <div className="p-inputgroup">
                                    <span className="p-inputgroup-addon">
                                        <i className="pi pi-user"></i>
                                    </span>
                                    <InputText placeholder="Username" name="username" type="text" value={this.state.username} onChange={this.username} />
                                </div>
                            </div>

                            <div className="i">
                                <div className="p-inputgroup">
                                    <span className="p-inputgroup-addon">
                                        <i className="pi pi-lock"></i>
                                    </span>
                                    <InputText placeholder="Password" name="password" type="text" value={this.state.password} onChange={this.password} />
                                </div>
                            </div>
                            <div className="b">
                                <div className="i">
                                    <Button className="p-button-secondary" label="OK" icon="pi pi-fw pi-check" />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

export default withRouter(Login)