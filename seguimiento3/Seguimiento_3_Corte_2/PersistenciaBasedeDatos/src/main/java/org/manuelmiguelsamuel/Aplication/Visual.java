package org.manuelmiguelsamuel.Aplication;



import org.manuelmiguelsamuel.Aplication.Services.CitaService;
import org.manuelmiguelsamuel.Aplication.Services.DoctorService;
import org.manuelmiguelsamuel.Aplication.Services.PacienteService;
import org.manuelmiguelsamuel.Domain.Cita;
import org.manuelmiguelsamuel.Domain.Doctor;
import org.manuelmiguelsamuel.Domain.Paciente;

import javax.swing.*;

public class Visual {
    private  final PacienteService pacienteService;
    private  final DoctorService doctorService;
    private  final CitaService citaService;


    public Visual(PacienteService pacienteService, DoctorService doctorService, CitaService citaService) {
        this.pacienteService = pacienteService;
        this.doctorService = doctorService;
        this.citaService = citaService;
    }


    public void iniciar(){
        while (true){
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion valida: \n" +
                    "1. Registrar paciente \n" +
                    "2. Borrar paciente del sistema \n" +
                    "3. Actualizar datos de pacientes en el sistema \n" +
                    "4. Asignar cita a paciente \n" +
                    "5. Eliminar cita de paciente \n" +
                    "6. Ver lista de pacientes \n" +
                    "7. Ver lista de citas \n" +
                    "8. Buscar paciente por id\n" +
                    "9. Administrar doctores\n" +
                    "10.Salir del programa  "));

