package edu.icet.controller;

import edu.icet.model.dto.OrderDetails;
import edu.icet.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping
    public List<OrderDetails> getAllDetails() {
        return orderDetailsService.getAllDetails();
    }

    @PostMapping
    public void add(@RequestBody OrderDetails details) {
        orderDetailsService.add(details);
    }

    @PutMapping
    public void update(@RequestBody OrderDetails details) {
        orderDetailsService.update(details);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        orderDetailsService.delete(id);
    }
}
