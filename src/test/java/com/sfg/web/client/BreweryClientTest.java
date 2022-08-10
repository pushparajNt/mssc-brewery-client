package com.sfg.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sfg.web.model.BeerDto;
import com.sfg.web.model.CustomerDto;

@SpringBootTest
class BreweryClientTest {

	@Autowired
	BreweryClient breweryClient;
	
	@Test
	void testGetBeerById() {
	BeerDto beerDto=breweryClient.getBeerById(UUID.randomUUID());
	assertNotNull(beerDto);
	System.out.println(beerDto);
	}

	@Test
	void createNewBeer() {
	 BeerDto beerDto=BeerDto.builder().beerName("Pushparaj").build();	
	  URI uri=breweryClient.saveNewBeer(beerDto);
	  assertNotNull(uri);
	  System.out.println("Printing uri inside Test");
	  System.out.println(uri.toString());
	}

	@Test
	void updateBeer() {
	 BeerDto beerDto=BeerDto.builder().beerName("Bronnie vare").build();	
	 breweryClient.updateBeer(UUID.randomUUID(), beerDto);
	}

	@Test
	void deleteBeer() {	
	 breweryClient.deleteBeer(UUID.randomUUID());
	}
	
	@Test
	void testGetCustomerById() {
	CustomerDto customerDto=breweryClient.getCustomerById(UUID.randomUUID());
	assertNotNull(customerDto);
	System.out.println(customerDto);
	}
	
	@Test
	void createNewCustomer() {
	CustomerDto customerDto=CustomerDto.builder().name("Ilayaraja").build();
	  URI uri=breweryClient.addNewCustomer(customerDto);
	  assertNotNull(uri);
	  System.out.println("Printing uri inside Test");
	  System.out.println(uri.toString());
	}

	@Test
	void updateCustomer() {
		CustomerDto customerDto=CustomerDto.builder().name("Ilayaraja").build();
	 breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
	}

	@Test
	void deleteCustomer() {	
	 breweryClient.deleteCustomer(UUID.randomUUID());
	}

}
