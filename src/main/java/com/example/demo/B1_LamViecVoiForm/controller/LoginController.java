package com.example.demo.B1_LamViecVoiForm.controller;

import com.example.demo.B1_LamViecVoiForm.request.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
// =>MVC
public class LoginController {
    // Tat ca cac ham trong controller => view => Luon luon return ra String

    @GetMapping("/login")
    public String hienThiFormLogin(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login-form";
    }

    //    @PostMapping("/home")
//    public String ketQua(@RequestParam("uname") String username,
//                         @RequestParam("psw") String password, Model model) {
//
//        model.addAttribute("s1", username);
//        model.addAttribute("s2", password);
//        return "ket-qua";
//    }
    @PostMapping("/home")
    public String ketQua(@Valid LoginRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login-form";
        }
        model.addAttribute("s1", request.getUsername());
        model.addAttribute("s2", request.getPassword());
        return "ket-qua";
    }
}
