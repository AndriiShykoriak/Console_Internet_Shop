package com.company.order.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private int id;

    public void setId(int id) {
        this.id = id;
    }
}
