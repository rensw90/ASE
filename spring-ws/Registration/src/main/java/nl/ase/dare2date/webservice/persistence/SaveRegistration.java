package nl.ase.dare2date.webservice.persistence;

import nl.ase.dare2date.webservice.Subscriber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by samuel on 4-6-14.
 */
public class SaveRegistration implements ISaveRegistration {
    public boolean saveSubscriber(Subscriber subscriber) {
        SubscriberPersistence subscriberPersistence = new SubscriberPersistence();
        subscriberPersistence.setAddress(subscriber.getAddress());
        subscriberPersistence.setEmail(subscriber.getEmail());
        subscriberPersistence.setName(subscriber.getName());
        subscriberPersistence.setPassword(subscriber.getPassword());
        subscriberPersistence.setUsername(subscriber.getUsername());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("subscriber");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(subscriberPersistence);
            tx.commit();
        } catch (Throwable e) {
            //e.printStackTrace();
            return false;
        }
        return true;
    }
}
