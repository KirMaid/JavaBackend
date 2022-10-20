package com.example.backend.service;

import com.example.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderAdminService {
    OrderRepository orderRepo;

    //@PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders(){
        orderRepo.deleteAll();
    }

//    @PostAuthorize("hasRole('ADMIN') || " +
//            "returnObject.user.username == authentication.name")
//    public ShawarmaOrder getOrder(long id) {
//        return orderRepo.findById(id);
//    }
}
