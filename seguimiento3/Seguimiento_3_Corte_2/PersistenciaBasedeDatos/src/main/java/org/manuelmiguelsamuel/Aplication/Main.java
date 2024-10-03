package org.manuelmiguelsamuel.Aplication;

import org.manuelmiguelsamuel.Aplication.Services.CitaService;
import org.manuelmiguelsamuel.Aplication.Services.DoctorService;
import org.manuelmiguelsamuel.Aplication.Services.PacienteService;
import org.manuelmiguelsamuel.Infraestructure.FileCitasRepository;
import org.manuelmiguelsamuel.Infraestructure.FileDoctorRepository;
import org.manuelmiguelsamuel.Infraestructure.FilePacienteRepository;
import org.manuelmiguelsamuel.Interfaces.CitasRepository;
import org.manuelmiguelsamuel.Interfaces.DoctorRepository;
import org.manuelmiguelsamuel.Interfaces.PacienteRepository;

public class Main {
    public static void main(String[] args) {
        PacienteRepository repository = new FilePacienteRepository();
        PacienteService service = new PacienteService(repository);
        

        DoctorRepository doctorRepository = new FileDoctorRepository();
        DoctorService service2 = new DoctorService(doctorRepository);

        CitasRepository citasRepository = new FileCitasRepository();
        CitaService service3 = new CitaService(citasRepository);


        Visual visual = new Visual(service,service2,service3);

        visual.iniciar();


    }
}
