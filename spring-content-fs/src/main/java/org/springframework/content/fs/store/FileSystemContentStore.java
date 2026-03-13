package org.springframework.content.fs.store;

import java.io.Serializable;

import org.springframework.content.commons.store.ContentStore;

public interface FileSystemContentStore<I, CID extends Serializable> extends ContentStore<I, CID> {
}
