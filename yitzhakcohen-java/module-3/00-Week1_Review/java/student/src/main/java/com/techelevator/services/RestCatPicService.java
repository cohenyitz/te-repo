package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatPic;

@Component
public class RestCatPicService implements CatPicService {

	private String CAT_PIC_API_URL = "https://random-cat-image.herokuapp.com/";	//URL to return a random cat picture
	private RestTemplate restTemplate = new RestTemplate();	
	
	
	@Override
	public CatPic getPic(){
		
		CatPic aCatPic = restTemplate.getForObject(CAT_PIC_API_URL, CatPic.class);
		
		// We know that the API at the url: http://aws.random.cat/meow
		//	will return a random cat picture
		// Use RestTemplate to call the API
		return aCatPic;
	}

}	
