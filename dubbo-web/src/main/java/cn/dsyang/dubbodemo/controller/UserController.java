package cn.dsyang.dubbodemo.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.dsyang.dubbodemo.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;
    @RequestMapping("/showName")
    @ResponseBody
    public String showName(){
        return userService.getName();
    }
}