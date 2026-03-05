package org.springframework.versions;

import org.springframework.core.NestedRuntimeException;

import java.io.Serial;

public class LockOwnerException extends NestedRuntimeException {
    @Serial
    private static final long serialVersionUID = -6480169945544903072L;

    public LockOwnerException(String msg) {
        super(msg);
    }

    public LockOwnerException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
