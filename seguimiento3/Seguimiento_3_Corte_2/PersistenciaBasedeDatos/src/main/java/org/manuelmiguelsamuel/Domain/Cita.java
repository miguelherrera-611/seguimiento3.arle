package org.manuelmiguelsamuel.Domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
    @Table(name = "Citas")

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private String hora;

    @Column(nullable = false)
    private String motivo;


    @ManyToOne()
    @JoinColumn(name = "Nombre del paciente")

    private Paciente paciente;



    public Cita(String titulo, String fecha, String hora, String motivo, Paciente paciente ) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.paciente = paciente;
    }

    public Cita() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return id == cita.id && Objects.equals(titulo, cita.titulo) && Objects.equals(fecha, cita.fecha) && Objects.equals(hora, cita.hora) && Objects.equals(motivo, cita.motivo) && Objects.equals(paciente, cita.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, fecha, hora, motivo, paciente);
    }


    @Override
    public String toString() {
       paciente = getPaciente();
        return "Informacion de cita: " +
                "ID de la cita = |" + id + "|\t" +
                "Titulo = |" + titulo + "|\t" +
                "Fecha = |" + fecha + "|\t" +
                "Hora = |" + hora + "|\t" +
                "Motivo |" + motivo + "|\t" +
                "Paciente = |" + paciente.getNombre() + "|\t";


    }
}
