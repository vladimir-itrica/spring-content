package org.springframework.content.commons.renditions;

import java.io.InputStream;

public interface RenditionProvider {
    String consumes();

    String[] produces();

    InputStream convert(InputStream fromInputSource, String toMimeType);
}
