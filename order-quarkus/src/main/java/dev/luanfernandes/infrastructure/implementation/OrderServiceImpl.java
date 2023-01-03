package dev.luanfernandes.infrastructure.implementation;


import dev.luanfernandes.domain.dto.CustomerDTO;
import dev.luanfernandes.domain.dto.OrderDTO;
import dev.luanfernandes.domain.service.OrderService;
import dev.luanfernandes.infrastructure.client.CustomerClient;
import dev.luanfernandes.infrastructure.client.ProductClient;
import dev.luanfernandes.infrastructure.repository.OrderRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;


@ApplicationScoped
public class OrderServiceImpl implements OrderService {
    @Inject
    OrderRepository orderRepository;

    @Inject
    @RestClient
    CustomerClient customerClient;

    @Inject
    @RestClient
    ProductClient productClient;


    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(OrderDTO::new).toList();
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        return new OrderDTO(orderRepository.findById(id));
    }

    @Override
    @Transactional
    public void createOrder(OrderDTO orderDTO){
        CustomerDTO customerDTO = customerClient.getCustomerByID(orderDTO.getCustomerId());
        if (customerDTO.getName().equals(orderDTO.getCustomerName()) &&
        productClient.getProductByID(orderDTO.getProductId()) != null){
            orderRepository.persist(orderDTO.toEntity());
        }else {
            throw new NotFoundException();
        }

    }

    @Override
    @Transactional
    public void updateOrder(Long id, OrderDTO orderDTO){
        var obj = orderRepository.findById(id);
        obj.setCustomerId(orderDTO.getCustomerId());
        obj.setCustomerName(orderDTO.getCustomerName());
        obj.setProductId(orderDTO.getProductId());
        obj.setOrderValue(orderDTO.getOrderValue());
        orderRepository.persist(obj);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
