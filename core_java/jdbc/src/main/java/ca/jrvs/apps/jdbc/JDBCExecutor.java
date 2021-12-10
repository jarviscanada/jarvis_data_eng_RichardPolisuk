package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCExecutor {

  public static void main(String[] args) {

    BasicConfigurator.configure(); // Use default logger config

    final Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);

    DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport",
        "postgres", "password");
    try {
      Connection connection = dcm.getConnection();
      CustomerDAO customerDAO = new CustomerDAO(connection);
      Customer customer = new Customer();
      customer.setFirstName("Justin");
      customer.setLastName("Trudeau");
      customer.setEmail("pm@pm.gc.ca");
      customer.setAddress("80 Wellington Street");
      customer.setCity("Ottawa");
      customer.setState("ON");
      customer.setPhone("(555) 555-9845");
      customer.setZipCode("K1A 0A2");

      Customer dbCustomer = customerDAO.create(customer);
      logger.info(String.valueOf(dbCustomer));

      dbCustomer = customerDAO.findById(dbCustomer.getId());
      logger.info(String.valueOf(dbCustomer));

      dbCustomer.setEmail("justin@pm.gc.ca");
      dbCustomer = customerDAO.update(dbCustomer);
      logger.info(String.valueOf(dbCustomer));

      customerDAO.delete(dbCustomer.getId());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
