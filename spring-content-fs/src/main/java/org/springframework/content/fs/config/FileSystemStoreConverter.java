package org.springframework.content.fs.config;

import org.springframework.core.convert.converter.Converter;

public interface FileSystemStoreConverter<S, T> extends Converter<S, T> {
}
