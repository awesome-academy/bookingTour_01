package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.controller.admin.BaseController;
import app.helper.Constants;
import app.model.Tours;
import app.service.ToursService;

@RequestMapping("tours")
@Controller
public class ToursController extends BaseController {
	@Autowired
	private ToursService toursService;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String home() {
		return "redirect:/tours/index/page/1";
	}

	@RequestMapping(value = { "/index/page/{pageNumber}" }, method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(required = false, name = "search") String search,
			@PathVariable int pageNumber, Model model) {

		int pageSize = Constants.PAGESIZE;

		ModelAndView mov = new ModelAndView("tours");

		PagedListHolder<?> pages = new PagedListHolder<>();

		long count = toursService.count(search);

		long end = setEndPagination(count);

		setPaginationModelObject(pageNumber, end, model);

		if (pageNumber == 1) {
			pages = new PagedListHolder<>(toursService.loadTours(search, null, null));
		} else if (pageNumber <= end && pageNumber > 0) {
			pages = new PagedListHolder<>(toursService.loadTours(search, (pageNumber - 1) * pageSize, pageSize));
		}

		model.addAttribute("page", pages);

		return mov;
	}

	@RequestMapping(value = { "/{idTour}" }, method = RequestMethod.GET)
	public ModelAndView indexOfTourObject(@PathVariable int idTour, RedirectAttributes redirectAttributes) {
		ModelAndView mov = new ModelAndView("/tour-place");
		Tours tour = toursService.findById(idTour);

		if (tour == null) {
			redirectAttributes.addFlashAttribute("message", getProperties().getProperty("error.findTour"));
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return mov;
		}

		mov.addObject("tour", tour);

		return mov;
	}
}