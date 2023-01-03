package dev.luanfernandes.domain.service;

import dev.luanfernandes.domain.dto.OrderDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long id);

    @Transactional
    void createOrder(OrderDTO orderDTO);

    @Transactional
    void updateOrder(Long id, OrderDTO orderDTO);

    @Transactional
    void deleteOrder(Long id);
}
