import React, { Component } from 'react'
import AlumnoComponent from './AlumnoComponent';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { DataView } from "primereact/dataview";
import "primeicons/primeicons.css";
import "primereact/resources/themes/saga-blue/theme.css";
import "primereact/resources/primereact.css";
import "primeflex/primeflex.css";
import "../css/wallOfFame.css";

export class WallOfFameStudents extends Component{
    fecha = this.fecha.bind(this);
    nickusuario= this.nickusuario.bind(this);
    description= this.description.bind(this);
    photo= this.photo.bind(this);
    
    constructor(props){
        super(props)
        this.state={
            fecha:"",
            premiados:null,
            nickusuario : "",
            description: "",
            photo: null,
            addForm:false
        }
        this.mostrarWallSeleccionado=this.mostrarWallSeleccionado.bind(this);
        this.premiados = new AlumnoComponent();
        this.itemTemplate = this.itemTemplate.bind(this);
        this.obtenerUltimoWall = this.obtenerUltimoWall.bind(this);
        this.BotonAñadirPremiado= this.BotonAñadirPremiado.bind(this);
        this.SeleccionarFechaWall= this.SeleccionarFechaWall.bind(this);
        this.MostrarWall= this.MostrarWall.bind(this);
       

    }

    componentDidMount(){
        this.obtenerUltimoWall();
    }
  
    async obtenerUltimoWall(){
        await this.premiados.getTheLastWeek(this.props.urlBase).then(data => this.setState({ fecha: data }))
        console.log("fecha:" + this.state.fecha)
        this.mostrarWallSeleccionado()
    }
    
    renderGridItem(data) {
        return (
        <React.Fragment>
            <div className="premiado">
              <div>
                <img 
                    src={"/photosWall/"+data.foto}
                    onError={(e) =>
                    (e.target.src =
                        "https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png")
                    }
                    alt={data.name}/>
                
                <div className="modificaTexto">{data.alumnos.nombreCompletoUsuario}</div>
                <div className="modificaTexto">{data.descripcion}</div>
                </div>
            </div>
        </React.Fragment>
        );    
    }

    itemTemplate(premiados) {
        if (!premiados) {
          return;
        }
        return this.renderGridItem(premiados);
    }


    mostrarWallSeleccionado(){
        console.log(this.state.fecha)
        this.premiados.getWallOfFameForStudents(this.props.urlBase, this.state.fecha).then(data => this.setState({ premiados: data }))
        //console.log(this.state.premiados);
    }

    fecha(event){
        console.log("Hola soy fecha(event) :)")
        this.setState({fecha:event.target.value})      
    }

    nickusuario(event){
        this.setState({nickusuario : event.target.value})
    }

    description(event){
        this.setState({description : event.target.value})
    }

    photo(event){
        this.setState({photo : event.target.files[0]})
    }

    async handleSubmit(){
        const formData = new FormData();
        formData.append('photo', this.state.photo) ;
        formData.append('nickUsuario', this.state.nickusuario) ;
        formData.append('description', this.state.description) ;
        await this.premiados.postNewPremiado(this.props.urlBase, this.state.fecha, formData).then(() => this.setState({ addForm: false }));
    }
    
    SeleccionarFechaWall(){
        if(!this.state.addForm){
            return(
                <div className="p-inputgroup">
                    <InputText className="mr-2" placeholder="Choose a date" name="fechaWall" type="week" value={this.state.fecha} onChange={this.fecha} />
                    <Button className="p-button-secondary" label="Search in this date" icon="pi pi-search" onClick={()=>this.mostrarWallSeleccionado()}/>
                </div>
            );
        }
    }
    
    BotonAñadirPremiado(){
        if(this.props.userType==="profesor" && !this.state.addForm){
            return(
                <div className="mt-3">  
                    <Button className="p-button-secondary" label="Add a new awarded student" icon="pi pi-plus" onClick={()=>this.setState({addForm: true})}/>
                </div>
            );
        }

    }

    MostrarWall(){
        if(!this.state.addForm){
            return(
                <div className="mt-3">
                <div className="card">
                    <DataView
                        value={this.state.premiados}
                        itemTemplate={this.itemTemplate}
                    />
                </div>
            </div>
            );
        }

    }

    mostrarFormulario(){
        if(this.state.addForm){
            return( 
                <div className="c">
                    <div className="login request">
                       
                        <div className="t">
                            <div><h5>Add a new awarded student</h5></div>
                        </div>
                        <div className="i">
                            <div className="p-inputgroup">
                            <span className="p-inputgroup-addon">
                                <i className="pi pi-user"></i>
                            </span>
                                <InputText type= "text" placeholder="Username" name="nickusuario" onChange={this.nickusuario} />
                            </div>
                        </div>

                        <div className="i">
                            <div className="p-inputgroup">
                            <span className="p-inputgroup-addon">
                                <i className="pi pi-align-center"></i>  
                            </span>
                                <InputText type= "textarea" placeholder="description" name="description" onChange={this.description} />
                            </div>
                        </div>

                        <div className="i">
                            <div className="p-inputgroup">
                                <InputText type= "file" name="photo" onChange={this.photo}/>
                            </div>
                        </div>

                        <div className="b">
                            <div className="i">
                                <Button className="p-button-secondary" label="Add the student" icon="pi pi-fw pi-upload" onClick={() => this.handleSubmit()}/>
                            </div>
                        </div>
                        
                    </div>
                </div>
                );
            }
    }

    render(){
        return(
            <React.Fragment>
                {this.SeleccionarFechaWall()}                
                {this.BotonAñadirPremiado()} 
                {this.MostrarWall()}
                {this.mostrarFormulario()}               
            </React.Fragment>
        );
    }
}