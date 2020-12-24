import React, { Component } from 'react'
import { Button } from 'primereact/button';
import GrupoComponent from './GrupoComponent';
import { Dropdown } from 'primereact/dropdown';
import axios from 'axios';



export class DeleteGroup extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            grupoS:{
                nombreGrupo: ""
            },
            listaGrupos:{
                nombreGrupo: ""
            }

        }
        this.grupos = new GrupoComponent();
        this.delete = this.delete.bind(this);
        this.handleNG = this.handleNG.bind(this);
        this.allGroupNames= this.allGroupNames.bind(this);
    }
    delete = event => {
        event.preventDefault();

        axios.delete("http://localhost:8081/grupos/delete/"+this.state.grupoS.nombreGrupo).then(res => {
            this.respuesta(res.status, res.data);
        })
        
        
       
    }


    handleNG(event) {
        this.setState({grupoS:{            
           nombreGrupo:event.target.value
        }});
    }

    allGroupNames(){

        var t=this.state.listaGrupos
        var i=0
        var groupSelectItems = [];
        while(i<t.length){        
        groupSelectItems.push(         
            { label: String(t[i]) , value: String(t[i]) })        
        i+=1
        }
        return groupSelectItems
    }
    respuesta(status, data){
        console.log("hola?");

        console.log(status);
        if(status===111){
            console.log("no va");

            data.forEach(e => this.error(e.field, e.defaultMessage))
        }else if(status===200){
            console.log("va");

            this.setState({               

                grupoS:{
                    nombreGrupo:""
                },
                succes: <div className="alert alert-success" role="alert">Successful delete</div>
            })
        }else{
            this.setState({exist: <div className="alert alert-danger" role="alert">{data}</div>})
        }
    }

    componentDidMount() {
        this.grupos.getEmptyGroupNames().then(data => this.setState({ listaGrupos: data }));
    }

    render() {
        return (

            <div>
                <div className="c">
                    <div className="login request">
                        <form onSubmit={this.delete}>
                        {this.state.succes}
                        {this.state.exist}
                            <div className="t"><div><h5>Delete Group</h5></div></div>

                                <div className="i">
                                <div className="p-inputgroup">
                                <Dropdown name="nombreGrupo" placeholder="Select group" value={this.state.grupoS.nombreGrupo} options={this.allGroupNames()} onChange={this.handleNG} />

                                </div>
                                </div>
                                
                                <div className="b">
                                <div className="i">
                                <Button className="p-button-secondary" label="Eliminar" icon="pi pi-fw pi-check"/>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default (DeleteGroup);