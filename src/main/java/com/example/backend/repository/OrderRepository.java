package com.example.backend.repository;

import com.example.backend.model.ShawarmaOrder;
import com.example.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface OrderRepository  extends CrudRepository<ShawarmaOrder, Long> {
//    ShawarmaOrder save(ShawarmaOrder order);
    List<ShawarmaOrder> findByDeliveryZip(String deliveryZip);
    List<ShawarmaOrder> findOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
    List<ShawarmaOrder> findByDeliveryCityOrderByDeliveryCity(String  deliveryCity);

    //List<ShawarmaOrder> findByUserOrderByPlacedAtDesс(User user, Pageable pageable);
    List<ShawarmaOrder> findByUserOrderByPlacedAtDesc (User user, Pageable pageable);

//    @Query("Order o where o.deliveryCity=’Seattle’")
//    List<ShawarmaOrder> readOrdersDeliveredInSeattle();
}