            switch (opcion){
                case 1 -> crearPaciente();
                case 2 -> eliminarPaciente();
                case 3 -> actualizarPaciente();
                case 4 -> asignarCitaPaciente();
                case 5 -> eliminarCitaPaciente();
                case 6 -> verListaPacientes();
                case 7 -> verListaCitas();
                case 8 -> buscarPaciente();
                case 9 -> menuDoctores();
                case 10 -> {return;}
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");

            }
        }


    }
        public void crearPaciente(){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente: "));
            String nombrePaciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente: ");
            String apellidoPaciente = JOptionPane.showInputDialog("Ingrese el apellido del paciente: ");
            int edadPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente: "));
            int telefonoPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del paciente: "));
            String generoPaciente = JOptionPane.showInputDialog("Ingrese el genero del paciente: ");

            Paciente paciente = new Paciente(id,nombrePaciente,apellidoPaciente,edadPaciente,telefonoPaciente,generoPaciente);

            pacienteService.crear(paciente);
            JOptionPane.showMessageDialog(null, "Paciente creado con exito");
        }

        public void eliminarPaciente(){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente a eliminar: "));

            Paciente paciente = pacienteService.buscarPacientePorId(id);

            if(paciente != null){
                pacienteService.eliminarPaciente(id);
                JOptionPane.showMessageDialog(null, "Paciente borrado con exito");
            }
            else JOptionPane.showMessageDialog(null,"Paciente no encontrado");

        }

        public void actualizarPaciente(){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente para actualizar sus datos: "));

            Paciente paciente = pacienteService.buscarPacientePorId(id);

            if(paciente != null){
                while (true){

                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion valida:\n" +
                        "1. Actualizar nombre \n" +
                        "2. Actualizar Apellido \n" +
                        "3. Actualizar edad \n" +
                        "4. Actualizar telefono \n" +
                        "5. Actualizar genero \n" +
                        "6. Actulizar todos los datos \n7. Regresar a pantalla de inicio"));


                switch (opcion){
                    case 1: {
                        String nuevoNombrePaciente = JOptionPane.showInputDialog("Ingrese el nuevo nombre del paciente: ");
                        paciente.setNombre(nuevoNombrePaciente);
                        pacienteService.actualizarPaciente(paciente);
                        JOptionPane.showMessageDialog(null,"Nombre actualizado con exito");
                        break;
                    }
                    case 2: {
                        String nuevoApellidoPaciente = JOptionPane.showInputDialog("Ingrese el nuevo apellido del paciente: ");
                        paciente.setApellido(nuevoApellidoPaciente);
                        pacienteService.actualizarPaciente(paciente);
                        JOptionPane.showMessageDialog(null,"Apellido actualizado con exito");
                        break;
                    }
                    case 3: {
                        int nuevaEdadPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva  edad del paciente: "));
                        paciente.setEdad(nuevaEdadPaciente);
                        pacienteService.actualizarPaciente(paciente);
                        JOptionPane.showMessageDialog(null,"Edad actualizada con exito");
                        break;
                    }
                    case 4: {
                        int nuevoTelefonoPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo telefono del paciente: "));
                        paciente.setTelefono(nuevoTelefonoPaciente);
                        pacienteService.actualizarPaciente(paciente);
                        JOptionPane.showMessageDialog(null,"Telefono actualizado con exito");
                        break;
                    }
                    case 5: {
                        String nuevoGeneroPaciente = JOptionPane.showInputDialog("Ingrese el nuevo genero del paciente: ");
                        paciente.setGenero(nuevoGeneroPaciente);
                        pacienteService.actualizarPaciente(paciente);
                        JOptionPane.showMessageDialog(null,"Genero actualizado con exito");
                        break;
                    }
                    case 6: {
                        String nuevoNombrePaciente = JOptionPane.showInputDialog("Ingrese el nuevo nombre del paciente: ");
                        paciente.setNombre(nuevoNombrePaciente);

                        String nuevoApellidoPaciente = JOptionPane.showInputDialog("Ingrese el nuevo apellido del paciente: ");
                        paciente.setApellido(nuevoApellidoPaciente);

                        int nuevaEdadPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva  edad del paciente: "));
                        paciente.setEdad(nuevaEdadPaciente);

                        int nuevoTelefonoPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo telefono del paciente: "));
                        paciente.setTelefono(nuevoTelefonoPaciente);

                        String nuevoGeneroPaciente = JOptionPane.showInputDialog("Ingrese el genero del paciente: ");
                        paciente.setGenero(nuevoGeneroPaciente);

                        pacienteService.actualizarPaciente(paciente);
                        break;
                    }
                    case 7: return;
                    default: JOptionPane.showMessageDialog(null, "Opcion no valida");
                    }
                }
            } else JOptionPane.showMessageDialog(null,"Paciente no encontrado");
        }



        public void menuDoctores(){
        while (true){
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion valida: \n" +
                    "1. Agregar doctor al sistema \n" +
                    "2. Borrar doctor del sistema \n" +
                    "3. Actualizar datos de doctor \n" +
                    "4. Ver lista de doctores \n" +
                    "5. Buscar doctor por ID \n" +
                    "6. Regresar a pantalla de inicio"));

            switch (opcion){
                case 1 -> crearDoctor();
                case 2 -> eliminarDoctor();
                case 3 -> actualizarDoctor();
                case 4 -> listarDoctores();
                case 5 -> buscarDoctores();
                case 6 -> {
                    return;
                }
            }
        }
    }



        public void verListaPacientes(){
            System.out.println("Lista de pacientes: \n");
            pacienteService.listarPacientes().forEach(System.out::println);
        }

        public void listarDoctores(){
            System.out.println("Lista de doctores: \n");
            doctorService.listarDoctors().forEach(System.out::println);
        }

        public void buscarPaciente(){
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente para realizar la busqueda: "));

            Paciente paciente = pacienteService.buscarPacientePorId(opcion);

            if (paciente != null){
                JOptionPane.showMessageDialog(null, paciente.toString());
            }
            else JOptionPane.showMessageDialog(null,"Paciente no encontrado");
        }

        public void buscarDoctores(){
            int busqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del doctor para realizar la busqueda : "));

            Doctor doctor = doctorService.buscarDoctorPorId(busqueda);

            if (doctor != null){
                JOptionPane.showMessageDialog(null, doctor.toString());
            } else JOptionPane.showMessageDialog(null,"Doctor no encontrado");


        }

        public void crearDoctor(){
        try {

            String nombreDoctor = JOptionPane.showInputDialog("Ingrese el nombre del doctor: ");
            String apellidoDoctor = JOptionPane.showInputDialog("Ingrese el apellido del doctor: ");
            int edadDoctor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del doctor: "));
            int telefonoDoctor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del doctor: "));
            String generoDoctor = JOptionPane.showInputDialog("Ingrese el genero del doctor: ");
            String especialidadDoctor = JOptionPane.showInputDialog("Ingrese el cargo que ocupa el doctor: ");
            String estadoDoctor = JOptionPane.showInputDialog("Ingrese la disponibilidad del doctor: ");

            Doctor doctor = new Doctor(nombreDoctor,apellidoDoctor,edadDoctor,telefonoDoctor,generoDoctor,especialidadDoctor,estadoDoctor);
            doctorService.crearDoctor(doctor);
            JOptionPane.showMessageDialog(null,"Doctor registrado correctamente");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Dato erroneo ingresado");
        }
    }
    
    public void eliminarDoctor(){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del doctor para borrarlo del sistma"));
        
        Doctor doctor = doctorService.buscarDoctorPorId(opcion);
        
        if (doctor != null){
            doctorService.eliminarDoctor(opcion);
        }
        else JOptionPane.showMessageDialog(null, "El id del doctor no fue encontrado o no se encuentra registrado");
    }
    
    public void actualizarDoctor(){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del doctor para actualizar sus datos: "));

            Doctor doctor = doctorService.buscarDoctorPorId(id); 

            if(doctor != null){
                while (true){

                    int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion valida:\n" +
                            "1. Actualizar nombre \n" +
                            "2. Actualizar Apellido \n" +
                            "3. Actualizar edad \n" +
                            "4. Actualizar telefono \n" +
                            "5. Actualizar genero \n" +
                            "6. Actualizar especialidad \n" +
                            "7. Actulizar estado \n" +
                            "8. Actualizar todos los datos \n" +
                            "9. Regresar a pantalla de inicio"));


                    switch (opcion){
                        case 1: {
                            String nuevoNombreDoctor = JOptionPane.showInputDialog("Ingrese el nuevo nombre del doctor: ");
                            doctor.setNombre(nuevoNombreDoctor);
                            doctorService.actualizarDoctor(doctor);
                            JOptionPane.showMessageDialog(null,"Nombre actualizado con exito");
                            break;
                        }
                        case 2: {
                            String nuevoApellidoDoctor = JOptionPane.showInputDialog("Ingrese el nuevo apellido del doctor: ");
                            doctor.setApellido(nuevoApellidoDoctor);
                            doctorService.actualizarDoctor(doctor);
                            JOptionPane.showMessageDialog(null,"Apellido actualizado con exito");
                            break;
                        }
                        case 3: {
                            int nuevaEdadDoctor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva  edad del doctor: "));
                            doctor.setEdad(nuevaEdadDoctor);
                            doctorService.actualizarDoctor(doctor);
                            JOptionPane.showMessageDialog(null,"Edad actualizada con exito");
                            break;
                        }
                        case 4: {
                            int nuevoTelefonoDoctor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo telefono del doctor: "));
                            doctor.setTelefono(nuevoTelefonoDoctor);
                            doctorService.actualizarDoctor(doctor);
                            JOptionPane.showMessageDialog(null,"Telefono actualizado con exito");
                            break;
                        }
                        case 5: {
                            String nuevoGeneroDoctor = JOptionPane.showInputDialog("Ingrese el nuevo genero del doctor: ");
                            doctor.setSexo(nuevoGeneroDoctor);
                            doctorService.actualizarDoctor(doctor);
                            JOptionPane.showMessageDialog(null,"Genero actualizado con exito");
                            break;
                        }
                        case 6:{
                            String nuevaEspecialidad = JOptionPane.showInputDialog("Ingrese la nueva especialidad del doctor: ");
                            doctor.setEspecialidad(nuevaEspecialidad);
                            doctorService.actualizarDoctor(doctor);
                            JOptionPane.showMessageDialog(null,"Especialidad actualizado con exito");
                            break;
                        }
                        case 7:{
                            String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado del doctor: ");
                            doctor.setEstado(nuevoEstado);
                            doctorService.actualizarDoctor(doctor);
                            JOptionPane.showMessageDialog(null,"Estado actualizado con exito");
                            break;
                        }
                        case 8: {
                            String nuevoNombreDoctor = JOptionPane.showInputDialog("Ingrese el nuevo nombre del doctor: ");
                            doctor.setNombre(nuevoNombreDoctor);

                            String nuevoApellidoDoctor = JOptionPane.showInputDialog("Ingrese el nuevo apellido del doctor: ");
                            doctor.setApellido(nuevoApellidoDoctor);

                            int nuevaEdadDoctor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva  edad del doctor: "));
                            doctor.setEdad(nuevaEdadDoctor);

                            int nuevoTelefonoDoctor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo telefono del doctor: "));
                            doctor.setTelefono(nuevoTelefonoDoctor);

                            String nuevoGeneroDoctor = JOptionPane.showInputDialog("Ingrese el genero del doctor: ");
                            doctor.setSexo(nuevoGeneroDoctor);

                            String nuevaEspecialidad = JOptionPane.showInputDialog("Ingrese la nueva especialidad del doctor: ");
                            doctor.setEspecialidad(nuevaEspecialidad);

                            String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado del doctor: ");
                            doctor.setEstado(nuevoEstado);
                            doctorService.actualizarDoctor(doctor);

                            doctorService.actualizarDoctor(doctor);

                            JOptionPane.showMessageDialog(null,"Todos los datos del doctor han sido actualizados");
                            break;
                        }
                        case 9: return;
                        default: JOptionPane.showMessageDialog(null, "Opcion no valida");
                    }
                }
            } else JOptionPane.showMessageDialog(null,"Doctor no encontrado");
        }


    public void asignarCitaPaciente(){
            String titulo = JOptionPane.showInputDialog("Ingrese un titulo para la cita");
            String fecha = JOptionPane.showInputDialog("Ingrese la fecha para la cita. formato d/m/a");
            String hora = JOptionPane.showInputDialog("Ingrese la hora para la cita. formato 24 horas");
            String motivo = JOptionPane.showInputDialog("Ingrese el motivo para la cita");


            while (true){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente para asignarle la cita: "));
            Paciente paciente = pacienteService.buscarPacientePorId(id);

            if (paciente != null){
                Cita cita = new Cita(titulo, fecha, hora, motivo,paciente);
                citaService.crearCita(cita);
                JOptionPane.showMessageDialog(null,"Cita creada y asignada exitosamente ");
            return;

        } else JOptionPane.showMessageDialog(null,"Paciente no encontrado");


            }
    }


    public void eliminarCitaPaciente(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cita para borrarla: "));

        citaService.eliminarCita(id);
        JOptionPane.showMessageDialog(null,"Cita elimada exitosamente");

    }


    public void verListaCitas(){
        System.out.println("Lista de citas");
        citaService.listarCitas().forEach(System.out::println);
    }


}
