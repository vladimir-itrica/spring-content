package org.springframework.content.commons.repository;

import lombok.Builder;
import lombok.Data;

/**
 * @deprecated This class is deprecated. Use {@link org.springframework.content.commons.store.GetResourceParams}
 * instead.
 */
@Deprecated
@Data
@Builder
public class GetResourceParams {

    private String range;
}
