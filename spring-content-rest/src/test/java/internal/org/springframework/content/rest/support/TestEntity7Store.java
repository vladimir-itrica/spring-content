package internal.org.springframework.content.rest.support;

import java.util.UUID;

import org.springframework.content.commons.renditions.Renderable;
import org.springframework.content.fs.store.FileSystemContentStore;

public interface TestEntity7Store extends FileSystemContentStore<TestEntity7, UUID>, Renderable<TestEntity7> {
}
