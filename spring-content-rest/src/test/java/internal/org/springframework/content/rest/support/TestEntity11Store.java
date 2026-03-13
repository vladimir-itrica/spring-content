package internal.org.springframework.content.rest.support;

import org.springframework.content.commons.renditions.Renderable;
import org.springframework.content.fs.store.FileSystemContentStore;
import org.springframework.content.rest.StoreRestResource;

import java.util.UUID;

@StoreRestResource(/*linkRel = "foo"*/)
public interface TestEntity11Store extends FileSystemContentStore<TestEntity11, UUID>, Renderable<TestEntity11> {
}
