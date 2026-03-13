package internal.org.springframework.content.rest.support;

import org.springframework.content.commons.renditions.Renderable;
import org.springframework.content.fs.store.FileSystemContentStore;

public interface TestEntityChildContentRepository extends FileSystemContentStore<TestEntityChild, String>, Renderable<TestEntityChild> {
}
