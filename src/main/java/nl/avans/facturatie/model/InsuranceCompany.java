    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tom Maljaars
 */
public class InsuranceCompany {
    
    /**
     *
     */
    @NotNull
    @Size(min = 1, max = 35)
    public String Name;

    /**
     *
     */
    @NotNull
    @Size(min = 1, max = 35)
    public String Address;

    /**
     *
     */
    @NotNull
    @Size(min = 1, max = 35)
    public String Zipcode;

    /**
     *
     */
    @NotNull
    @Size(min = 1, max = 35)
    public String City;

    /**
     *
     */
    @NotNull
    @Size(min = 1, max = 35)
    public String Telnumber;

    /**
     *
     */
    @NotNull
    @Size(min = 1, max = 35)
    public String Email;

    /**
     *
     */
    public int InsuranceCompanyID;

    /**
     *
     */
    public InsuranceCompany() {}

    /**
     *
     * @param Name
     * @param Address
     * @param Zipcode
     * @param City
     * @param Telnumber
     * @param Email
     * @param InsuranceCompanyID
     */
    public InsuranceCompany(String Name, String Address, String Zipcode, String City, String Telnumber, String Email, int InsuranceCompanyID) {
        this.Name = Name;
        this.Address = Address;
        this.Zipcode = Zipcode;
        this.City = City;
        this.Telnumber = Telnumber;
        this.Email = Email;
        this.InsuranceCompanyID = 0;
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @return
     */
    public String getZipCode() {
        return Zipcode;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @return
     */
    public String getTelnumber() {
        return Telnumber;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return InsuranceCompanyID;
    }

    /**
     *
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @param Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @param Zipcode
     */
    public void setZipCode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    /**
     *
     * @param City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @param Telnumber
     */
    public void setTelnumber(String Telnumber) {
        this.Telnumber = Telnumber;
    }

    /**
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     *
     * @param InsuranceCompanyID
     */
    public void setId(int InsuranceCompanyID) {
        this.InsuranceCompanyID = InsuranceCompanyID;
    }    
}
