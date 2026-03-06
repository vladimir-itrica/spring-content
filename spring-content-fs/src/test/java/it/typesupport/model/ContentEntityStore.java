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
    private final String NOT_SUPPORTED_OPERATION = "The method is not supported in the test class.";

    @Override
    public S setContent(S entity, InputStream content) {
        // TODO: implement
        return null;
    }

    @Override
    public S unsetContent(S entity) {
        // TODO: implement
        return null;
    }

    @Override
    public InputStream getContent(S entity) {
        // TODO: implement
        return null;
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, InputStream content) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, InputStream content, long contentLen) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, InputStream content, SetContentParams params) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public S setContent(S entity, Resource resourceContent) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public S setContent(S entity, PropertyPath propertyPath, Resource resourceContent) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public S unsetContent(S entity, PropertyPath propertyPath) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public S unsetContent(S entity, PropertyPath propertyPath, UnsetContentParams params) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public InputStream getContent(S entity, PropertyPath propertyPath) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public Resource getResource(S entity) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public Resource getResource(S entity, PropertyPath propertyPath) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public Resource getResource(S entity, PropertyPath propertyPath, GetResourceParams params) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public void associate(S entity, SID id) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public void associate(S entity, PropertyPath propertyPath, SID id) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public void unassociate(S entity) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public void unassociate(S entity, PropertyPath propertyPath) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }

    @Override
    public Resource getResource(SID id) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_OPERATION);
    }
}
