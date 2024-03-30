/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tafinasoa.tp1.manager;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    @Transactional
    public Customer update(Customer customer) {
        return null;
    }
}
