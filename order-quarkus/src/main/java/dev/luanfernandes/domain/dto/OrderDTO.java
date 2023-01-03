package dev.luanfernandes.domain.dto;

import dev.luanfernandes.domain.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long orderId;
    private Long customerId;
    private String customerName;
    private Long productId;
    private BigDecimal orderValue;
    public OrderDTO(OrderEntity orderEntity) {
        this.orderId = orderEntity.getOrderId();
        this.customerId = orderEntity.getCustomerId();
        this.customerName = orderEntity.getCustomerName();
        this.productId = orderEntity.getProductId();
        this.orderValue = orderEntity.getOrderValue();
    }


    public OrderEntity toEntity(){
        return OrderEntity.builder()
                .customerId(customerId)
                .customerName(customerName)
                .productId(productId)
                .orderValue(orderValue)
                .build();
    }
}