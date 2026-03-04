package org.springframework.versions;

import org.springframework.core.NestedRuntimeException;

public class LockOwnerException extends NestedRuntimeException {

    public LockOwnerException(String msg) {
        super(msg);
    }

    public LockOwnerException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
