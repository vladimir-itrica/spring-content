package org.springframework.versions;

import org.springframework.aop.framework.ProxyFactory;

public interface LockingAndVersioningProxyFactory {
    void apply(ProxyFactory result);
}
