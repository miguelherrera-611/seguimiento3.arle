package org.manuelmiguelsamuel.Domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
    @Table(name = "Pacientes")

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private int telefono;

    @Column(nullable = false)
    private String genero;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    public Paciente(long id, String nombre, String apellido, int edad,int telefono, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.genero = genero;
    }


    public Paciente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return id == paciente.id && edad == paciente.edad && telefono == paciente.telefono && Objects.equals(nombre, paciente.nombre) && Objects.equals(apellido, paciente.apellido) && Objects.equals(genero, paciente.genero) && Objects.equals(citas, paciente.citas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, edad, telefono, genero, citas);
    }

    @Override
    public String toString() {
        return "Paciente: " +
                "ID = |" + id + "| \t" +
                "Nombre = |" + nombre + "| \t" +
                "Apellido = |" + apellido + "| \t" +
                "Edad = |" + edad + "| \t" +
                "Telefono = |" + telefono + "| \t" +
                "Genero = |" + genero + "| \n";
    }
}
