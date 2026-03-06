package org.springframework.versions;

import java.io.Serial;

public class LockingAndVersioningException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -6377546514718461921L;

    public LockingAndVersioningException() {
    }

    public LockingAndVersioningException(String message) {
        super(message);
    }

    public LockingAndVersioningException(String message, Throwable cause) {
        super(message, cause);
    }

    public LockingAndVersioningException(Throwable cause) {
        super(cause);
    }

    public LockingAndVersioningException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
