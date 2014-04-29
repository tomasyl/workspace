package com.lx.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lx.common.Constants;
import com.lx.web.form.LoginForm;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String login(Model model) {
		if (!model.containsAttribute(Constants.COMMAND)) {
			model.addAttribute(Constants.COMMAND, new LoginForm());
		}
		setCommonData(model);
		return "login";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String login(Model model,
			@ModelAttribute("command") @Valid LoginForm command,
			BindingResult result,HttpServletRequest request) {

		// 如果有验证错误 返回到form页面
		if (result.hasErrors()) {
			// model.addAttribute(Constants.COMMAND, command);
			return "";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("login", true);
		System.out.println(model);
		return "index";
	}

	private void setCommonData(Model model) {
		// 设置通用属性
	}
	
	@RequestMapping(value = "/accessDenied", method = { RequestMethod.GET })
	public String accessDenied(){
		return "accessDenied";
	}
	
	/*@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}*/
}
