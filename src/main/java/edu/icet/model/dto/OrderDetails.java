package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OrderDetails {

    private String id;
    private String code;
    private Integer qty;
}
