package edu.icet.service;

import edu.icet.model.dto.OrderDetails;
import edu.icet.model.entity.OrderDetailsEntity;
import edu.icet.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> getAllDetails() {
        List<OrderDetailsEntity> allEntities = orderDetailsRepository.findAll();
        List<OrderDetails> detailsList = new ArrayList<>();

        for (OrderDetailsEntity entity : allEntities) {
            detailsList.add(new OrderDetails(
                    entity.getId(),
                    entity.getCode(),
                    entity.getQty()
            ));
        }
        return detailsList;
    }

    public void add(OrderDetails details) {
        OrderDetailsEntity entity = new OrderDetailsEntity(
                details.getId(),
                details.getCode(),
                details.getQty()
        );
        orderDetailsRepository.save(entity);
    }

    public void update(OrderDetails details) {
        OrderDetailsEntity entity = new OrderDetailsEntity(
                details.getId(),
                details.getCode(),
                details.getQty()
        );
        orderDetailsRepository.save(entity);
    }

    public void delete(String id) {
        orderDetailsRepository.deleteById(id);
    }
}
