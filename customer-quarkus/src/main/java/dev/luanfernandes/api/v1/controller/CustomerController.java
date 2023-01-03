package dev.luanfernandes.api.v1.controller;

import dev.luanfernandes.domain.dto.CustomerDTO;
import dev.luanfernandes.domain.service.CustomerService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api/v1/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> findAll() {
        return customerService.findAllCustomers();
    }

    @GET
    @Path("/{id}")
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO findById(@PathParam("id") Long id) {
        return customerService.findustomerById(id);
    }

    @POST
    @ResponseStatus(201)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
    }

    @PUT
    @Path("/{id}")
    @ResponseStatus(204)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(@PathParam("id") Long id, CustomerDTO customerDTO) {
        customerService.updateCustomer(id, customerDTO);
    }

    @DELETE
    @Path("/{id}")
    @ResponseStatus(204)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        customerService.deleteCustomer(id);
    }
}