package org.springframework.content.commons.fragments;

import org.springframework.content.commons.repository.ContentStore;

import java.io.Serializable;

public interface ContentStoreAware {

    void setDomainClass(Class<?> domainClass);

    void setIdClass(Class<?> idClass);

    void setContentStore(ContentStore<Object, Serializable> store);

    void setContentStore(org.springframework.content.commons.store.ContentStore<Object, Serializable> store);
}
