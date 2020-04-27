package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.Ims;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}
		return null;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		customerService.create(new Customer(firstName, surname));
		LOGGER.info("Customer created");
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}
		return null;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		customerService.update(new Customer(id, firstName, surname));
		LOGGER.info("Customer Updated");
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}
		return null;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		customerService.delete(id);
		LOGGER.info("customer deleted");
		LOGGER.info("type 'RETURN' if you would like to go back to the options menu");
		String answer = getInput();
		if (answer.toLowerCase().equals("return")) {
			Ims newIms = new Ims();
			newIms.imsSystem();
		}
	}

}
