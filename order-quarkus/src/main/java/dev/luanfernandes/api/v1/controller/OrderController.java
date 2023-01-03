package dev.luanfernandes.api.v1.controller;

import dev.luanfernandes.domain.dto.OrderDTO;
import dev.luanfernandes.domain.service.OrderService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api/v1/orders")
public class OrderController {

    @Inject
    OrderService orderService;

    @GET
    @RolesAllowed({"user","admin"})
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDTO> findAll() {
        return orderService.getAllOrders();
    }

    @GET
    @Path("/{id}")
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDTO findById(@PathParam("id") Long id) {
        return orderService.getOrderById(id);
    }

    @POST
    @ResponseStatus(201)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
    }

    @PUT
    @Path("/{id}")
    @ResponseStatus(204)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(@PathParam("id") Long id, OrderDTO orderDTO) {
        orderService.updateOrder(id, orderDTO);
    }

    @DELETE
    @Path("/{id}")
    @ResponseStatus(204)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        orderService.deleteOrder(id);
    }
}