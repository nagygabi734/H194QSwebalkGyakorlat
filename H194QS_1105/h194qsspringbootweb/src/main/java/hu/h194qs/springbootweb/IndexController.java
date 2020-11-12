package hu.h194qs.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/kezdolap.html")
	public String getKezdolap() {
		return "kezdolap";
	}

	@RequestMapping("/adatbazis.html")
	public String getAdatbazisrendszerek() {
		return "adatbazis";
	}

	@RequestMapping("/html5.html")
	public String getHtml5() {
		return "html5";
	}
	@RequestMapping("/prezentacio.html")
	public String getPrezentacio() {
		return "prezentacio";
	}
}
