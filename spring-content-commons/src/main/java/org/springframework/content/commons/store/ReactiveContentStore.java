package org.springframework.content.commons.store;

import org.springframework.content.commons.property.PropertyPath;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;

public interface ReactiveContentStore<S> {

    Mono<S> setContent(S entity, PropertyPath path, long contentLen, Flux<ByteBuffer> buffer);

    Flux<ByteBuffer> getContent(S entity, PropertyPath path);

    Mono<S> unsetContent(S entity, PropertyPath propertyPath);
}
