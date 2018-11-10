package com.conhj.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.conhj.api.po.UserEntity;
import com.conhj.api.service.IUserService;
import com.conhj.provider.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Reference(version="1.0.0")
    private IUserService userServiceimpl;

    @RequestMapping(value = "/show")
    public void show(HttpServletResponse resp) throws IOException {
//        UserServiceImpl userService2=new UserServiceImpl();
        List<UserEntity> list =userServiceimpl.queryAll();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String ss = JSON.toJSONString(list);
        System.out.println(ss);
        out.print(ss);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/del/{id}")
    public void del(HttpServletRequest req, HttpServletResponse resp, @PathVariable String id) {
        UserEntity user = new UserEntity();
        user.setId(Long.parseLong(id));
        if (userServiceimpl.delUser(user)) {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            try {
                PrintWriter out = resp.getWriter();
                out.print("ok");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/queryOne/{id}")
    public void queryOne(HttpServletRequest req, HttpServletResponse resp, @PathVariable String id) throws IOException {
        UserEntity user1 = new UserEntity();
        user1.setId(Long.parseLong(id));
        UserEntity user2 = userServiceimpl.queryOne(user1);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String ss = JSON.toJSONString(user2);
        System.out.println(ss);
        out.print(ss);
        out.flush();
        out.close();
    }

    @PostMapping(value = "/add")
    public String add(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam("action") String action,
                      @RequestParam("id") String id,
                      HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserEntity user = null;
        switch (action) {
            case "add":
                user = new UserEntity();
                user.setUsername(req.getParameter("username"));
                user.setPassword(req.getParameter("password"));
                userServiceimpl.addUser(user);
//                if (service.addUser(user)) {
//                    RequestDispatcher dispatcher = req.getRequestDispatcher("/index.html");
//                    try {
//                        dispatcher.forward(req, resp);
//                    } catch (ServletException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
                break;

            case "update":
                user = new UserEntity();
                user.setId(Long.parseLong(req.getParameter("id")));
                user.setUsername(req.getParameter("username"));
                user.setPassword(req.getParameter("password"));
                userServiceimpl.updateUser(user);
//                if (service.updateUser(user)) {
//                    RequestDispatcher dispatcher = req.getRequestDispatcher("/index.html");
//                    try {
//                        dispatcher.forward(req, resp);
//                    } catch (ServletException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }

                break;

        }
        // return "index";
        // return "forward:/index";
        return "redirect:/index.html";

    }
}
