package edu.icet.repository;

import edu.icet.model.entity.PlaceOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceOrderRepository extends JpaRepository<PlaceOrderEntity, String> {

}
