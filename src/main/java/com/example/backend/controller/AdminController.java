package com.example.backend.controller;

import com.example.backend.service.OrderAdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private OrderAdminService adminService;

    public AdminController(OrderAdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/deleteOrders")
    public String deleteAllOrders(){
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
}
