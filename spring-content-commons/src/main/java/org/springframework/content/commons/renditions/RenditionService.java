package org.springframework.content.commons.renditions;

import java.io.InputStream;

public interface RenditionService {
    boolean canConvert(String fromMimeType, String toMimeType);

    String[] conversions(String fromMimeType);

    InputStream convert(String fromMimeType, InputStream fromInputSource,
                        String toMimeType);
}
