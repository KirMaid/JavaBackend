package com.example.backend.controller;

import com.example.backend.repository.OrderRepository;
import com.example.backend.model.ShawarmaOrder;
import com.example.backend.model.User;
import com.example.backend.web.OrderProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("shawarmaOrder")
//@ConfigurationProperties(prefix = "shawarma.orders")
public class OrderController {

    private int pageSize = 20;

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }
    private OrderRepository orderRepo;
    private OrderProps props;
    public OrderController(OrderRepository orderRepo, OrderProps props){
        this.orderRepo = orderRepo;
        this.props = props;
    }

    @GetMapping("/current")
    public String currentOrderForm(){
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid ShawarmaOrder order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user){
        if (errors.hasErrors()){
            return "orderForm";
        }

        order.setUser(user);
        orderRepo.save(order);
        //log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model){
        Pageable pageable = PageRequest.of(0,pageSize);
        model.addAttribute("orders",orderRepo.findByUserOrderByPlacedAtDesc(user,pageable));
        return "orderList";
    }



}
