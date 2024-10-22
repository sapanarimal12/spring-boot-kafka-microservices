package com.sapana.basedomains.dto;

import lombok.*;

/**
 * Author: Sapana Rimal
 * Date: 10/22/2024
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private String orderId;
    private String name;
    private int quantity;
    private double price;

}
