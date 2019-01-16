package main.java.servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import main.java.domains.Good;
import main.java.domains.MyBasket;
import main.java.domains.Order;
import main.java.domains.User;
import main.java.services.OrderService;
import main.java.services.UserService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/makeOrder.do", method=RequestMethod.POST)
	public String makeOrder(HttpServletRequest request,
			@RequestParam(value = "adress") String adr,
			@RequestParam(value = "cardNumber") String card,
			Model model) {
		HttpSession session = request.getSession(false);
		List<Good> list = (List<Good>)session.getAttribute("myGoods");
		int totalPrice = 0;
		for(Good good : list) {
			totalPrice += good.getPrice();
		}
		
		StringBuilder g = new StringBuilder();
		for(int i = 0; i < list.size(); i++) {
			if(i == 0) g.append(list.get(i).getName());
			else g.append(", " + list.get(i).getName());
		}
		String things = g.toString();
		String logn = session.getAttribute("login").toString();
		
		User userId = userService.isLoginUsed(logn);
		Order order = new Order(userId, adr, card, things);
		order.setTotal(totalPrice);
		int id = orderService.create(order);
		
		model.addAttribute("success", "Номер вашего заказа: " + id);
		session.setAttribute("myGoods", null);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/addToBasket.do", method=RequestMethod.POST)
	public HttpEntity<String> addToBasket(HttpServletRequest request, Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "price") int price) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("login") != null) {
			Good myGood = new Good(name, price);
			MyBasket.basket.add(myGood);
			session.setAttribute("myGoods", MyBasket.basket.getList());
			session.setAttribute("total", MyBasket.basket.getTotal());
			//model.addAttribute("success", "Товар добавлен в корзину!");
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
			HttpEntity<String> result = new HttpEntity<String>("Товар добавлен в корзину!", headers);
			return result;
		} else {
			//model.addAttribute("error", "Произведите вход!");
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
			HttpEntity<String> result = new HttpEntity<String>("Произведите вход!", headers);
			return result;
		}
	}
	
	@RequestMapping(value="/removeFromBasket.do", method=RequestMethod.POST)
	public String removeToBasket(HttpServletRequest request, Model model,
			@RequestParam(value = "position") int position) {
        MyBasket.basket.remove(position);
        HttpSession session = request.getSession(false);
        if(session != null) {
        	session.setAttribute("myGoods", MyBasket.basket.getList());
        	session.setAttribute("total", MyBasket.basket.getTotal());
        }
        return "redirect:website/basket.jsp";
	}
}
