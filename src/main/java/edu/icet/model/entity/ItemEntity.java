package edu.icet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ItemEntity {

    @Id
    private String code;
    private String description;
    private Double unitPrice;
    private Integer qty;
}
