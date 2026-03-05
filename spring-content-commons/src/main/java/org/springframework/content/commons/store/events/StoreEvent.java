package org.springframework.content.commons.store.events;

import org.springframework.content.commons.property.PropertyPath;
import org.springframework.content.commons.repository.Store;

import java.io.Serial;
import java.io.Serializable;

public class StoreEvent extends org.springframework.content.commons.repository.StoreEvent {
    @Serial
    private static final long serialVersionUID = -4985896308323075130L;

    public StoreEvent(Object source, Store<Serializable> store) {
        super(source, store);
    }

    public StoreEvent(Object source, PropertyPath propertyPath, Store<Serializable> store) {
        super(source, propertyPath, store);
    }
}
