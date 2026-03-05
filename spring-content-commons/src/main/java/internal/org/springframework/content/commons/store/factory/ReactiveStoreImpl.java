package internal.org.springframework.content.commons.store.factory;

import org.springframework.content.commons.property.PropertyPath;
import org.springframework.content.commons.store.ReactiveContentStore;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;

public class ReactiveStoreImpl implements ReactiveContentStore<Object> {

    private final ReactiveContentStore<Object> delegate;

    public ReactiveStoreImpl(ReactiveContentStore<Object> delegate) {
        this.delegate = delegate;
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
