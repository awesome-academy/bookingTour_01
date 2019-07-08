package app.controller.admin;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.helper.Constants;
import app.model.Car;
import app.model.Places;
import app.model.Tours;
import app.service.CarService;
import app.service.PlacesService;
import app.service.ToursService;

@RequestMapping("admin/tours/")
@Controller
public class TourController extends BaseController {
	@Autowired
	private ToursService toursService;
	@Autowired
	private PlacesService placesService;
	@Autowired
	private CarService carService;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String home() {
		return "redirect:/admin/tours/index/page/1";
	}

	@RequestMapping(value = { "/index/page/{pageNumber}" }, method = RequestMethod.GET)
	public ModelAndView index(@PathVariable int pageNumber, Model model) {

		int pageSize = Constants.PAGESIZE;

		ModelAndView mov = new ModelAndView("admin/tours/index");

		PagedListHolder<?> pages = new PagedListHolder<>();

		long count = toursService.count(null);
		long end = setEndPagination(count);

		setPaginationModelObject(pageNumber, end, model);

		if (pageNumber == 1) {
			pages = new PagedListHolder<>(toursService.loadTours(null, null, null));
		} else if (pageNumber <= end && pageNumber > 0) {
			pages = new PagedListHolder<>(toursService.loadTours(null, (pageNumber - 1) * pageSize, pageSize));
		}

		model.addAttribute("page", pages);
		return mov;
	}

	@RequestMapping(value = "/new")
	public ModelAndView newTourDetails(Map<String, Object> model) {
		List<Places> places = placesService.loadPlaces();
		ModelAndView mav = new ModelAndView("admin/tours/add");
		mav.addObject("places", places);
		Tours tour = new Tours();
		model.put("tour", tour);
		List<Car> cars = carService.loadAllCars();
		mav.addObject("cars", cars);
		return mav;
	}

	@PostMapping("/create")
	public String saveTourDetails(@ModelAttribute("tour") Tours tour, BindingResult result, SessionStatus status,
			RedirectAttributes redirectAttributes) {

		status.setComplete();
		toursService.saveOrUpdate(tour);
		redirectAttributes.addFlashAttribute("message", getProperties().getProperty("sucess.saveTours"));
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/admin/tours/new/";
	}

	@RequestMapping("/edit")
	public ModelAndView editTourDetails(@RequestParam int id, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("admin/tours/edit");
		Tours tour = toursService.findById(id);

		if (tour == null) {
			redirectAttributes.addFlashAttribute("message", getProperties().getProperty("error.findTours"));
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return mav;
		}
		List<Places> places = placesService.loadPlaces();
		mav.addObject("places", places);
		mav.addObject("tour", tour);
		List<Car> cars = carService.loadAllCars();
		mav.addObject("cars", cars);
		return mav;
	}

	@GetMapping("/delete{id}")
	public String deleteCustomerForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
		toursService.deleteTours(id);
		redirectAttributes.addFlashAttribute("message", getProperties().getProperty("sucess.deleteTours"));
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/admin/tours/";
	}
}