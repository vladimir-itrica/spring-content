package internal.org.springframework.content.rest.support;

import java.util.UUID;

import org.springframework.content.fs.store.FileSystemContentStore;
import org.springframework.content.rest.StoreRestResource;

@StoreRestResource(path = "files")
public interface TestEntity2Store extends FileSystemContentStore<TestEntity2, UUID> {
}
