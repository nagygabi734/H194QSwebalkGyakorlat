package hu.h194qs.springbootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping
	public String index() {
		return "Hello Spring Boot web world!";
	}

	@GetMapping("/{name}")
	public String H194QSHello(@PathVariable("name") String name) {
		return ("Hello, " + name);
	}

	@GetMapping("/add/{a}/{b}")
	public String add(@PathVariable("a") int a, @PathVariable("b") int b) {
		int amount = a + b;
		return (a + "+" + b + "=" + amount);
	}

}