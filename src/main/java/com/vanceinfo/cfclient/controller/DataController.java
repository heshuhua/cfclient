package com.vanceinfo.cfclient.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vanceinfo.cfclient.model.DAO;
import com.vanceinfo.cfclient.model.Gender;
import com.vanceinfo.cfclient.model.PaymentMethod;
import com.vanceinfo.cfclient.model.Transaction;
import com.vanceinfo.cfclient.service.SenderService;



@Controller
public class DataController {
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	private void setModelBeans(Model model) {
        model.addAttribute("product", DAO.loadProduct());
        model.addAttribute("productList", DAO.loadAllProducts());
        model.addAttribute("html", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        model.addAttribute("customerName", "Dr. Julius Erwing");
        model.addAttribute("customer", DAO.loadCustomer());
        model.addAttribute("transaction", DAO.loadTransaction(null));
        model.addAttribute("lastTransaction", DAO.loadTransaction(null));
        model.addAttribute("customerList", DAO.loadAllCustomers());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("paymentMethods", PaymentMethod.values());
    }
	
	 @RequestMapping(value={"/","index.html"})
	    public String index() {
	        return "index.html";
	  }
	 
	 @RequestMapping("/trans.html")
	    public String data(Model model) {
		 setModelBeans(model);
		 
	     return "trans.html";
	  }
	 
	 @RequestMapping(value="/trans.html",method=RequestMethod.POST)
	 public String postData(Model model,Transaction trans,HttpServletRequest request) {
		 
		 int customerId =  Integer.parseInt(request.getParameter("customerid"));
		 String location = trans.getLocation();
		 
		 System.out.println("--"+request.getParameter("customerid"));
		 System.out.println("--"+trans.getAmount());
	     Transaction transaction = new Transaction(customerId, location, trans.getAmount());
		 
	     amqpTemplate.convertAndSend("messages", transaction.getCustomerId()+transaction.getLocation());
		 SenderService.sendMsg(transaction);
		 setModelBeans(model);
		 model.addAttribute("lastTransaction",transaction);
		 
		 //String message = (String)amqpTemplate.receiveAndConvert("messages");
		 //model.addAttribute("message",message);
		 return "trans.html";
	  }
	    

}
