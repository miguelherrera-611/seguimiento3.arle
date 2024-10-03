package org.manuelmiguelsamuel.Infraestructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.manuelmiguelsamuel.Domain.Cita;
import org.manuelmiguelsamuel.CitasRepository;

import java.util.List;

public class FileCitasRepository implements CitasRepository {
    private final EntityManagerFactory emf;

    public FileCitasRepository() {
        emf = Persistence.createEntityManagerFactory("CitasUp");
    }

    @Override
    public void saveCita(Cita cita) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(cita);
            em.getTransaction().commit();
        }
    }

    @Override
    public void updateCita(Cita cita) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(cita);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteCita(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Cita cita = em.find(Cita.class, id);
            if (cita != null) {
                em.remove(cita);
            }
            em.getTransaction().commit();
        }
    }

    @Override
    public Cita findCitaById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cita.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Cita> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Cita p", Cita.class)
                    .getResultList();
        }
    }


}
