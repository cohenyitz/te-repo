package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatFact;


@Component
public class RestCatFactService implements CatFactService {

	private RestTemplate restTemplate = new RestTemplate();
	private String CAT_FACT_API_URL = "https://cat-fact.herokuapp.com/facts/random";
	
	@Override
	public CatFact getFact(){
	CatFact aCatFact = new CatFact();
	aCatFact = restTemplate.getForObject(CAT_FACT_API_URL, CatFact.class);
		
		// We know that the API at the url: https://cat-fact.herokuapp.com/facts/random
		//	will return a random cat fact
		// Use RestTemplate to call the API
		return aCatFact;
	}

}
