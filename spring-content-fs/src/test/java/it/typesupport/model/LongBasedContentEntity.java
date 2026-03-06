package it.typesupport.model;

import java.util.Random;

public class LongBasedContentEntity extends ContentEntity<Long> implements IdGenerator<Long> {
    @Override
    public Long generateId() {
        Random r = new Random();
        return r.nextLong();
    }
}
