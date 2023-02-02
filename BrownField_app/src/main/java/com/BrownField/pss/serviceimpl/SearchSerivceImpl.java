package com.BrownField.pss.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.BrownField.pss.service.SearchService;
import com.BrownField.pss.vo.Fare;
import com.BrownField.pss.vo.Flight;
import com.BrownField.pss.vo.Inventory;
import com.BrownField.pss.vo.SearchForm;

@Service
public class SearchSerivceImpl implements SearchService{

	@Override
	public List<Flight> getAllFlights(SearchForm searchform) {
		RestTemplate restTemplate = new RestTemplate();
		
		
		String routesApiPath="https://searchmicroservice-devenv.azurewebsites.net//search/availableFlights";
		ResponseEntity<List<Flight>> result;
		searchform.setNumberOfPeople(getTotalPassengers(Integer.parseInt(searchform.getAdults()),Integer.parseInt(searchform.getChild()),Integer.parseInt(searchform.getInfants())));
		//searchform.setNumberOfPeople(getTotalPassengers(2,5,6));

		HttpEntity<SearchForm> request = new HttpEntity<>(searchform);
		
		System.out.println(request);
		List<Flight> flights=null;
            // Make call to Routes API using restTemplate.exchange(url, httpMethod, requestEntity, responseType)
            try {
				result = restTemplate.exchange(routesApiPath,
				        HttpMethod.POST,
				        request,
				        new ParameterizedTypeReference<List<Flight>>() {
				        });
				if(HttpStatus.OK.equals(result.getStatusCode())) {
		        	flights=result.getBody();	
		        	return flights;
		        }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
            return flights;
        
        
        
        
//        if(HttpStatus.OK.equals(result.getStatusCode())) {
//        	List<Flight> flights=result.getBody();	
//    		return flights;
//        }
//        else {
//        	return List.of();
//        }
		
	}
	private int getTotalPassengers(int adults,int child,int infants) {
		return adults+child+infants;
	}
	
	private List<Flight> getFlightsList(){
		List<Flight> flightsList= new ArrayList<Flight>();
		Flight flight1= new Flight();
		flight1.setArrivalDate("2023-01-25");
		flight1.setArrivalTime("00:30:00");
		flight1.setDepartureDate("2023-01-24");
		flight1.setDepartureTime("21:00:00");
		flight1.setDestination("Delhi");
		flight1.setFlightId(12);
		flight1.setFlightName("6e MN65");
		flight1.setOrigin("Mumbai");
		
		Fare fare1= new Fare();
		fare1.setId(1);
		fare1.setFarePrice(5666);
		
		Inventory invent1= new Inventory();
		invent1.setId(1);
		invent1.setAvailableSeats(23);
		
		flight1.setFarePrice("2550");
		flight1.setInventory(invent1);
		
		flightsList.add(flight1);
		return flightsList;
		
		
	}

	

}
