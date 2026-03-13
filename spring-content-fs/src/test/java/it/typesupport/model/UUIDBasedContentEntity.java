package it.typesupport.model;

import com.github.f4b6a3.uuid.UuidCreator;

import java.util.UUID;

public class UUIDBasedContentEntity extends ContentEntity<UUID> implements IdGenerator<UUID> {
    @Override
    public UUID generateId() {
        return UuidCreator.getTimeOrdered();
    }
}
