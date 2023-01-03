package dev.luanfernandes.api.v1.controller;

import dev.luanfernandes.domain.dto.ProductDTO;
import dev.luanfernandes.domain.service.ProductService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api/v1/products")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> findAll() {
        return productService.getAllProducts();
    }

    @GET
    @Path("/{id}")
    @ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO findById(@PathParam("id") Long id) {
        return productService.getProductById(id);
    }

    @POST
    @ResponseStatus(201)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }

    @PUT
    @Path("/{id}")
    @ResponseStatus(204)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(@PathParam("id") Long id, ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
    }

    @DELETE
    @Path("/{id}")
    @ResponseStatus(204)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        productService.deleteProduct(id);
    }
}