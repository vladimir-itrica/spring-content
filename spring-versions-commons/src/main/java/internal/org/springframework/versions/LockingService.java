package internal.org.springframework.versions;

import java.security.Principal;

public interface LockingService {

    /**
     * Locks the given entity for the given principal. If no lock exists for the given entity
     * then the lock will be obtained.
     *
     * @param entityId  the entity to lock
     * @param principal the lock owner
     * @return {@code true} if lock succeeds, otherwise {@code false}
     */
    boolean lock(Object entityId, Principal principal);

    /**
     * Unlocks the given entity for the current principal. If the current principal holds the lock
     * it will be released.
     *
     * @param entityId  the entity to unlock
     * @param principal the lock owner
     * @return {@code true} if unlock succeeds, otherwise {@code false}
     */
    boolean unlock(Object entityId, Principal principal);

    /**
     * Checks if the given principal holds the lock for the given entity.
     *
     * @param entityId  the entity with the lock
     * @param principal the principal
     * @return {@code true} if the given principal holds the lock for the given entity
     */
    boolean isLockOwner(Object entityId, Principal principal);

    /**
     * Returns the lock owner, or {@code null} if not locked
     *
     * @param entityId the entity with the lock
     * @return lock owner
     */
    Principal lockOwner(Object entityId);
}
