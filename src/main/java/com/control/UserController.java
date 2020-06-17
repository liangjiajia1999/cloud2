package com.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.pojo.User;
import com.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserService userService;
	
	
	//登录
    @RequestMapping("/login.do")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model model){
        //1.调用service，查询得到结果，自动补全返回值 Ctrl+Alt+V
    	User user = new User();
		user.setUserName(username);
		user.setPassword(password);
        //2.判断
        if(userService.login(user) != null){
        		model.addAttribute("username",username);
        		System.out.println("密码正确");
                return "index";
            }else{
            	model.addAttribute("error","账号或密码错误");
                System.out.println("密码错误，登陆失败！");
                return "/login";
            }
    }
    
    
    //注册
    @RequestMapping("register.do")
    public String register(@RequestParam("username") String username,@RequestParam("password") String password) {
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		userService.register(user);
    	return "login";
    	
    }
        
    }

		
		

