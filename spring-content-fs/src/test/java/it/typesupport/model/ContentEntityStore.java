package it.typesupport.model;

import org.springframework.content.commons.property.PropertyPath;
import org.springframework.content.commons.store.ContentStore;
import org.springframework.content.commons.store.GetResourceParams;
import org.springframework.content.commons.store.SetContentParams;
import org.springframework.content.commons.store.UnsetContentParams;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.io.Serializable;

public class ContentEntityStore<S, SID extends Serializable> implements ContentStore<S, SID> {
    @Override
    public S setContent(S entity, InputStream content) {
        return null;
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, InputStream content) {
        return null;
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, InputStream content, long contentLen) {
        return null;
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, InputStream content, SetContentParams params) {
        return null;
    }

    @Override
    public S setContent(S entity, Resource resourceContent) {
        return null;
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, Resource resourceContent) {
        return null;
    }

    @Override
    public S unsetContent(S entity) {
        return null;
    }

    @Override
    public S unsetContent(S entity, PropertyPath propertyPath) {
        return null;
    }

    @Override
    public S unsetContent(S entity, PropertyPath propertyPath, UnsetContentParams params) {
        return null;
    }

    @Override
    public InputStream getContent(S entity) {
        return null;
    }

    @Override
    public InputStream getContent(S entity, PropertyPath propertyPath) {
        return null;
    }

    @Override
    public Resource getResource(S entity) {
        return null;
    }

    @Override
    public Resource getResource(S entity, PropertyPath propertyPath) {
        return null;
    }

    @Override
    public Resource getResource(S entity, PropertyPath propertyPath, GetResourceParams params) {
        return null;
    }

    @Override
    public void associate(S entity, SID id) {

    }

    @Override
    public void associate(S entity, PropertyPath propertyPath, SID id) {

    }

    @Override
    public void unassociate(S entity) {

    }

    @Override
    public void unassociate(S entity, PropertyPath propertyPath) {

    }

    @Override
    public Resource getResource(SID id) {
        return null;
    }
}
