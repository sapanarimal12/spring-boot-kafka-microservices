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
public class OrderEvent {

    private String message;
    private String status;
    private Order order;
}
