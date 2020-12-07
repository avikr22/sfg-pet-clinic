package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	// No need to use Autowired annotation as Spring will automatically autowire 
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}


	@RequestMapping({"","/", "/index", "/index.html","/find"})
	public String listVets(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
}
