package main.java.servlets;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.domains.Good;
import main.java.services.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "/shop.do", method=RequestMethod.GET)
	public String getTovars(Model model) {
		List<String> names = new ArrayList<String>(), 
				descriptions = new ArrayList<String>(),
				prices = new ArrayList<String>(),
				photos = new ArrayList<String>();
		
		List<Good> list = shopService.getAllTovars();
		
		for(int i = 0; i < list.size(); i++) {
			Good g = list.get(i);
			names.add(g.getName());
			prices.add(String.valueOf(g.getPrice()));
			descriptions.add(g.getDescription());
			photos.add(g.getPhoto());
		}
		
		model.addAttribute("names", names);
		model.addAttribute("prices", prices);
		model.addAttribute("descriptions", descriptions);
		model.addAttribute("photos", photos);
		return "forward:/website/shop.jsp";
	}
}
