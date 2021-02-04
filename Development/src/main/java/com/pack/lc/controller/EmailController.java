package com.pack.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.lc.api.EmailDTO;

@Controller
public class EmailController {

	//cookievalue cookileri okumak icin springin bir methodu kolaylık olması için
	// cooki icin method icine @CookieValue("LCApp.userName") String userName, ekle
	@RequestMapping("/sendEmail")
	public String sendEmai(Model model) {
		//	model.addAttribute("userName",userName);
		model.addAttribute("emailDTO",new EmailDTO());
		return "send-email-page";
	}
	
	
	//session için ,HttpSession session,Model model
	@RequestMapping("/process-email")
	public String processEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		//Session u sildik
		//String userName =(String) session.getAttribute("userName");
		//String newUserName = "Mr"+userName;
		
		//ilk modele bakçak username için sonra sessiona bakıcak.
		//model.addAttribute("userName",newUserName);
		return "process-email-page";
	}
}
