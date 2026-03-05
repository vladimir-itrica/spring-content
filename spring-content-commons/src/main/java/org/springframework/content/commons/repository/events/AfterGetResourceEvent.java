package org.springframework.content.commons.repository.events;

import org.springframework.content.commons.property.PropertyPath;
import org.springframework.content.commons.repository.AfterStoreEvent;
import org.springframework.content.commons.repository.Store;

import java.io.Serial;
import java.io.Serializable;

/**
 * @deprecated This class is deprecated. Use {@link org.springframework.content.commons.store.events.AfterGetResourceEvent} instead.
 */
public class AfterGetResourceEvent extends AfterStoreEvent {

    @Serial
    private static final long serialVersionUID = -52677793449429582L;

    public AfterGetResourceEvent(Object source, Store<Serializable> store) {
        super(source, store);
    }

    public AfterGetResourceEvent(Object source, PropertyPath propertyPath, Store<Serializable> store) {
        super(source, propertyPath, store);
    }
}
