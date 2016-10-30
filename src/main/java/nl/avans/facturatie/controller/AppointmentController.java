/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nl.avans.facturatie.model.Appointment;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.AppointmentService;
import nl.avans.facturatie.service.CustomerService;
import nl.avans.facturatie.service.InvoiceService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Tom Maljaars
 */

@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class AppointmentController {
    
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    } 
	
    private final Logger logger = LoggerFactory.getLogger(AppointmentService.class);;

    private final AppointmentService appointmentService;
    private CustomerService customerService;
    private InvoiceService invoiceService;
    private Appointment appointment;
        
    @Autowired
    public AppointmentController(AppointmentService appointmentService, CustomerService customerService, InvoiceService invoiceService){
        this.appointmentService = appointmentService;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
    }
   
    
   

    /**
     * Haal de appointment met gegeven ID uit de database en toon deze in een view.
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET)
    public String listOneAppointment(@ModelAttribute("user") User user, Model model, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }        
        
        // Zet de opgevraagde waarden in het model
        Appointment appointment = appointmentService.findAppointmentById(id);
        model.addAttribute("appointment", appointment);
        
        //logger.info(appointment.getCustomerID() + "");
       
        int customerID = appointment.getPatientId();
        model.addAttribute("customer", customerService.findCustomerById(customerID));
        
       return "views/appointment/read";
    }
    
    
    
     @RequestMapping(value="/appointment/{id}/edit", method = RequestMethod.GET)
    public String showEditAppointmentForm(@ModelAttribute("user") User user, final ModelMap model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        //Appointment appointment = appointmentService.findAppointmentById(id);
        model.addAttribute("appointment", appointment);
        //logger.info(appointment.getCustomerID() + "");
        
        return "views/appointment/edit";
    }
    
    @RequestMapping(value="/appointment/{id}/edit", method = RequestMethod.POST)
    public String validateAndSaveEditedAppointment(@ModelAttribute("user") User user, final ModelMap model, @Valid Appointment appointment, final BindingResult bindingResult, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        //error handeling met het aanpassen van een gebruiker gaat nog niet goed!
        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            logger.info("validateAndSaveCustomer - not added, bindingResult.hasErrors");
            return "views/appointment/list";
        }

        //appointmentService.edit(appointment, Integer.parseInt(id));

        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        //model.addAttribute("appointments", appointmentService.findAllAppointments());
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        // Open de juiste view template als resultaat.
        return "views/appointment/list";
    }
    
    
   
    
    @ExceptionHandler(value = SQLException.class)
    public ModelAndView handleError(HttpServletRequest req, SQLException ex) {
        // logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("title", "Exception in AppointmentController");
        mav.addObject("url", req.getRequestURL());
        // Je kunt hier kiezen in welke view je een melding toont - op een
        // aparte pagina, of als alertbox op de huidige pagina.
         mav.setViewName("error/error");
//        mav.setViewName("views/appointment/create");
        return mav;
    }
    
    /**
     * Retourneer alle rekeningen. Wordt gebruikt om uiteindelijk een rekening aan een klant te 
     *
     * @return
     */
    public List<Appointment> findAllAppointments() { return appointmentService.getAllAppointments(); }
    
}