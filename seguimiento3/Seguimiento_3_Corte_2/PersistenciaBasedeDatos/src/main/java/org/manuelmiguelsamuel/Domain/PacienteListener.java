package org.manuelmiguelsamuel.Domain;

import jakarta.persistence.*;

public class PacienteListener {
    @PrePersist
    public void PrePerSist(Paciente paciente){
        System.out.println("Paciente a persistir: " + paciente);
    }

    @PostPersist
    public void PostPerSist(Paciente paciente){
        System.out.println("Paciente persistido: " + paciente);
    }


    @PreUpdate
    public void preUpdate(Paciente paciente) {
        System.out.println("Paciente a ser actualizado: " + paciente);
    }

    @PostUpdate
    public void postUpdate(Paciente paciente) {
        System.out.println("Paciente actualizado: " + paciente);
    }

    @PreRemove
    public void preRemove(Paciente paciente) {
        System.out.println("Paciente a ser eliminado: " + paciente);
    }

    @PostRemove
    public void postRemove(Paciente paciente) {
        System.out.println("Paciente eliminado: " + paciente);
    }
}
