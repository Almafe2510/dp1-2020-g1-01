import React, { Component } from 'react'
import AlumnoComponent from './AlumnoComponent';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { ListBox } from 'primereact/listbox';
import { Button } from 'primereact/button';
import { Redirect } from 'react-router-dom';
import eventBus from "./EventBus";

export class Alumnos extends Component {


    constructor() {
        super()
        this.state = {
            curso: "allCourses",
            grupo: "allGroups",
            redirect: false,
            nickUsuario: "",
            contraseya: "",
            dniUsuario: "",
            nombreCompletoUsuario: "",
            correoElectronicoUsuario: "",
            numTelefonoUsuario: "",
            direccionUsuario: "",
            fechaNacimiento:"",
            numTareasEntregadas :"",
            fechaMatriculacion: ""
        }
        this.alumnos = new AlumnoComponent();
        this.edicion = this.edicion.bind(this);
        this.assignGroup = this.assignGroup.bind(this);
        this.boton = this.boton.bind(this);
        this.botonAssign = this.botonAssign.bind(this);

    }


    componentDidMount() {
        this.alumnos.getAllStudents(this.props.urlBase).then(data => this.setState({ alumnos: data }));
    }
    boton(rowData) {
        return (    
            <React.Fragment>
                <Button icon="pi pi-pencil" className="p-button-rounded p-button-success p-mr-2" onClick={() => this.edicion(rowData)} />
            </React.Fragment>
        );
    }
    
    botonAssign(rowData) {
        return (    
            <React.Fragment>
                <Button icon="pi pi-plus-circle" className="p-button-rounded p-button-success p-mr-2" onClick={() => this.assignGroup(rowData)} />
            </React.Fragment>
        );
    }
    edicion(student) {
        eventBus.dispatch("guardandoEstudiante", { nickUsuario: student.nickUsuario,
            contraseya: student.contraseya,
            dniUsuario: student.dniUsuario,
            nombreCompletoUsuario: student.nombreCompletoUsuario,
            correoElectronicoUsuario: student.correoElectronicoUsuario,
            numTelefonoUsuario: student.numTelefonoUsuario,
            direccionUsuario: student.direccionUsuario,
            fechaNacimiento:student.fechaNacimiento,
            numTareasEntregadas :student.numTareasEntregadas,
            fechaMatriculacion: student.fechaMatriculacion });
            this.setState({ 
                redirect: "/editStudent",
                // nickUsuario: student.nickUsuario,
                // contraseya: student.contraseya,
                // dniUsuario: student.dniUsuario,
                // nombreCompletoUsuario: student.nombreCompletoUsuario,
                // correoElectronicoUsuario: student.correoElectronicoUsuario,
                // numTelefonoUsuario: student.numTelefonoUsuario,
                // direccionUsuario: student.direccionUsuario,
                // fechaNacimiento:student.fechaNacimiento,
                // numTareasEntregadas :student.numTareasEntregadas,
                // fechaMatriculacion: student.fechaMatriculacion
        });
       
    }

        assignGroup(student) {
            eventBus.dispatch("guardandoAsignacionAGrupo", { nickUsuario: student.nickUsuario});
                this.setState({ 
                    redirect: "/assignGroup",
                    
            });
        }
    showSelectCourse(course) {
        console.log(course);
        if (course !== null) {
            this.setState({ curso: course });
            if (course === "allCourses") {
                this.alumnos.getAllStudents(this.props.urlBase).then(data => this.setState({ alumnos: data }));
            } else {
                this.alumnos.getStudentsByCourse(this.props.urlBase, course).then(data => this.setState({ alumnos: data }));
            }
        }
        console.log(this.state.alumnos);
    }
    showSelectGroup(group) {
        console.log(group);
        if (group !== null) {
            this.setState({ grupo: group });
            if (group === "allGroups") {
                this.alumnos.getAllStudents(this.props.urlBase).then(data => this.setState({ alumnos: data }));
            } else {
                this.alumnos.getStudentsByNameOfGroup(this.props.urlBase, group).then(data => this.setState({ alumnos: data }));
            }
        }
        console.log(this.state.alumnos);
    }

    render() {
    if (this.state.redirect) {
     //       return <Redirect push to="/editStudent" data={this.state.data}/>;
     return <Redirect
     to={{
       pathname: "/editStudent"
     }}
   />
        }

        const courseSelectItems = [
            { label: 'All courses', value: 'allCourses' },
            { label: 'A1', value: 'A1' },
            { label: 'A2', value: 'A2' },
            { label: 'B1', value: 'B1' },
            { label: 'B2', value: 'B2' },
            { label: 'Free learning', value: 'AprendizajeLibre' }
        ];

        const groupSelectItems = [
            { label: 'All groups', value: 'allGroups' },
            { label: 'grupo1', value: 'grupo1' },
            { label: 'grupo3', value: 'grupo3' }
        ];
        return (
            <React.Fragment>

                <div><ListBox value={this.state.curso} options={courseSelectItems} onChange={(e) => this.showSelectCourse(e.value)} />
                </div>
                <div>
                <ListBox value={this.state.grupo} options={groupSelectItems} onChange={(e) => this.showSelectGroup(e.value)} />
                </div>
                <div className="datatable-templating-demo">
                    <div className="card"></div>

                    <DataTable value={this.state.alumnos}>
                        <Column field="nickUsuario" header="Nick"></Column>
                        <Column field="contraseya" header="Contraseña"></Column>
                        <Column field="dniUsuario" header="DNI"></Column>
                        <Column field="nombreCompletoUsuario" header="Nombre Completo"></Column>
                        <Column field="correoElectronicoUsuario" header="Correo electrónico"></Column>
                        <Column field="numTelefonoUsuario" header="Número de teléfono"></Column>
                        <Column field="direccionUsuario" header="Dirección"></Column>
                        <Column field="fechaNacimiento" header="Fecha de nacimiento"></Column>
                        <Column field="numTareasEntregadas" header="Tareas entregadas"></Column>
                        <Column field="fechaMatriculacion" header="Fecha matriculación"></Column>
                        <Column body={this.boton}></Column>
                        <Column body={this.botonAssign}></Column>

                    </DataTable>
                </div>
            </React.Fragment>

        )
    }
}
