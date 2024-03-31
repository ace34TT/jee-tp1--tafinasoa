/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tafinasoa.tp1.jsf;

import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
import mg.itu.tafinasoa.tp1.entities.Customer;
import mg.itu.tafinasoa.tp1.entities.Discount;
import mg.itu.tafinasoa.tp1.services.CustomerManager;
import mg.itu.tafinasoa.tp1.services.DiscountManager;

@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @Inject
    private CustomerManager customerManager;
    @Inject

    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String update() {
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    public List<Discount> getDiscounts() {
        return discountManager.getAllDiscounts();
    }
}
