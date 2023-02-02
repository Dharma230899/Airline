package com.BrownField.pss.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.BrownField.pss.serviceimpl.SearchSerivceImpl;
import com.BrownField.pss.vo.Flight;
import com.BrownField.pss.vo.SearchForm;


@Controller
public class SearchFlightController {

	
	@RequestMapping(value="/Search", method=RequestMethod.GET)
	public String getSearchPage( Model model) {
		//model.addAttribute("searchForm", new SearchForm());
		
		SearchForm searchForm = new SearchForm();
		//searchForm.setTrip_type("one way");
		model.addAttribute("searchForm",searchForm);
	
		List<Integer> listNo = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        model.addAttribute("list", listNo);
		List<Integer> listProfession = Arrays.asList(1,2,3,4,5,6,7,8,9);
        model.addAttribute("listAdults", listProfession);
        List<String> airports = Arrays.asList("Agartala", "Agra", "Ahmedabad", "Aizawl", "Amritsar", "Aurangabad", "Bagdogra", "Bareilly", "Belagavi", "Bangalore", "Bhopal", "Bhubaneswar", "Chandigarh", "Chennai", "Coimbatore", "Darbhanga", "Dehradun", "Delhi", "Deoghar", "Dibrugarh", "Dimapur", "Durgapur", "Gaya", "Goa", "Gorakhpur", "Guwahati", "Gwalior", "Hubli", "Hyderabad", "Imphal", "Indore", "Itanagar", "Jabalpur", "Jaipur", "Jammu", "Jodhpur", "Jorhat", "Kadapa", "Kannur", "Kanpur", "Kochi", "Kolhapur", "Kolkatha", "Kozhikode", "Kurnool", "Leh", "Lucknow", "Madurai", "Mangaluru", "Mumbai", "Mysuru", "Nagpur", "North Goa", "Pantnagar", "Patna", "Port-Blair", "Prayagraj", "Pune", "Raipur", "Rajahmundry", "Rajkot", "Ranchi", "Shillong", "Shirdi", "Silchar", "Srinagar", "Surat", "Thiruvananthapuram", "Tiruchirappalli", "Tirupati", "Tuticorin", "Udaipur", "Vadodara", "Varanasi", "Vijayawada", "Visakhapatnam");
        model.addAttribute("airports", airports);
        
        return "Search";
	}
	
	@RequestMapping(value="/getFlights", method=RequestMethod.POST)
	public String getFlights(@ModelAttribute(name="Flight") Flight flight,Model model,SearchForm searchform) {
		
		SearchSerivceImpl search = new SearchSerivceImpl();
		List<Flight> flights =new ArrayList<Flight>();
		System.out.println(searchform);
		flights= search.getAllFlights(searchform);
		model.addAttribute("flights",flights);
		return "SelectDepFlights";
	}
	
	
	
	
	
}
