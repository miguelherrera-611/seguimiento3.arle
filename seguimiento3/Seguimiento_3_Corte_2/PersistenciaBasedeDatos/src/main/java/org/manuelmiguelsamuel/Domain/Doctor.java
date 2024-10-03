package org.manuelmiguelsamuel.Domain;

import jakarta.persistence.*;

    @Entity
    @Table(name = "Doctores")

public class Doctor {
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
        private String sexo;

        @Column(nullable = false)
        private String especialidad;

        @Column(nullable = false)
        private String estado;


        public Doctor(String nombre, String apellido, int edad,int telefono, String sexo, String especialidad, String estado) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.telefono = telefono;
            this.sexo = sexo;
            this.especialidad = especialidad;
            this.estado = estado;
        }


        public Doctor() {}

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

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }


        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return "Doctor: " +
                    "ID = |" + id + "|\t" +
                    "Nombre = |" + nombre + "|\t" +
                    "Apellido = |" + apellido + "|\t" +
                    "Edad = |" + edad + "|\t"+
                    "Telefono = |" + telefono + "|\t" +
                    "Sexo = |" + sexo + "|\t" +
                    "Especialidad = |" + especialidad + "|\t" +
                    "Estado = |" + estado + "|\t";
        }
    }
