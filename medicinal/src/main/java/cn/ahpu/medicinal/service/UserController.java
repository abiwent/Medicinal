package cn.ahpu.medicinal.service;

import cn.ahpu.medicinal.impl.UserDaoImpl;
import cn.ahpu.medicinal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDaoImpl userDao;

    @RequestMapping("/login")
    public String showLogin(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "/ahpu";
    }

    @RequestMapping("/tologin")
    public String toLogin(User user1, HttpServletRequest request, Model model) {
        User user = userDao.findUserByUsername(user1.getUsername());
        if (user != null && user1.getPassword() != null && user1.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("user", user);
            return "redirect:/medicinal/success";
        } else {
            model.addAttribute("msg", "账号或密码错误!");
            return "page/login";
        }
    }

    @RequestMapping("/dochangepwd")
    public String toChangePwd(){
        return "page/password-change";
    }

    @RequestMapping("/tochangepwd")
    public String doChangePwd(String cpwd,String npwd,String cnpwd,HttpServletRequest request,Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("进入该方法");
        User user = (User) request.getSession().getAttribute("user");
        if (user.getPassword().equals(cpwd)){
            System.out.println("旧密码正确");
            if (npwd!=null&&cnpwd!=null){
                System.out.println("密码不为空");
                if (npwd.equals(cnpwd)){
                    System.out.println("确认密码正确");
                    user.setPassword(npwd);
                    userDao.upUser(user);
                    request.getSession().removeAttribute("user");
                    return "/ahpu";
                }else {
                    System.out.println("确认密码不一致！");
                    model.addAttribute("msg","确认密码不一致！");
                }

            }else {
                System.out.println("密码不能为空！");
                model.addAttribute("msg","密码不能为空！");
            }
        }else {
            System.out.println("旧密码错误！");
            model.addAttribute("msg","旧密码错误！");
        }
        return "page/password-change";
    }


}
