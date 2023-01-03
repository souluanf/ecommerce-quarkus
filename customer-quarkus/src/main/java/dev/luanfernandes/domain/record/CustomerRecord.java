package dev.luanfernandes.domain.record;

public record CustomerRecord(
        String name,
        String phone,
        String email,
        String address,
        Long age
) {
}
