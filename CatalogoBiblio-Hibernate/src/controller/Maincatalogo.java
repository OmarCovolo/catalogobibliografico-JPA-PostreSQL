package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Query;

import model.*;


public class Maincatalogo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblio-Hibernate");
        EntityManager em = emf.createEntityManager();

        try {



            
            Scritti libro = new Libri(978-88-07-88302-6l, "Oceano Mare", 1993l, 224l, "Alessandro Baricco", "Romanzo");
            
            aggiungiElementoCatalogo(em, libro);

         
            rimuoviElementoCatalogo(em, 978-88-07-88302-6l);

         
            ricercaPerISBN(em, 978-88-07-88302-6l);
            
            ricercaPerAnnoPubblicazione(em,1993l);
            
            ricercaPerAutore(em,"Alessandro Baricco");

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void aggiungiElementoCatalogo(EntityManager em, Scritti elemento) {
        try {
            em.getTransaction().begin();
            em.persist(elemento);
            em.getTransaction().commit();
            System.out.println("Elemento aggiunto al catalogo con successo.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Errore durante l'aggiunta dell'elemento al catalogo: " + e.getMessage());
        }
    }

    public static void rimuoviElementoCatalogo(EntityManager em, Long isbn) {
        try {
            em.getTransaction().begin();
            Scritti elemento = em.find(Scritti.class, isbn);
            if (elemento != null) {
                em.remove(elemento);
                System.out.println("Elemento rimosso dal catalogo con successo.");
            } else {
                System.out.println("Nessun elemento trovato con l'ISBN specificato.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Errore durante la rimozione dell'elemento dal catalogo: " + e.getMessage());
        }
    }

    public static void ricercaPerISBN(EntityManager em, Long isbn) {
        try {
            Scritti elemento = em.find(Scritti.class, isbn);
            if (elemento != null) {
                System.out.println("Elemento trovato: " + elemento.toString());
            } else {
                System.out.println("Nessun elemento trovato con l'ISBN specificato.");
            }
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca per ISBN: " + e.getMessage());
        }
    }
    public static void ricercaPerAnnoPubblicazione(EntityManager em, Long annopubblicazione) {
        try {
            Scritti elemento = em.find(Scritti.class, annopubblicazione);
            if (elemento != null) {
                System.out.println("Elemento trovato: " + elemento.toString());
            } else {
                System.out.println("Nessun elemento trovato con l'anno specificato.");
            }
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca per anno: " + e.getMessage());
        }
    }
    public static void ricercaPerAutore(EntityManager em, String autore) {
        try {
            Scritti elemento = em.find(Scritti.class, autore);
            if (elemento != null) {
                System.out.println("Elemento trovato: " + elemento.toString());
            } else {
                System.out.println("Nessun elemento trovato con l'autore specificato.");
            }
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca per autore: " + e.getMessage());
        }
    }

  
  
    public List<Scritti> ricercaPerTitolo(String titolo) {
        List<Scritti> risultati = new ArrayList<>();
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT e FROM Scritti e WHERE e.titolo LIKE :titolo");
            query.setParameter("titolo", "%" + titolo + "%");
            risultati = query.getResultList();
            em.close();
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca per titolo: " + e.getMessage());
        }
        return risultati;
    }
    
    
    
    
    

}

