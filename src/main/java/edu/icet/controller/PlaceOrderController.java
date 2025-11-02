package edu.icet.controller;

import edu.icet.model.dto.PlaceOrder;
import edu.icet.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("placeOrder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @GetMapping
    public List<PlaceOrder> getAllOrders() {
        return placeOrderService.getAllOrders();
    }

    @PostMapping
    public void add(@RequestBody PlaceOrder order) {
        placeOrderService.add(order);
    }

    @PutMapping
    public void update(@RequestBody PlaceOrder order) {
        placeOrderService.update(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String orderId) {
        placeOrderService.delete(orderId);
    }
}
