package app.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.model.Car;
import app.service.CarService;


@RequestMapping("admin/cars/")
@Controller
public class CarController {

	@Autowired
	private CarService carService;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView home() {
	    List<Car> cars = carService.loadCars();
	    ModelAndView mav = new ModelAndView("admin/cars/index");
	    mav.addObject("cars", cars);
	    return mav;
	}
	
	@RequestMapping(value = "/new")
	public String newCar(Map<String, Object> model) {
		Car car = new Car();
		model.put("car", car);
		return "admin/cars/add";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCar(@ModelAttribute("car") Car car) {
		System.err.println("-----------------------------------"+car.getId()+"-------------");
		carService.saveOrUpdate(car);
		return "redirect:/admin/cars/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam int id) {
	    ModelAndView mav = new ModelAndView("admin/cars/edit");
	    Car car = carService.findById(id);
	    mav.addObject("car", car);
	 
	    return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam int id) {
	    carService.deleteCar(id);
	    return "redirect:/admin/cars/";       
	}
}
