/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tafinasoa.tp1.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import mg.itu.tafinasoa.tp1.entities.Customer;

/**
 *
 * @author aceky
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
        System.err.println("connection check is set to " + isDatabaseConnected());
        Query query = em.createNamedQuery("Customer.findAll");
        for (Object object : query.getResultList()) {
            System.out.println(object.toString());
        }
        return query.getResultList();
    }

    public boolean isDatabaseConnected() {
        try {
            // Try to get a connection
            Connection connection = em.unwrap(Connection.class);

            // If the connection is not null, then the database is connected
            if (connection != null && !connection.isClosed()) {
                return true;
            }
        } catch (SQLException ex) {
            // Log the exception
            ex.printStackTrace();
        }

        // If we've reached this point, then the database is not connected
        return false;
    }

    @Transactional
    public Customer update(Customer customer) {
        System.out.println(customer.toString());
        return em.merge(customer);
    }

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
}
