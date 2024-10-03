package org.manuelmiguelsamuel.Aplication.Services;

import org.manuelmiguelsamuel.Cita;
import org.manuelmiguelsamuel.Interfaces.CitasRepository;

import java.util.List;

public class CitaService {
    private final CitasRepository citasRepository;

    public CitaService(CitasRepository citasRepository) {
        this.citasRepository = citasRepository;
    }

    public void crearCita(Cita cita) {
        citasRepository.saveCita(cita);
    }

    public List<Cita> listarCitas() {
        return citasRepository.findAll();
    }

    public void eliminarCita(int id) {
        citasRepository.deleteCita(id);
    }

    public Cita buscarCita(int id) {
        return citasRepository.findCitaById(id);
    }

    public void actualizarCita(Cita cita) {
        citasRepository.updateCita(cita);
    }
}
