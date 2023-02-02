package com.BrownField.pss.service;

import java.util.List;

import com.BrownField.pss.vo.Flight;
import com.BrownField.pss.vo.SearchForm;



public interface SearchService {

	

	List<Flight> getAllFlights(SearchForm searchform);
	
}
