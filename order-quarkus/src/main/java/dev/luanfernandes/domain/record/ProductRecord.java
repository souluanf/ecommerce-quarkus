package dev.luanfernandes.domain.record;

import java.math.BigDecimal;

public record ProductRecord(
        String name,
        String description,
        String catergory,
        String model,
        BigDecimal price
) {
}
