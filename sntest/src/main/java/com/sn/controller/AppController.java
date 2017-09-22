package com.sn.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.sn.entity.Order;
import com.sn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.entity.Product;
import com.sn.entity.User;
import com.sn.service.ProductService;
import com.sn.service.UserService;

@Controller
public class AppController {
	@Autowired
	public UserService userService;

	@Autowired
	public ProductService productService;

	@Resource
	public OrderService orderService;
	
	@RequestMapping("/login")
	public String login(User user,HttpSession session) {
		User obj=userService.login(user);
		if(obj!=null) {
			session.setAttribute("user", obj);
			return "redirect:plist";
		}
		return "login";
	}
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/plist" }, method = RequestMethod.GET)
	public String listProducts(ModelMap model,HttpSession session) {
		User user=(User)session.getAttribute("user");
		if(user==null){
			return "redirect:login";
		}
		List<Product> list = productService.getList();
		model.addAttribute("plist", list);
		model.addAttribute("loggedinuser", (User)session.getAttribute("user"));
		return "plist";
	}

	@RequestMapping(value = { "/createOrder-{pId}" }, method = RequestMethod.GET)
	public String createOrder(@PathVariable String pId, ModelMap model,HttpSession session) {
		User user=(User)session.getAttribute("user");;
		if(user==null){
			return "redirect:login";
		}
		Product product = productService.findById(Integer.parseInt(pId));
		if(product==null){
			model.addAttribute("result","下单失败，返回<a href=\"/plist\">商品列表</a>");
			return "error";
		}
		Order order=new Order();
		order.setCreateTime(new Date(System.currentTimeMillis()));
		order.setProductId(product.getId());
		order.setProductName(product.getProductName());
		order.setRealName(user.getRealName());
		order.setUserId(user.getId());
		order.setUserName(user.getUserName());

		orderService.save(order);
		return "redirect:olist";
	}

	@RequestMapping("/olist")
	public String orderList(ModelMap model,HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
			return "redirect:login";
		}
		List<Order> list = orderService.getList(user.getId());
		model.addAttribute("olist", list);
		model.addAttribute("loggedinuser", (User)session.getAttribute("user"));
		return "olist";
	}

	@RequestMapping(value = { "/deleteOrder-{oId}" }, method = RequestMethod.GET)
	public String deleteOrder(@PathVariable String oId, ModelMap model,HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
			return "redirect:login";
		}
		Order order=orderService.findByIdAndUserId(Integer.parseInt(oId),user.getId());
		if(order==null){
			model.addAttribute("result","订单不存在，返回<a href=\"/olist\">订单列表</a>");
			return "error";
		}
		int result=orderService.delete(Integer.parseInt(oId));
		if(result<=0){
			model.addAttribute("result","删除订单失败，返回<a href=\"/olist\">订单列表</a>");
			return "error";
		}
		return "redirect:olist";
	}

}
