package internal.org.springframework.content.commons.store.factory;

import org.springframework.content.commons.property.PropertyPath;
import org.springframework.content.commons.store.ReactiveContentStore;
import org.springframework.context.ApplicationEventPublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class ReactiveStoreImpl implements ReactiveContentStore<Object, Serializable> {

    private final ReactiveContentStore<Object, Serializable> delegate;
    private final ApplicationEventPublisher publisher;

    public ReactiveStoreImpl(ReactiveContentStore<Object, Serializable> delegate, ApplicationEventPublisher publisher) {
        this.delegate = delegate;
        this.publisher = publisher;
    }

    @Override
    public Mono<Object> setContent(Object entity, PropertyPath path, long contentLen, Flux<ByteBuffer> buffer) {
        return delegate.setContent(entity, path, contentLen, buffer);
    }

    @Override
    public Flux<ByteBuffer> getContent(Object entity, PropertyPath path) {
        return delegate.getContent(entity, path);
    }

    @Override
    public Mono<Object> unsetContent(Object entity, PropertyPath propertyPath) {
        return delegate.unsetContent(entity, propertyPath);
    }
}
