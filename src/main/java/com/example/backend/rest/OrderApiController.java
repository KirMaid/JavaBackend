package com.example.backend.rest;

import com.example.backend.repository.OrderRepository;
import com.example.backend.model.ShawarmaOrder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders",produces = "application/json")
@CrossOrigin(origins = "http:/localhost:8080")
public class OrderApiController {
    private OrderRepository orderRepository;

    @PutMapping(path = "/{orderId}",consumes = "application/json")
    public ShawarmaOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody ShawarmaOrder patch){
        ShawarmaOrder order = orderRepository.findById(orderId).get();

        if (patch.getDeliveryName() != null){
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        try{
            orderRepository.deleteById(orderId);
        }catch (EmptyResultDataAccessException e){}

    }
}
