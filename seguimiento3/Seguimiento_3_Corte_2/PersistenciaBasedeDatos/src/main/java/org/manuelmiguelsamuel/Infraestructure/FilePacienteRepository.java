package org.manuelmiguelsamuel.Infraestructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.manuelmiguelsamuel.Domain.Paciente;
import org.manuelmiguelsamuel.Interfaces.PacienteRepository;

import java.util.List;

public class FilePacienteRepository implements PacienteRepository {

    private final EntityManagerFactory emf;

    public FilePacienteRepository() {
        emf = Persistence.createEntityManagerFactory("PacienteUp");
    }

    public void save(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Paciente paciente = em.find(Paciente.class, id);
            if (paciente != null) {
                em.remove(paciente);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Paciente findById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Paciente> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Paciente p", Paciente.class)
                    .getResultList();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
