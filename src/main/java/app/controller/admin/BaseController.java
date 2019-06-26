package app.controller.admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.ui.Model;

public class BaseController {
	private static final Logger logger = Logger.getLogger(BaseController.class);

	public Properties getProperties() {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream("src/main/resources/messages.properties")) {
			prop.load(input);
			return prop;
		} catch (IOException ex) {
			logger.error(ex);
			return null;
		}
	}
	
	public PagedListHolder<?> setPagedListHolder(int pagesize,int pageNumber,List<?> listObj,PagedListHolder<?> pages){
		if (pages == null) {
			pages = new PagedListHolder<>(listObj);
			pages.setPageSize(pagesize);
		} else {
			final int gotoPage = pageNumber - 1;
			if (gotoPage <= pages.getPageCount() && gotoPage >= 0)
				pages.setPage(gotoPage);

		}
		
		return pages;
	}

	public Model setModelPagination(int pagesize, int pageNumber, List<?> listObj, PagedListHolder<?> pages,
			Model model) {

		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - listObj.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("list", pages);
		
		return model;
	}
}
