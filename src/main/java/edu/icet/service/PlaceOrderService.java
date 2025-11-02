package edu.icet.service;

import edu.icet.model.dto.PlaceOrder;
import edu.icet.model.entity.PlaceOrderEntity;
import edu.icet.repository.PlaceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceOrderService {

    @Autowired
    private PlaceOrderRepository placeOrderRepository;

    public List<PlaceOrder> getAllOrders() {
        List<PlaceOrderEntity> allEntities = placeOrderRepository.findAll();
        List<PlaceOrder> orderList = new ArrayList<>();

        for (PlaceOrderEntity entity : allEntities) {
            orderList.add(new PlaceOrder(
                    entity.getId(),
                    entity.getDate(),
                    entity.getCustomerId()
            ));
        }
        return orderList;
    }

    public void add(PlaceOrder order) {
        PlaceOrderEntity entity = new PlaceOrderEntity(
                order.getId(),
                order.getDate(),
                order.getCustomerId()
        );
        placeOrderRepository.save(entity);
    }

    public PlaceOrder searchById(String orderId) {
        Optional<PlaceOrderEntity> optional = placeOrderRepository.findById(orderId);
        PlaceOrderEntity entity = optional.orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        return new PlaceOrder(
                entity.getId(),
                entity.getDate(),
                entity.getCustomerId()
        );
    }

    public void update(PlaceOrder order) {
        Optional<PlaceOrderEntity> optional = placeOrderRepository.findById(order.getId());
        PlaceOrderEntity entity = optional.orElseThrow(() -> new RuntimeException("Order not found with ID: " + order.getId()));

        entity.setDate(order.getDate());
        entity.setCustomerId(order.getCustomerId());

        placeOrderRepository.save(entity);
    }

    public void delete(String orderId) {
        Optional<PlaceOrderEntity> optional = placeOrderRepository.findById(orderId);
        PlaceOrderEntity entity = optional.orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        placeOrderRepository.delete(entity);
    }
}
