package nl.avans.facturatie.config;

import nl.avans.facturatie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import nl.avans.facturatie.repository.AppointmentRepository;
import nl.avans.facturatie.repository.InvoiceRepository;
import nl.avans.facturatie.service.AppointmentService;
import nl.avans.facturatie.service.TreatmentService;

/**
 * @author Petri Kainulainen
 *
 * Dit bestand bevat database settings voor het starten van de applicatie.
 */
@SuppressWarnings("Duplicates")
@Profile("default")
@Configuration
@EnableTransactionManagement
public class PersistenceContext {

    /**
     *
     */
    protected static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";

    /**
     *
     */
    protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "Fac*turatie";

    /**
     *
     */
    protected static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://145.48.6.147/facturatie";

    /**
     *
     */
    protected static final String PROPERTY_NAME_DATABASE_USERNAME = "Facturatie";

    private static final String PROPERTY_PACKAGES_TO_SCAN = "nl.avans.facturatie.config";

    @Resource
    private Environment environment;

    /**
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
        dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
        dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
        dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

        return dataSource;
    }

    /**
     *
     * @return
     */
    @Bean
    @Qualifier("PersistenceContext")
    @Primary
    public CustomerRepository getCustomerRepository() {
        return new CustomerRepository(this.dataSource());
    }
    
    /**
     *
     * @return
     */
    @Bean
    @Qualifier("PersistenceContext")
    @Primary
    public AppointmentRepository getBillingRepository() {
        return new AppointmentRepository(this.dataSource());
    }
    
    /**
     *
     * @return
     */
    @Bean
    @Qualifier("PersistenceContext")
    @Primary
    public InvoiceRepository getInvoiceRepository() {
        return new InvoiceRepository(this.dataSource());
    }
    
    /**
     *
     * @return
     * @throws JAXBException
     */
    @Bean
    @Qualifier("PersistenceContext")
    @Primary
    public TreatmentService getTreatmentRepository() throws JAXBException {
        return new TreatmentService();
    }
    
    /**
     *
     * @return
     */
    @Bean
    @Qualifier("PersistenceContext")
    @Primary
    public AppointmentRepository getAppointmentRepository() {
        return new AppointmentRepository(this.dataSource());
    }
    
    /**
     *
     * @return
     */
    @Bean
    @Qualifier("PersistenceContext")
    @Primary
    public AppointmentService getAppointmentService() {
        return new AppointmentService();
    }

}
