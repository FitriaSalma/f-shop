package fitria.salma.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String loadAdminPage() {
		return "admin/dashboard.html";
	}
}
