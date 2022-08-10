package com.sfg.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sfg.web.model.BeerDto;
import com.sfg.web.model.CustomerDto;
@ConfigurationProperties(prefix="sfg.brewery",ignoreUnknownFields = false)
@Component
public class BreweryClient {

	public final String BEER_PATH_v1="/api/v1/beer/";
	public final String CUSTOMER_PATH_V1="/api/v1/customer/";
	private String apihost;
    
	private final RestTemplate restTemplate;
	
	
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}


	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
	
	public BeerDto getBeerById(UUID beerId)
	
	{
		System.out.println(apihost+BEER_PATH_v1+beerId.toString());
        System.out.println(restTemplate.getForObject(apihost+BEER_PATH_v1+beerId.toString(), BeerDto.class));
		return restTemplate.getForObject(apihost+BEER_PATH_v1+beerId.toString(), BeerDto.class);
	}
	
	public URI saveNewBeer(BeerDto beerDto)
	{
		System.out.println("Printing post URI:");
		System.out.println(restTemplate.postForLocation(apihost+BEER_PATH_v1, beerDto));
		return restTemplate.postForLocation(apihost+BEER_PATH_v1, beerDto);
	}
	
	public void updateBeer(UUID uuid,BeerDto beerDto)
	{
		restTemplate.put(apihost+BEER_PATH_v1+uuid.toString(), beerDto);
	}
	public void deleteBeer(UUID uuid)
	{
		restTemplate.delete(apihost+BEER_PATH_v1+uuid.toString());
	}
	
	
	public CustomerDto getCustomerById(UUID uuid)
	{
		System.out.println("printing getcustomerById ");
		System.out.println(restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+uuid.toString(), CustomerDto.class));
		return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+uuid.toString(), CustomerDto.class);
	}
	
	public URI addNewCustomer(CustomerDto  customerDto)
	{
		System.out.println(restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1, customerDto));
		return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1, customerDto);
		
	}
	
	public void updateCustomer(UUID customerId,CustomerDto customerDto)
	{
		 restTemplate.put(apihost+CUSTOMER_PATH_V1+customerId.toString(),customerDto);
	}
	
	public void deleteCustomer(UUID uuid)
	{
		restTemplate.delete(apihost+CUSTOMER_PATH_V1+uuid.toString());
	}
}
