package app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.model.Tours;
import app.service.ToursService;


//@RequestMapping("/")
@Controller
public class ToursController {

//	@Autowired
//	private CarService carService;
//	
	@Autowired
	private ToursService toursService;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView home() {
		List<Tours> listTours= toursService.listTours();
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("toursList", listTours);
	    return mav;
	}


	
//	@RequestMapping(value = "/new")
//	public String newCar(Map<String, Object> model) {
//		Car car = new Car();
//		model.put("car", car);
//		return "admin/cars/add";
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String saveCar(@ModelAttribute("car") Car car) {
//		carService.saveOrUpdate(car);
//		return "redirect:/admin/cars/";
//	}
}
