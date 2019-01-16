package main.java.servlets;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.domains.User;
import main.java.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@RequestMapping(value = "/enter.do", method=RequestMethod.POST)
	public String enter(Model model, @RequestParam(value = "login") String login,
									@RequestParam(value = "password") String pass,
									@RequestParam(value = "enter", required=false) String entr,
									@RequestParam(value = "registration", required=false) String registration,
									HttpServletRequest request) {
		if(registration != null) {
			User user = new User(login, pass);
			if(userService.isLoginUsed(user.getLogin()) == null) {
				userService.add(user);
				model.addAttribute("success", "Регистрация прошла успешно!");
		    	return "success";
			} else {
				model.addAttribute("error", "Пользователь с таким логином уже существует!");
			}
		} else if(entr != null) {
			boolean b = userService.findByLoginAndPassword(login, pass);
			if(b) {
				HttpSession session = request.getSession(true);
				session.setAttribute("login", login);
				model.addAttribute("success", "Вход произведен!");
				return "success";
			} else {
				model.addAttribute("error", "Такого пользователя не существует!");
			}
		}
		
		return "error";
	}
	
	@RequestMapping(value = "/logout.do", method=RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.setAttribute("login", null);
			return "redirect:website/main.jsp";
		}
		model.addAttribute("error", "Сессии не существует!");
		return "error";
	}
}
