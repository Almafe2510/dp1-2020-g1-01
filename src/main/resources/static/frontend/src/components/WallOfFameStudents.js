import React, { Component } from 'react'
import AlumnoComponent from './AlumnoComponent';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { DataView } from "primereact/dataview";
import ReactDOM from "react-dom";
import "primeicons/primeicons.css";
import "primereact/resources/themes/saga-blue/theme.css";
import "primereact/resources/primereact.css";
import "primeflex/primeflex.css";   


export class WallOfFameStudents extends Component{
    fecha = this.fecha.bind(this);
    constructor(props){
        super(props)
        this.state={
            fecha:"",
            premiados:null
        }
        this.mostrarWallSeleccionado=this.mostrarWallSeleccionado.bind(this);
        this.premiados = new AlumnoComponent();
        this.itemTemplate = this.itemTemplate.bind(this);
    }

    renderGridItem(data) {
        return (
          <div className="p-col-12 p-md-4">
            <div className="product-grid-item card">
              <div className="product-grid-item-top"></div>
              <div className="product-grid-item-content">
                <img
                  src={data.foto}
                  onError={(e) =>
                    (e.target.src =
                      "https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png")
                  }
                  alt={data.name}
                />
                <div className="product-description">{data.descripcion}</div>
              </div>
            </div>
          </div>
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


    render(){
        console.log(this.state.premiados)
        return(
            <React.Fragment>
                <div className="i">
                    <div className="p-inputgroup">
                        <span className="p-inputgroup-addon">
                            <i className="pi pi-calendar"></i>
                        </span>
                        <InputText placeholder="Choose a date" name="fechaWall" type="date" value={this.state.fecha} onChange={this.fecha} />
                    </div>
                </div>
                <div className="b">
                    <div className="i">
                        <Button className="p-button-secondary" label="Search in this date" icon="pi pi-fw pi-check" onClick={()=>this.mostrarWallSeleccionado()}/>
                    </div>
                </div>
                <div className="dataview-demo">
                    <div className="card">
                        <DataView
                            value={this.state.premiados}
                            itemTemplate={this.itemTemplate}
                        />
                    </div>
                </div>
            </React.Fragment>
        );
    }
}
const rootElement = document.getElementById("root");
ReactDOM.render(<WallOfFameStudents />, rootElement);
