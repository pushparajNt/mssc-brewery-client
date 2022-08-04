package com.sfg.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sfg.web.model.BeerDto;
@Component
@ConfigurationProperties(prefix="sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

	public final String BEER_PATH_v1="/api/v1/beer/";
	private String apihost;
    
	private final RestTemplate restTemplate;
	
	
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public String getApihost() {
		return apihost;
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
	
}
