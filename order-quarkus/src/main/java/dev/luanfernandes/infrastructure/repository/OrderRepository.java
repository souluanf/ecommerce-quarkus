package dev.luanfernandes.infrastructure.repository;

import dev.luanfernandes.domain.entity.OrderEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<OrderEntity> {
}
