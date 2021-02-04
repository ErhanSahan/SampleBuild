package com.pack.lc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pack.lc.api.UserInfoDTO;


//method icine SessionStatus status
//ekleyip status.setComplate yaparsan session silinir.
// silmezsek öteki classlardan bile cağirabiliriz methoda

// Model model / model.setAttribute('asd',obje) sorna aşadakini çağirabiliriz.
//@SessionAttribute('asd') String name gibi
// model.getAttribute ile. 
//Methoda HttpSession session ekleyip set get ilede classlar arasi alabiliyorz.
//session.getAttribute

//Http request method icinde
//HttpSession session = request.getSession;
//session.setAttribute("adress",obje);

@Controller
@SessionAttributes("userInfoDTO")//model attributesini ekleyip burdan veri çekiyoruz ama zorlukları vamrış bug yapan?
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage(Model model) {
		
		model.addAttribute("userInfoDTO",new UserInfoDTO());
		//bu cookieler eskiden kalma username yüklüyor.
		// bunu ekle ,HttpServletRequest request
/*		Cookie [] cookies = request.getCookies();
		
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("LCApp.userName")) {
				String userName = cookie.getValue();
				userInfoDTO.setUserName(userName);
			}
		}
*/		
		return "home-page";
	}
	
	//cookiler icin bunu ekle HttpServletResponse response
	// session icin ,HttpServletRequest request
	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid@ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO,BindingResult result) {
		//ana ekrandan gelen user adı boşsa messageyi returnla @Validle
		
		if(result.hasErrors()) {
			return "home-page";
		}
		
		//HttpSession session = request.getSession();
		//session.setAttribute("userName", userInfoDTO.getUserName());
		//120dk sessionu silmiyor
		//session.setMaxInactiveInterval(120);
		//*************************************************
		//Cookie yazip sayfadaki veriyi aktarcaz
		// 5dklık cookie
		//Cookie cookie = new Cookie("LCApp.userName",userInfoDTO.getUserName());
		//cookie.setMaxAge(60*5);
		// cookieyi responseye attık
		//response.addCookie(cookie);
		
		//1 servis yazıp frinedmi enemymi olduğunu sölicek.
		
		return "result-page";
	}
	
}
