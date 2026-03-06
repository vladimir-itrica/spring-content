package it.typesupport.model;

import java.util.UUID;

public class UUIDBasedContentEntity extends ContentEntity<UUID> implements IdGenerator<UUID> {
    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
