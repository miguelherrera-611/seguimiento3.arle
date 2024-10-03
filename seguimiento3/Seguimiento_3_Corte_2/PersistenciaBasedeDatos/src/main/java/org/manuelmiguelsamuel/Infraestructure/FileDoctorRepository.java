package org.manuelmiguelsamuel.Infraestructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.manuelmiguelsamuel.Domain.Doctor;
import org.manuelmiguelsamuel.Interfaces.DoctorRepository;

import java.util.List;

public class FileDoctorRepository implements DoctorRepository {

    private final EntityManagerFactory emf;

    public FileDoctorRepository() {
        emf = Persistence.createEntityManagerFactory("DoctorUp");
    }

    public void saveDoctor(Doctor doctor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(doctor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(doctor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteDoctor(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Doctor doctor = em.find(Doctor.class, id);
            if (doctor != null) {
                em.remove(doctor);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Doctor findDoctorById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Doctor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Doctor> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Doctor p", Doctor.class)
                    .getResultList();
        }
    }

    public void cerrar() {
        emf.close();
    }
    
}
