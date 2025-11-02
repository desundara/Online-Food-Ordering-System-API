package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlaceOrder {

    private String id;
    private LocalDate date;
    private String customerId;
}
