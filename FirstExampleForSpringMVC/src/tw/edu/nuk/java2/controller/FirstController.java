package tw.edu.nuk.java2.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import tw.edu.nuk.java2.model.Product;

@Controller
public class FirstController {
	
	@RequestMapping("/hello/{member}")
	public String doHello(@PathVariable("member") String MemberName, Model model) {
		
		model.addAttribute("member", MemberName);
		
		return "HelloView";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public String showSuccess(@ModelAttribute("product") Product product, Model model) {
		return "ShowProductResult";
	}
	
	
	@RequestMapping(value="/welcome")
	public String doWelcome(@RequestParam(value="member", defaultValue="User") String MemberName, Model model) {
		
		model.addAttribute("member", MemberName);
		
		return "WelcomeView";
	}
	
	@RequestMapping("/news")
	public String doRedirect(@RequestParam(value="url", defaultValue="http://www.yahoo.com.tw") String url) {
		
		return "redirect:"+url;
	}
	
	@RequestMapping(value={"/Hi/{member}","/Aloha/{member}"})
	public String doMultiURL(@PathVariable("member") String MemberName, Model model, HttpServletRequest request) {
		
		model.addAttribute("member", MemberName);
		model.addAttribute("uri", request.getRequestURI());
		model.addAttribute("url", request.getRequestURL());
		
		return "MultiValuesView";
	}
	
	@RequestMapping("/product")
	public String showProduct(Model model) {
		
		Product product = new Product();
		
		product.setpNo(1);
		product.setName("Head First Servlet");
		product.setDescription("The introduction to servlet");
		model.addAttribute("product", product);
		
		return "ProductView";
	}
	
	@RequestMapping("/resource")
	public void showResourceView() {
		
	}
	
	@RequestMapping("/WelcomeRedirect") 
	public String doWelcomeRedirect() {
		
		return "welcomeRedirect";	
	}
	
	@ModelAttribute("categoryList")
	public List<String> populateCatetory() {
		List<String> categories = new ArrayList<String>();
		
		categories.add("Book");
		categories.add("CD");
		categories.add("DVD");
	
		return categories;
	}
	
}
