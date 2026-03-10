package org.springframework.content.commons.repository;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @deprecated This interface is deprecated. Use fragments instead.
 */
@Deprecated
public interface StoreInvoker {

    Class<?> getDomainClass();

    Class<? extends Serializable> getContentIdClass();

    InputStream invokeGetContent();
}
