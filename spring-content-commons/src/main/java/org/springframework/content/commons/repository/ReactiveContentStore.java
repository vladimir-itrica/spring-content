package org.springframework.content.commons.repository;

import java.nio.ByteBuffer;

import org.springframework.content.commons.property.PropertyPath;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @deprecated This interface is deprecated. Use {@link org.springframework.content.commons.store.ReactiveContentStore}
 * instead.
 */
@Deprecated
public interface ReactiveContentStore<S> extends ContentRepository {

    Mono<S> setContent(S entity, PropertyPath path, long contentLen, Flux<ByteBuffer> buffer);

    Flux<ByteBuffer> getContent(S entity, PropertyPath path);

    Mono<S> unsetContent(S entity, PropertyPath propertyPath);
}
