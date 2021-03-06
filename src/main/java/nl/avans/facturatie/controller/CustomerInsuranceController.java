package nl.avans.facturatie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.CustomerService;
import nl.avans.facturatie.service.CustomerInsuranceService;

/**
 *
 * @author Gebruiker
 */
@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class CustomerInsuranceController {

    /**
     *
     * @return
     */
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }     

    private final Logger logger = LoggerFactory.getLogger(CustomerInsuranceService.class);
    
    
    private final CustomerInsuranceService customerInsuranceService;
    private final CustomerService customerService;
    
    private Customer customer;

    /**
     *
     * @param customerInsuranceService
     * @param customerService
     */
    @Autowired
    public CustomerInsuranceController(CustomerInsuranceService customerInsuranceService, CustomerService customerService) {
        this.customerInsuranceService = customerInsuranceService;
        this.customerService = customerService;
    }

    /**
     *
     * @return
     */
    @ModelAttribute("page")
    public String module() {
        return "customers";
    }

    // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.

    /**
     *
     * @return
     */
    @ModelAttribute("classActiveCustomer")
    public String highlightNavMenuItem() {
        return "active";
    }

    ;

    /**
     * Haal een lijst van Customers en toon deze in een view.
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchpage", method = RequestMethod.GET)
    public String listCustomer(@ModelAttribute("user") User user, Model model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.debug("listCustomers");
        // Zet de opgevraagde customers in het model
        model.addAttribute("customers", customerInsuranceService.findAllCustomers());
        // Open de juiste view template als resultaat.
        return "views/customerinsurance/list";
    }

    /**
     *
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = SQLException.class)
    public ModelAndView handleError(HttpServletRequest req, SQLException ex) {
        // logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("title", "Exception in CustomerController");
        mav.addObject("url", req.getRequestURL());
        // Je kunt hier kiezen in welke view je een melding toont - op een
        // aparte pagina, of als alertbox op de huidige pagina.
        mav.setViewName("error/error");
//        mav.setViewName("views/customer/create");
        return mav;
    }

    /**
     * Retourneer alle customers. Wordt gebruikt bij het uitlenen van een boek,
     * om een uitlening aan een customer te koppelen.
     *
     * @return
     */
    public List<Customer> findAllCustomers() {
        return customerInsuranceService.findAllCustomers();
    }

}
